package com.example.user.app4;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


public class WebFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_web, container, false);
        WebView web = (WebView) rootView.findViewById(R.id.web);
        final ProgressBar progress = (ProgressBar) rootView.findViewById(R.id.progress);
        web.loadUrl("http://vk.com/");
        progress.setVisibility(View.VISIBLE);

        web.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                progress.setVisibility(View.GONE);
            }
        });
        return rootView;
    }


}
