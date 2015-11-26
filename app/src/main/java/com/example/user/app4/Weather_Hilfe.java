package com.example.user.app4;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Weather_Hilfe {

    public static void getWeather(final View rootView) {

        new AsyncTask<Void, Void, API.ApiResponse>() {

            private void placeWeatherInfo(String info) {
                TextView cityView = (TextView) rootView.findViewById(R.id.textCity);
                TextView dateView = (TextView) rootView.findViewById(R.id.textDate);
                TextView tempView = (TextView) rootView.findViewById(R.id.textTemp);

                try {
                    JSONObject resp = new JSONObject(info);
                    JSONObject city = resp.getJSONObject("city");
                    JSONArray weatherList = resp.getJSONArray("list");
                    JSONObject today = weatherList.getJSONObject(0);
                    JSONObject mainInfo = today.getJSONObject("main");
                    double temp = mainInfo.getDouble("temp");
                    String date = today.getString("dt_txt");
                    String cityName = city.getString("name");

                    cityView.setText(cityName);
                    dateView.setText(date);
                    tempView.setText("temperature: " + temp);

                    cityView.setVisibility(View.VISIBLE);
                    dateView.setVisibility(View.VISIBLE);
                    tempView.setVisibility(View.VISIBLE);
                } catch (Exception e) { /* Emptiness */ }
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected API.ApiResponse doInBackground(Void... x) {
                ArrayList<String> params = new ArrayList<String>();
                params.add("id");
                //params.add("501183"); //id города Rostov
                //params.add("498677"); //id города Saratov
                params.add("6691073"); //id города Köln
                params.add("APPID");

                params.add("609ec380cf6abb9ea4270abe9cd4a2a8");
                params.add("lang");
                params.add("ru");
                params.add("units");
                params.add("metric");

                return API.execute( API.ApiMethod.GET_WEATHER.format(),
                        API.HttpMethod.GET,
                        params.toArray(new String[params.size()])
                );
            }

            @Override
            protected void onPostExecute(API.ApiResponse apiResponse) {
                super.onPostExecute(apiResponse);

                try {
                    if (apiResponse.isSuccess()) {
                        android.util.Log.d("Weather",apiResponse.getJson().toString());

                    }

                } catch (Exception e) {
                    android.util.Log.e("Weather", "ALERT! ALERT! Exception!", e);
                }

                placeWeatherInfo(apiResponse.getJson().toString());
            }
        }.execute();
    }
}
