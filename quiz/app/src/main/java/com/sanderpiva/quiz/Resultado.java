package com.sanderpiva.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView textViewPontoRespostaFinal;

        Intent intentChamadora = getIntent();
        String pontoTotal = intentChamadora.getStringExtra("PontoAcumuladoAteQ3");
        textViewPontoRespostaFinal = findViewById(R.id.textViewResultado);
        textViewPontoRespostaFinal.setText(pontoTotal);

        String nome = intentChamadora.getStringExtra("NOME");
        String idade = intentChamadora.getStringExtra("IDADE");

        int idadeInt = Integer.parseInt(idade);

        TextView ganhador;
        TextView premio;
        ImageView image;

        if(pontoTotal.equals("3") && (idadeInt>13 && idadeInt<=25)){
           ganhador = findViewById(R.id.textViewGanhador);
           ganhador.setText("Ganhador: "+ nome +", idade: "+ idade +" anos");
           premio = findViewById(R.id.textViewPremio);
           premio.setText("Ganhou Viagem HopiHari");
           image = findViewById(R.id.imageViewPremio);
           image.setImageResource(R.drawable.hopirari);

        }else if(pontoTotal.equals("3") && (idadeInt>=26)){
            ganhador = findViewById(R.id.textViewGanhador);
            ganhador.setText("Ganhador: "+ nome +", idade: "+ idade +" anos");
            premio = findViewById(R.id.textViewPremio);
            premio.setText("Ganhou Viagem Caldas Novas GO");
            image = findViewById(R.id.imageViewPremio);
            image.setImageResource(R.drawable.caldasnovas);

        }else{
            ganhador = findViewById(R.id.textViewGanhador);
            ganhador.setText("Não foi dessa vez, que pena");
            premio = findViewById(R.id.textViewPremio);
            premio.setText("Não ganhou prêmio surpresa");
        }
    }
}