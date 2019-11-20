package com.onlygamers.onlygamers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.sax.StartElementListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ProgressBar progressBar;
    EditText email;
    EditText password;
    Button btnConfirmar;
    Button btnCadastro;
    Button btnEsqueceuSenha;


    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        progressBar=findViewById(R.id.progressBar);
        email=findViewById(R.id.etEmail);
        password=findViewById(R.id.etPassword);
        btnConfirmar=findViewById(R.id.btnConfirmar);
        btnCadastro=findViewById(R.id.btnCadastro);
        btnEsqueceuSenha=findViewById(R.id.btnEsqueceuSenha);


        toolbar.setTitle(R.string.app_name);
        firebaseAuth = firebaseAuth.getInstance();

       ///////////////////////////-CONFIGURANDO A AÇÃO DE CLIQUE NO BOTÃO (ENTRAR)-/////////////////////////////
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                         if (task.isSuccessful()){
                             if (firebaseAuth.getCurrentUser().isEmailVerified()){
                                 startActivity(new Intent(MainActivity.this, NoticiasActivity.class));

                             }else{
                                 Toast.makeText(MainActivity.this, "Verifique seu e-mail cadastrado para ativação da conta",Toast.LENGTH_LONG).show();
                             }

                         }else{
                             Toast.makeText(MainActivity.this, task.getException().getMessage(),Toast.LENGTH_LONG).show();
                         }
                    }
                });
            }
        });

        //-CONFIGURANDO A AÇÃO DE CLIQUE NO BOTÃO (CADASTRA-SE)
        //Ele tbm ira enviar para o email uma verificação  para o usuario  ter acesso ao login

        // TASK = Um método comum que retorna a Taské FirebaseAuth.signInAnonymously(). Ele retorna a, o Task<AuthResult>que significa que a tarefa retornará
        // um AuthResultobjeto quando for bem-sucedido:


        btnCadastro.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()){
                                            firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {

                                                    if (task.isSuccessful()){
                                                        Toast.makeText(MainActivity.this, "Cadastro realizado com sucesso, Verifique seu e-mail cadastrado",
                                                                Toast.LENGTH_LONG).show();


                                                    }else {
                                                        Toast.makeText(MainActivity.this, task.getException().getMessage(),
                                                                Toast.LENGTH_LONG).show();

                                                    }

                                                }
                                            });

                                        }else {

                                            Toast.makeText(MainActivity.this, "Erro no registro! Tente novamente",
                                                    Toast.LENGTH_LONG).show();

                                        }
                                    }
                                });
                            }
                        });
        //-CONFIGURANDO A AÇÃO DE CLIQUE NO BOTÃO (ESQUECEU SUA SENHA) ESSA AÇÃO IRA LEVAR PARA A ACTIVTY DE ESQUECEU SUA SENHA

        btnEsqueceuSenha.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent objetoIntent = new Intent(MainActivity.this, EsqueceuSenhaActivity.class);
                                startActivity(objetoIntent);
                            }
                        });


    }
}
