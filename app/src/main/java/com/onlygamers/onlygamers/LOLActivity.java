package com.onlygamers.onlygamers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LOLActivity extends AppCompatActivity {

    WebView webLOL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lol);
        webLOL=(WebView) findViewById(R.id.webLOL);

        webLOL.setWebViewClient(new WebViewClient());
        webLOL.loadUrl("https://vs.com.br");

        WebSettings webSettings = webLOL.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }

    @Override
    public void onBackPressed() {
        if (webLOL.canGoBack()){
            webLOL.goBack();
        }else {
            super.onBackPressed();
        }
    }
}

