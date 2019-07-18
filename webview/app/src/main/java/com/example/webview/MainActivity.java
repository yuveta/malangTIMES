package com.example.webview;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR_MR1) {
            webView.getSettings().setDomStorageEnabled(true);
        }
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        }
        webView.clearCache(false);
        //webView.getSettings().setAllowUniversalAccessFromFileURLs(true);

        // Tiga baris di bawah ini agar laman yang dimuat dapat
        // melakukan zoom.
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);

        // Baris di bawah untuk menambahkan scrollbar di dalam WebView-nya
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        //webView.setWebViewClient(new WebViewClient());

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://malangtimes.com");
    }


    private class MyBrowser extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}


