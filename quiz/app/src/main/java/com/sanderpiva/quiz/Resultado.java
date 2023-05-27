package com.sanderpiva.quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    TextView textViewPontoRespostaFinal;
    //EditText nome;
    //EditText email;

    Button share;
    private String pontoTotal;
    private String nome, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        //minha ideia era enviar o resultado no email do usuario, mas nao foi possivel
        //resultado eh apenas exibido na tela

        Intent intentChamadora = getIntent();
        pontoTotal = intentChamadora.getStringExtra("PontoQ3");
        //nome = intentChamadora.getStringExtra("Nome");
        nome = intentChamadora.getStringExtra("Nome");
        email = intentChamadora.getStringExtra("Email");

        textViewPontoRespostaFinal = findViewById(R.id.textViewResultado);

        textViewPontoRespostaFinal.setText(pontoTotal);
        //enviarEmail();
    }
    /*private void enviarEmail() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Pontuação do Jogo");
        intent.putExtra(Intent.EXTRA_TEXT, "Olá " + nome + ", seu ponto acumulado é: " + pontoTotal);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }*/
}