package com.onlygamers.onlygamers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FreeFireActivity extends AppCompatActivity {


     WebView webFree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freefire);
        webFree=(WebView) findViewById(R.id.webFree);


        //SETANDO A WEBVIEW PARA ACESSAR PORTAL DE FREE FIRE
        WebSettings webSettings = webFree.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webFree.loadUrl("https://freefirenews.com");


    }

    @Override
    public void onBackPressed() {
        if (webFree.canGoBack()){
            webFree.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
