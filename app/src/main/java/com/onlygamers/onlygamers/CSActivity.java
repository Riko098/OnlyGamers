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
        //PEGANDO URL DO PORTAL DE NOTICIAS DE CSGO
        webCS.setWebViewClient(new WebViewClient());
        webCS.loadUrl("https://www.teamplay.com.br/jogo/counter-strike-global-offensive");

        //Gerencia o estado das configurações para um WebView.-
        // Quando um WebView é criado, ele obtém um conjunto de configurações padrão. Essas configurações padrão -
        // serão retornadas de qualquer chamada getter.
        WebSettings webSettings = webCS.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }

    @Override
    //SOBRESCREVENDO O METODO COM O  OnbackPressed
    //SERVE PARA QUANDO CLICAR NO BOTÃO VOLTAR ELE RETORNA PARA O APP
    public void onBackPressed() {
        if (webCS.canGoBack()){
            webCS.goBack();
        }else {
            super.onBackPressed();
        }
    }
}

