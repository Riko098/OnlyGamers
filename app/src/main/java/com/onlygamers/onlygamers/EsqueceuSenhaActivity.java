package com.onlygamers.onlygamers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class EsqueceuSenhaActivity extends AppCompatActivity {

    Toolbar toolbarSenha;
    ProgressBar progressBar;
    EditText etEsqueceuSenha;
    Button btnEnviarSenha;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueceu_senha);
        toolbarSenha=findViewById(R.id.toolbarSenha);
        progressBar=findViewById(R.id.progressBar);
        etEsqueceuSenha=findViewById(R.id.etEsqueceuSenha);
        btnEnviarSenha=findViewById(R.id.btnEnviarSenha);

        toolbarSenha.setTitle("Esqueceu sua senha");
        firebaseAuth = FirebaseAuth.getInstance();

        btnEnviarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.sendPasswordResetEmail(etEsqueceuSenha.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()){
                            Toast.makeText(EsqueceuSenhaActivity.this, "Verifique seu email para redefinir sua senha", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(EsqueceuSenhaActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });

    }
}
