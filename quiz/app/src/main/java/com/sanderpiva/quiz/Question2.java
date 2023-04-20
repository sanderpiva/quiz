package com.sanderpiva.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Question2 extends AppCompatActivity {

    Button btnAq2, btnBq2, btnCq2, btnDq2, btnPegaResposta2;
    TextView textViewPontoResposta2, textViewPegaResposta2;
    ProgressBar pb;
    private String pegaResposta2="";
    private int pontoAcumuladoAteQ2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        Intent intentChamadora = getIntent();
        String pontoQ1 = intentChamadora.getStringExtra("PontoQ1");
        pontoAcumuladoAteQ2 = Integer.parseInt(pontoQ1);

        iniciaDados();

        textViewPontoResposta2.setText(String.valueOf(pontoAcumuladoAteQ2));

        btnAq2.setOnClickListener(view -> {
            textViewPegaResposta2.setText("A");
            pegaResposta2 = textViewPegaResposta2.getText().toString();
            btnAq2.setBackgroundColor(ContextCompat.getColor(btnAq2.getContext(), android.R.color.holo_orange_dark));
            btnBq2.setBackgroundColor(ContextCompat.getColor(btnBq2.getContext(), android.R.color.holo_blue_dark));
            btnCq2.setBackgroundColor(ContextCompat.getColor(btnCq2.getContext(), android.R.color.holo_blue_dark));
            btnDq2.setBackgroundColor(ContextCompat.getColor(btnDq2.getContext(), android.R.color.holo_blue_dark));

        });


        btnBq2.setOnClickListener(view -> {

            textViewPegaResposta2.setText("B");
            pegaResposta2 = textViewPegaResposta2.getText().toString();
            btnBq2.setBackgroundColor(ContextCompat.getColor(btnBq2.getContext(), android.R.color.holo_orange_dark));
            btnAq2.setBackgroundColor(ContextCompat.getColor(btnAq2.getContext(), android.R.color.holo_blue_dark));
            btnCq2.setBackgroundColor(ContextCompat.getColor(btnCq2.getContext(), android.R.color.holo_blue_dark));
            btnDq2.setBackgroundColor(ContextCompat.getColor(btnDq2.getContext(), android.R.color.holo_blue_dark));

        });


        btnCq2.setOnClickListener(view -> {
            textViewPegaResposta2.setText("C");
            pegaResposta2 = textViewPegaResposta2.getText().toString();
            btnCq2.setBackgroundColor(ContextCompat.getColor(btnCq2.getContext(), android.R.color.holo_orange_dark));
            btnAq2.setBackgroundColor(ContextCompat.getColor(btnAq2.getContext(), android.R.color.holo_blue_dark));
            btnBq2.setBackgroundColor(ContextCompat.getColor(btnBq2.getContext(), android.R.color.holo_blue_dark));
            btnDq2.setBackgroundColor(ContextCompat.getColor(btnDq2.getContext(), android.R.color.holo_blue_dark));

        });


        btnDq2.setOnClickListener(view -> {

            textViewPegaResposta2.setText("D");
            pegaResposta2 = textViewPegaResposta2.getText().toString();

            btnDq2.setBackgroundColor(ContextCompat.getColor(btnDq2.getContext(), android.R.color.holo_orange_dark));
            btnAq2.setBackgroundColor(ContextCompat.getColor(btnAq2.getContext(), android.R.color.holo_blue_dark));
            btnBq2.setBackgroundColor(ContextCompat.getColor(btnBq2.getContext(), android.R.color.holo_blue_dark));
            btnCq2.setBackgroundColor(ContextCompat.getColor(btnCq2.getContext(), android.R.color.holo_blue_dark));

        });

        btnPegaResposta2.setOnClickListener(view -> {

            if(pegaResposta2.isEmpty()){
                Toast toast = Toast.makeText(view.getContext(), "Escolha uma resposta", Toast.LENGTH_SHORT);
                toast.show();
            }
            else{

                switch (pegaResposta2){

                    case "A":

                        btnAq2.setBackgroundColor(ContextCompat.getColor(btnAq2.getContext(), android.R.color.holo_green_dark));
                        btnBq2.setBackgroundColor(ContextCompat.getColor(btnBq2.getContext(), android.R.color.holo_red_dark));
                        btnCq2.setBackgroundColor(ContextCompat.getColor(btnCq2.getContext(), android.R.color.holo_red_dark));
                        btnDq2.setBackgroundColor(ContextCompat.getColor(btnDq2.getContext(), android.R.color.holo_red_dark));

                        pontoAcumuladoAteQ2++;
                        textViewPontoResposta2.setText(String.valueOf(pontoAcumuladoAteQ2));
                        proximo();

                        break;
                    case "B":
                    case "C":
                    case "D":

                        btnAq2.setBackgroundColor(ContextCompat.getColor(btnDq2.getContext(), android.R.color.holo_green_dark));
                        btnBq2.setBackgroundColor(ContextCompat.getColor(btnBq2.getContext(), android.R.color.holo_red_dark));
                        btnCq2.setBackgroundColor(ContextCompat.getColor(btnCq2.getContext(), android.R.color.holo_red_dark));
                        btnDq2.setBackgroundColor(ContextCompat.getColor(btnDq2.getContext(), android.R.color.holo_red_dark));
                        textViewPontoResposta2.setText(String.valueOf(pontoAcumuladoAteQ2));
                        proximo();
                        break;
                }
            }
        });
    }

    public void iniciaDados(){

        btnAq2 = findViewById(R.id.btnA);
        btnBq2 = findViewById(R.id.btnB);
        btnCq2 = findViewById(R.id.btnC);
        btnDq2 = findViewById(R.id.btnD);
        btnPegaResposta2 = findViewById((R.id.resposta1));
        textViewPontoResposta2 = findViewById(R.id.textViewPontoTela1);
        textViewPegaResposta2 = findViewById(R.id.textViewPegaResposta1);
        pb = findViewById(R.id.progressBar);

    }

    public void proximo(){

        //ver como passa paramentro:
        pb.setVisibility(View.VISIBLE);
        Intent intent = new Intent(Question2.this, Question3.class);
        //intent.putExtra("Ponto", String.valueOf(textViewPontoResposta1));
        intent.putExtra("PontoQ2", String.valueOf(pontoAcumuladoAteQ2));
        startActivity(intent);

    }
}





