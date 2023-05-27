package com.sanderpiva.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Question2 extends AppCompatActivity {

    Button btnAq2, btnBq2, btnCq2, btnDq2, btnPegaResposta2;
    TextView textViewPontoResposta2, textViewPegaResposta2;
    //ProgressBar pb;
    private String pegaResposta2="";
    private int pontoAcumuladoAteQ2=0;
    private String respostaSelecionadaQ2 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        Intent intentChamadora = getIntent();
        String pontoQ1 = intentChamadora.getStringExtra("PontoQ1");

        if (pontoQ1 != null) {
            pontoAcumuladoAteQ2 = Integer.parseInt(pontoQ1);

        } else {
            // Trate o caso em que a string é nula
        }


        iniciaDados();

        textViewPontoResposta2.setText(String.valueOf(pontoAcumuladoAteQ2));

        btnAq2.setOnClickListener(view -> {
            textViewPegaResposta2.setText("A");
            pegaResposta2 = textViewPegaResposta2.getText().toString();
            btnAq2.setBackgroundColor(ContextCompat.getColor(btnAq2.getContext(), R.color.holo_orange_dark));
            btnBq2.setBackgroundColor(ContextCompat.getColor(btnBq2.getContext(), R.color.purple_500));
            btnCq2.setBackgroundColor(ContextCompat.getColor(btnCq2.getContext(), R.color.purple_500));
            btnDq2.setBackgroundColor(ContextCompat.getColor(btnDq2.getContext(), R.color.purple_500));

        });


        btnBq2.setOnClickListener(view -> {

            textViewPegaResposta2.setText("B");
            pegaResposta2 = textViewPegaResposta2.getText().toString();
            btnBq2.setBackgroundColor(ContextCompat.getColor(btnBq2.getContext(), R.color.holo_orange_dark));
            btnAq2.setBackgroundColor(ContextCompat.getColor(btnAq2.getContext(), R.color.purple_500));
            btnCq2.setBackgroundColor(ContextCompat.getColor(btnCq2.getContext(), R.color.purple_500));
            btnDq2.setBackgroundColor(ContextCompat.getColor(btnDq2.getContext(), R.color.purple_500));

        });


        btnCq2.setOnClickListener(view -> {
            textViewPegaResposta2.setText("C");
            pegaResposta2 = textViewPegaResposta2.getText().toString();
            btnCq2.setBackgroundColor(ContextCompat.getColor(btnCq2.getContext(), R.color.holo_orange_dark));
            btnAq2.setBackgroundColor(ContextCompat.getColor(btnAq2.getContext(), R.color.purple_500));
            btnBq2.setBackgroundColor(ContextCompat.getColor(btnBq2.getContext(), R.color.purple_500));
            btnDq2.setBackgroundColor(ContextCompat.getColor(btnDq2.getContext(), R.color.purple_500));

        });


        btnDq2.setOnClickListener(view -> {

            textViewPegaResposta2.setText("D");
            pegaResposta2 = textViewPegaResposta2.getText().toString();

            btnDq2.setBackgroundColor(ContextCompat.getColor(btnDq2.getContext(), R.color.holo_orange_dark));
            btnAq2.setBackgroundColor(ContextCompat.getColor(btnAq2.getContext(), R.color.purple_500));
            btnBq2.setBackgroundColor(ContextCompat.getColor(btnBq2.getContext(), R.color.purple_500));
            btnCq2.setBackgroundColor(ContextCompat.getColor(btnCq2.getContext(), R.color.purple_500));

        });

        btnPegaResposta2.setOnClickListener(view -> {

            if(pegaResposta2.isEmpty()){
                Toast toast = Toast.makeText(view.getContext(), "Escolha uma resposta", Toast.LENGTH_SHORT);
                toast.show();
            }
            else{

                switch (pegaResposta2){

                    case "A":

                        btnAq2.setBackgroundColor(ContextCompat.getColor(btnAq2.getContext(), R.color.holo_green_dark));
                        btnBq2.setBackgroundColor(ContextCompat.getColor(btnBq2.getContext(), R.color.holo_red_dark));
                        btnCq2.setBackgroundColor(ContextCompat.getColor(btnCq2.getContext(), R.color.holo_red_dark));
                        btnDq2.setBackgroundColor(ContextCompat.getColor(btnDq2.getContext(), R.color.holo_red_dark));

                        pontoAcumuladoAteQ2++;
                        textViewPontoResposta2.setText(String.valueOf(pontoAcumuladoAteQ2));
                        proximo();

                        break;
                    case "B":
                    case "C":
                    case "D":

                        btnAq2.setBackgroundColor(ContextCompat.getColor(btnAq2.getContext(), R.color.holo_green_dark));
                        btnBq2.setBackgroundColor(ContextCompat.getColor(btnBq2.getContext(), R.color.holo_red_dark));
                        btnCq2.setBackgroundColor(ContextCompat.getColor(btnCq2.getContext(), R.color.holo_red_dark));
                        btnDq2.setBackgroundColor(ContextCompat.getColor(btnDq2.getContext(), R.color.holo_red_dark));
                        textViewPontoResposta2.setText(String.valueOf(pontoAcumuladoAteQ2));
                        proximo();
                        break;
                }

            }
        });
    }

    public void iniciaDados(){

        btnAq2 = findViewById(R.id.btnAq2);
        btnBq2 = findViewById(R.id.btnBq2);
        btnCq2 = findViewById(R.id.btnCq2);
        btnDq2 = findViewById(R.id.btnDq2);
        btnPegaResposta2 = findViewById((R.id.resposta2));
        textViewPontoResposta2 = findViewById(R.id.textViewPontoTela2);
        textViewPegaResposta2 = findViewById(R.id.textViewPegaResposta2);

    }

    public void proximo(){

        //ver como passa paramentro:
        //pb.setVisibility(View.VISIBLE);
        Intent intent = new Intent(Question2.this, Question3.class);
        intent.putExtra("PontoQ2", String.valueOf(pontoAcumuladoAteQ2));
        startActivity(intent);

    }

}





