package com.sanderpiva.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    TextView textViewPontoRespostaFinal;
    TextView premio;
    ImageView image;
    private String pontoTotal;
    private String nome;
    private String idade;

    private TextView ganhador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent intentChamadora = getIntent();
        pontoTotal = intentChamadora.getStringExtra("PontoAcumuladoAteQ3");
        textViewPontoRespostaFinal = findViewById(R.id.textViewResultado);
        textViewPontoRespostaFinal.setText(pontoTotal);

        String nomeTransicao = intentChamadora.getStringExtra("NOME");
        String idadeTransicao = intentChamadora.getStringExtra("IDADE");

        nome=nomeTransicao;
        idade=idadeTransicao;

        System.out.println(nome+idade);
        Integer idadeInt = Integer.parseInt(idade);

        if(pontoTotal.equals("3") && (idadeInt>13 && idadeInt<=30)){
           ganhador = findViewById(R.id.textViewGanhador);
           ganhador.setText("Ganhador: "+nome+", idade: "+idade+"anos");
           premio = findViewById(R.id.textViewPremio);
           premio.setText("Ganhou Viagem HopiHari");
           image = findViewById(R.id.imageViewPremio);
           image.setImageResource(R.drawable.hopirari);

        }else if(pontoTotal.equals("3") && (idadeInt>=31)){
            ganhador = findViewById(R.id.textViewGanhador);
            ganhador.setText("Ganhador: "+nome+", idade: "+idade+"anos");
            premio = findViewById(R.id.textViewPremio);
            premio.setText("Ganhou Viagem Caldas Novas");
            image = findViewById(R.id.imageViewPremio);
            image.setImageResource(R.drawable.caldasnovas);

        }else{
            ganhador = findViewById(R.id.textViewGanhador);
            ganhador.setText("Não foi dessa vez, que pena");
            premio = findViewById(R.id.textViewPremio);
            premio.setText("Não ganhou premio surpresa");
        }
    }
}