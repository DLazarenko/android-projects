package com.example.youtubeplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class YoutubeActivity extends AppCompatActivity {

    private WebView webview;
    public boolean flag = false;

    @Override
    protected void onPause() {
        super.onPause();
        webview.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        boolean isVideo = getIntent().getBooleanExtra("isVideo", true);
        webview.onResume();
        webview.postDelayed(new Runnable() {
            @Override
            public void run() {
                webview.evaluateJavascript("loadVideo("+isVideo+");", null);
            }
        }, 5000);
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        webview = findViewById(R.id.web_view);

        final WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);

        webview.setWebChromeClient(new WebChromeClient());
        webview.setPadding(0, 0, 0, 0);

        webview.loadUrl("file:///android_asset/page.html");
    }

}
