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
        //PEGANDO URL DO PORTAL DE NOTICIAS DE LEAGUE OF LEGEDNS
        //WebView permitem exibir o conteúdo da Web como parte do layout da atividade
        webLOL.setWebViewClient(new WebViewClient());
        webLOL.loadUrl("http://mycnb.uol.com.br");

        //Gerencia o estado das configurações para um WebView.-
        // Quando um WebView é criado, ele obtém um conjunto de configurações padrão. Essas configurações padrão -
        // serão retornadas de qualquer chamada getter.
        WebSettings webSettings = webLOL.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }

    @Override
    //SOBRESCREVENDO O METODO COM O  OnbackPressed
    //SERVE PARA QUANDO CLICAR NO BOTÃO VOLTAR ELE RETORNA PARA O APP
    public void onBackPressed() {
        if (webLOL.canGoBack()){
            webLOL.goBack();
        }else {
            super.onBackPressed();
        }
    }
}

