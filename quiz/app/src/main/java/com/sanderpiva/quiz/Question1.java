package com.sanderpiva.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
public class Question1 extends AppCompatActivity {
    Button btnAq1, btnBq1, btnCq1, btnDq1, btnPegaRespostaQ1;
    TextView textViewPontoAcumuladoAteRespostaQ1, textViewPegaRespostaQ1;
    ProgressBar pb;
    private String pegaRespostaQ1="";
    private int pontoAcumuladoAteQ1=0;
    private String nome, idade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        Intent intentChamadora = getIntent();
        nome = intentChamadora.getStringExtra("NOME");
        idade = intentChamadora.getStringExtra("IDADE");

        iniciaDados();

        textViewPontoAcumuladoAteRespostaQ1.setText(String.valueOf(pontoAcumuladoAteQ1));

        btnAq1.setOnClickListener(view -> {

            textViewPegaRespostaQ1.setText("A");
            pegaRespostaQ1 = textViewPegaRespostaQ1.getText().toString();
            CorButtonQ1 cor = new CorButtonQ1(pegaRespostaQ1, btnAq1, btnBq1, btnCq1, btnDq1);
        });

        btnBq1.setOnClickListener(view -> {

            textViewPegaRespostaQ1.setText("B");
            pegaRespostaQ1 = textViewPegaRespostaQ1.getText().toString();
            CorButtonQ1 cor = new CorButtonQ1(pegaRespostaQ1, btnAq1, btnBq1, btnCq1, btnDq1);
        });

        btnCq1.setOnClickListener(view -> {

            textViewPegaRespostaQ1.setText("C");
            pegaRespostaQ1 = textViewPegaRespostaQ1.getText().toString();
            CorButtonQ1 cor = new CorButtonQ1(pegaRespostaQ1, btnAq1, btnBq1, btnCq1, btnDq1);
        });

        btnDq1.setOnClickListener(view -> {

            textViewPegaRespostaQ1.setText("D");
            pegaRespostaQ1 = textViewPegaRespostaQ1.getText().toString();
            CorButtonQ1 cor = new CorButtonQ1(pegaRespostaQ1, btnAq1, btnBq1, btnCq1, btnDq1);
        });

        btnPegaRespostaQ1.setOnClickListener(view -> {

            if(pegaRespostaQ1.isEmpty()){
                Toast toast = Toast.makeText(view.getContext(), "Escolha uma resposta", Toast.LENGTH_SHORT);
                toast.show();
            }
            else{

                switch (pegaRespostaQ1){

                    case "A":

                        btnAq1.setBackgroundColor(ContextCompat.getColor(btnAq1.getContext(), R.color.holo_green_dark));
                        btnBq1.setBackgroundColor(ContextCompat.getColor(btnBq1.getContext(), R.color.holo_red_dark));
                        btnCq1.setBackgroundColor(ContextCompat.getColor(btnCq1.getContext(), R.color.holo_red_dark));
                        btnDq1.setBackgroundColor(ContextCompat.getColor(btnDq1.getContext(), R.color.holo_red_dark));
                        pontoAcumuladoAteQ1++;
                        textViewPontoAcumuladoAteRespostaQ1.setText(String.valueOf(pontoAcumuladoAteQ1));
                        proximaTela();

                        break;
                    case "B":
                    case "C":
                    case "D":

                        btnAq1.setBackgroundColor(ContextCompat.getColor(btnDq1.getContext(), R.color.holo_green_dark));
                        btnBq1.setBackgroundColor(ContextCompat.getColor(btnDq1.getContext(), R.color.holo_red_dark));
                        btnCq1.setBackgroundColor(ContextCompat.getColor(btnDq1.getContext(), R.color.holo_red_dark));
                        btnDq1.setBackgroundColor(ContextCompat.getColor(btnDq1.getContext(), R.color.holo_red_dark));
                        textViewPontoAcumuladoAteRespostaQ1.setText(String.valueOf(pontoAcumuladoAteQ1));
                        proximaTela();
                        break;
                }
            }
        });
    }
    public void iniciaDados(){
        btnAq1 = findViewById(R.id.btnAq1);
        btnBq1 = findViewById(R.id.btnBq1);
        btnCq1 = findViewById(R.id.btnCq1);
        btnDq1 = findViewById(R.id.btnDq1);
        btnPegaRespostaQ1 = findViewById((R.id.resposta1));
        textViewPontoAcumuladoAteRespostaQ1 = findViewById(R.id.textViewPontoTela1);
        textViewPegaRespostaQ1 = findViewById(R.id.textViewPegaResposta1);
        pb = findViewById(R.id.progressBarQ1);
        pb.setVisibility(View.INVISIBLE);
    }
    public void proximaTela(){

        pb.setVisibility(View.VISIBLE);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                pb.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(getBaseContext(), Question2.class);
                intent.putExtra("PontoAcumuladoAteQ1", String.valueOf(pontoAcumuladoAteQ1));
                intent.putExtra("NOME", nome);
                intent.putExtra("IDADE", idade);
                startActivity(intent);
            }
        }, 3000);
    }
}
