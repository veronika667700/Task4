package com.example.user.app4;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class API {
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast";
    public static final int DEFAULT_CONNECTION_TIMEOUT = 15000;
    public static final int DEFAULT_READ_TIMEOUT = 60000;

    public enum HttpMethod {
        POST,
        GET
    }

    public enum Error {
        NO_ERROR(0)
        , UNKNOWN_ERROR(1)
        , INVALID_TOKEN(401)
        , SERVICE_ERROR(500);

        private int code;

        public int getCode() {
            return code;
        }

        private Error(int code) {
            this.code = code;
        }

        private static Error fromCode(int code) {
            for (Error er : Error.values()) {
                if (er.getCode() == code) {
                    return er;
                }
            }
            return Error.UNKNOWN_ERROR;
        }
    }

    public enum ApiMethod {
        GET_WEATHER(HttpMethod.GET, "city");

        private final String path;
        private final HttpMethod httpMethod;

        private ApiMethod(HttpMethod httpMethod, String path) {
            this.path = path;
            this.httpMethod = httpMethod;
        }

        public String format(String... args) {
            return String.format(path, args);
        }

        public HttpMethod getHttpMethod() {
            return httpMethod;
        }

    }

    public static final class ApiResponse {
        private boolean success;
        private int statusCode;
        private Error error;
        private String errorString;
        private JSONObject json;

        public ApiResponse(Error error) {
            this.error = error;
            success = error == Error.NO_ERROR;
        }

        public ApiResponse(int statusCode, String responseString) throws IOException, JSONException {
            this.statusCode = statusCode;
            this.json = new JSONObject(responseString);
            this.success = statusCode == 200;
            if (!success) {
                this.errorString = responseString;
                int errorCode = 401;
                this.error = Error.fromCode(errorCode);

            } else {
                error = Error.NO_ERROR;
            }
        }

        public JSONObject getJson() {
            return json;
        }

        public boolean isSuccess() {
            return success;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public String getErrorString() {
            return errorString;
        }

        public Error getError() {
            return error;
        }

    }

    private static String getParamsString(String... args) {
        StringBuilder builder = new StringBuilder();
        if (args.length % 2 != 0)
            throw new IllegalArgumentException("Request parameters should come in pairs");
        for (int i = 0; i < args.length; i += 2) {
            if (i != 0)
                builder.append("&");
            builder.append(args[i]);
            builder.append("=");
            try {

                builder.append(URLEncoder.encode(args[i + 1], "UTF-8"));
            } catch (UnsupportedEncodingException e) {
            }
        }
        return builder.toString();
    }

    public static ApiResponse execute(String path, HttpMethod method, String... args) {
        //Добавить проверку на наличие Интернет подключения до запроса на сервер
        //======================================================================
        ApiResponse response;
        if (method == HttpMethod.GET) {
            response = executeGet(path, args);
        } else if (method == HttpMethod.POST) {
            response = executePost(String.format("%s/%s", BASE_URL, path), getParamsString(args));
        } else {
            throw new IllegalArgumentException("Unknown http method " + method);
        }
        return response;
    }

    public static String getRequestPath(String path, String... params) {
        String query = getParamsString(params);

        if (params.length == 0) {
            return path;
        } else {
            return String.format("%s?%s", path, query);
        }
    }

    private static String getRequestUrl(String path, String... params) {
        return String.format("%s/%s", BASE_URL, getRequestPath(path, params));
    }

    public static ApiResponse executeGet(String path, String... params) {
        return executeGet(getRequestUrl(path, params));
    }

    private static ApiResponse executeGet(String url) {

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod(HttpMethod.GET.toString());
            connection.setConnectTimeout(DEFAULT_CONNECTION_TIMEOUT);
            connection.setReadTimeout(DEFAULT_READ_TIMEOUT);
            connection.setDoInput(true);
            connection.setDoOutput(false);
            connection.setUseCaches(false);

            Log.i("Network", connection.getURL().getQuery() );
            int responseCode = connection.getResponseCode();
            String response;
            if (responseCode == 200) {
                response = InputStreamUtils.toString(connection.getInputStream());
            } else {
                response = InputStreamUtils.toString(connection.getErrorStream());
            }

            switch (responseCode) {
                case 200:
                    return new ApiResponse(responseCode, response);
                case 401:
                    return new ApiResponse(Error.INVALID_TOKEN.getCode(), response);
                case 500:
                    return new ApiResponse(Error.SERVICE_ERROR.getCode(), response);
                default:
                    return new ApiResponse(Error.UNKNOWN_ERROR);
            }
        } catch (Exception e) {
            return new ApiResponse(Error.UNKNOWN_ERROR);
        }
    }

    private static ApiResponse executePost(String url, String entity) {

        OutputStream ostream = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(DEFAULT_CONNECTION_TIMEOUT);
            connection.setReadTimeout(DEFAULT_READ_TIMEOUT);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod(HttpMethod.POST.toString());

            Log.i("Network", connection.getURL().getQuery());
            ostream = new DataOutputStream(connection.getOutputStream());
            ostream.write(entity.getBytes("UTF-8"));

            int responseCode = connection.getResponseCode();
            String response;
            if (responseCode == 200) {
                response = InputStreamUtils.toString(connection.getInputStream());
            } else {
                response = InputStreamUtils.toString(connection.getErrorStream());
            }

            switch (responseCode) {
                case 200:
                    return new ApiResponse(responseCode, response);
                case 401:
                    return new ApiResponse(Error.INVALID_TOKEN.getCode(), response);
                case 500:
                    return new ApiResponse(Error.SERVICE_ERROR.getCode(), response);
                default:
                    return new ApiResponse(Error.UNKNOWN_ERROR);
            }

        } catch (Exception e) {
            return new ApiResponse(Error.UNKNOWN_ERROR);
        } finally {
            try {
                if (ostream != null)
                    ostream.close();
            } catch (Exception ignore) { /* ignore */ }
        }
    }
}
