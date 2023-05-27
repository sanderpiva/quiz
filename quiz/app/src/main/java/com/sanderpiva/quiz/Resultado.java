package com.sanderpiva.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    private int pontoAcumulado = 0;
    TextView textViewPontoRespostaFinal;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        //minha ideia era enviar o resultado no email do usuario, mas nao foi possivel
        //resultado eh apenas exibido na tela

        Intent intentChamadora = getIntent();
        String pontoTotal = intentChamadora.getStringExtra("PontoQ3");
        pontoAcumulado = Integer.parseInt(pontoTotal);

        textViewPontoRespostaFinal = findViewById(R.id.textViewResultado);

        textViewPontoRespostaFinal.setText(String.valueOf(pontoAcumulado));
    }
}