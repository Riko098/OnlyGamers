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


        //Gerencia o estado das configurações para um WebView.-
        // Quando um WebView é criado, ele obtém um conjunto de configurações padrão. Essas configurações padrão -
        // serão retornadas de qualquer chamada getter.

        WebSettings webSettings = webFree.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webFree.loadUrl("https://freefirenews.com");


    }

    @Override
    //SOBRESCREVENDO O METODO COM O  OnbackPressed
    //SERVE PARA QUANDO CLICAR NO BOTÃO VOLTAR ELE RETORNA PARA O APP
    public void onBackPressed() {
        if (webFree.canGoBack()){
            webFree.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
