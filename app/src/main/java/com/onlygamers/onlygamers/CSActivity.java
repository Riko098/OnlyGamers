package com.onlygamers.onlygamers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toolbar;

public class CSActivity extends AppCompatActivity {


    WebView webCS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs);
        webCS=(WebView) findViewById(R.id.webCS);

        webCS.setWebViewClient(new WebViewClient());
        webCS.loadUrl("https://www.hltv.org");

        WebSettings webSettings = webCS.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }

    @Override
    public void onBackPressed() {
        if (webCS.canGoBack()){
            webCS.goBack();
        }else {
            super.onBackPressed();
        }
    }
}

