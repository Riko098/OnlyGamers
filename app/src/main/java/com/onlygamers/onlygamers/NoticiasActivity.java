package com.onlygamers.onlygamers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NoticiasActivity extends AppCompatActivity {
    Button btnCS;
    Button btnLOL;
    Button btnFort;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        btnCS = (Button) findViewById(R.id.btnCS);
        btnCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent objeto1Intent = new Intent(NoticiasActivity.this, CSActivity.class);
                startActivity(objeto1Intent);
            }

        });
        btnLOL=findViewById(R.id.btnLOL);
        btnLOL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent objeto2Intent = new Intent(NoticiasActivity.this, LOLActivity.class);
                startActivity(objeto2Intent);
            }
        });
        btnFort=findViewById(R.id.btnFort);
        btnFort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent objeto3Intent = new Intent(NoticiasActivity.this, FORTActivity.class);
                startActivity(objeto3Intent);

            }
        });

    }
}
