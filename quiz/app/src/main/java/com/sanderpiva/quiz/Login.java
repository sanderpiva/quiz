package com.sanderpiva.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.content.SharedPreferences;

public class Login extends AppCompatActivity {
    private EditText nome;
    private EditText email;
    private Button logar;

    private ProgressBar pb;

    private static final String PREFS_KEY = "dados";

    private static final String NOME = "nome";
    private static final String EMAIL = "email";
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Carregar o preferences
        preferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE);


        nome = findViewById(R.id.editTextNome);
        email = findViewById(R.id.editTextEmail);
        logar = findViewById(R.id.btnLogar);
        pb = findViewById(R.id.progressBar);
        pb.setVisibility(View.INVISIBLE);

        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome1 = nome.getText().toString();
                String email1 = email.getText().toString();

                if (!nome1.isEmpty() && !email1.isEmpty()) {
                    pb.setVisibility(View.VISIBLE);
                    // Crie um Handler para lidar com atrasos
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Defina a visibilidade do ProgressBar como invisível após 2 segundos (2000 milissegundos)
                            pb.setVisibility(View.INVISIBLE);
                        }
                    }, 2000); // 2000 milissegundos = 2 segundos
                    nome.setText("");
                    email.setText("");
                    Intent intent = new Intent(Login.this, Question1.class);
                    intent.putExtra("Nome", String.valueOf(nome));
                    intent.putExtra("Email", String.valueOf(email));
                    startActivity(intent);
                } else {
                    Toast.makeText(view.getContext(), "Preencha todos os dados", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //escreve info dentro do preferences
    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences.Editor editor = preferences.edit();
        String nomeCapturado = nome.getText().toString();

        if(!nomeCapturado.equals("")){
            editor.putString(NOME, nomeCapturado);
            editor.apply();
        }

        String emailCapturado = email.getText().toString();
        if(!emailCapturado.equals("")){
            editor.putString(EMAIL, emailCapturado);
            //editor.commit();// commit faz persistencia de forma sincrona ou
            editor.apply();
        }
    }
    //para carregar os dados inseridos nos textInputs, caso saia da tela
    @Override
    protected void onResume() {
        super.onResume();

        if(preferences.contains(NOME)){

            String nomeCapturado = preferences.getString(NOME,"");
            nome.setText(nomeCapturado);
        }

        if(preferences.contains(EMAIL)){

            String emailCapturado = preferences.getString(EMAIL,"");
            email.setText(emailCapturado);
        }
    }
}
