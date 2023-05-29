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
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

public class Login extends AppCompatActivity {
    private EditText nome;
    private EditText idade;
    private Button logar;
    private ProgressBar pb;

    private static final String PREFS_KEY = "dados";

    private static final String NOME = "nome";
    private static final String IDADE = "idade";
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nome = findViewById(R.id.editTextNome);
        idade = findViewById(R.id.editTextIdade);
        logar = findViewById(R.id.btnLogar);
        pb = findViewById(R.id.progressBar);
        pb.setVisibility(View.INVISIBLE);

        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome1 = nome.getText().toString();
                String idade1 = idade.getText().toString();

                Integer idadeChecada = Integer.parseInt(idade1);

                if (!nome1.isEmpty() && !idade1.isEmpty()) {

                    if(idadeChecada>13){

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
                        Intent intent = new Intent(getBaseContext(), Question1.class);
                        intent.putExtra("NOME", nome1);
                        intent.putExtra("IDADE", idade1);

                        startActivity(intent);
                    }else{
                        Toast.makeText(view.getContext(), "Idade: maior 14 anos", Toast.LENGTH_SHORT).show();
                    }


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

        String idadeCapturado = idade.getText().toString();
        if(!idadeCapturado.equals("")){
            editor.putString(IDADE, idadeCapturado);
            //editor.commit();// commit faz persistencia de forma sincrona ou
            editor.apply();
        }
    }
    //para carregar os dados inseridos nos textInputs, caso saia da tela
    @Override
    protected void onResume() {
        super.onResume();

        //Carregar o preferences
        preferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE);

        if(preferences.contains(NOME)){

            String nomeCapturado = preferences.getString(NOME,"");
            nome.setText(nomeCapturado);
        }

        if(preferences.contains(IDADE)){

            String emailCapturado = preferences.getString(IDADE,"");
            idade.setText(emailCapturado);
        }
    }
}
