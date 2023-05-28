package com.sanderpiva.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Question3 extends AppCompatActivity {
    Button btnAq3, btnBq3, btnCq3, btnDq3, btnPegaResposta3;
    TextView textViewPontoResposta3, textViewPegaResposta3;
    //ProgressBar pb;
    private String pegaResposta3="";
    private String nome, idade;
    private int pontoAcumuladoAteQ3=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        Intent intentChamadora = getIntent();
        String pontoQ2 = intentChamadora.getStringExtra("PontoAcumuladoAteQ2");
        pontoAcumuladoAteQ3 = Integer.parseInt(pontoQ2);
        String nomeTransicao = intentChamadora.getStringExtra("NOME");
        String idadeTransicao = intentChamadora.getStringExtra("IDADE");

        nome=nomeTransicao;
        idade=idadeTransicao;

        iniciaDados();

        textViewPontoResposta3.setText(String.valueOf(pontoAcumuladoAteQ3));

        btnAq3.setOnClickListener(view -> {
            textViewPegaResposta3.setText("A");
            pegaResposta3 = textViewPegaResposta3.getText().toString();
            btnAq3.setBackgroundColor(ContextCompat.getColor(btnAq3.getContext(), R.color.holo_orange_dark));
            btnBq3.setBackgroundColor(ContextCompat.getColor(btnBq3.getContext(), R.color.purple_500));
            btnCq3.setBackgroundColor(ContextCompat.getColor(btnCq3.getContext(), R.color.purple_500));
            btnDq3.setBackgroundColor(ContextCompat.getColor(btnDq3.getContext(), R.color.purple_500));

        });

        btnBq3.setOnClickListener(view -> {

            textViewPegaResposta3.setText("B");
            pegaResposta3 = textViewPegaResposta3.getText().toString();
            btnBq3.setBackgroundColor(ContextCompat.getColor(btnBq3.getContext(), R.color.holo_orange_dark));
            btnAq3.setBackgroundColor(ContextCompat.getColor(btnAq3.getContext(), R.color.purple_500));
            btnCq3.setBackgroundColor(ContextCompat.getColor(btnCq3.getContext(), R.color.purple_500));
            btnDq3.setBackgroundColor(ContextCompat.getColor(btnDq3.getContext(), R.color.purple_500));

        });

        btnCq3.setOnClickListener(view -> {
            textViewPegaResposta3.setText("C");
            pegaResposta3 = textViewPegaResposta3.getText().toString();
            btnCq3.setBackgroundColor(ContextCompat.getColor(btnCq3.getContext(), R.color.holo_orange_dark));
            btnAq3.setBackgroundColor(ContextCompat.getColor(btnAq3.getContext(), R.color.purple_500));
            btnBq3.setBackgroundColor(ContextCompat.getColor(btnBq3.getContext(), R.color.purple_500));
            btnDq3.setBackgroundColor(ContextCompat.getColor(btnDq3.getContext(), R.color.purple_500));

        });

        btnDq3.setOnClickListener(view -> {

            textViewPegaResposta3.setText("D");
            pegaResposta3 = textViewPegaResposta3.getText().toString();

            btnDq3.setBackgroundColor(ContextCompat.getColor(btnDq3.getContext(), R.color.holo_orange_dark));
            btnAq3.setBackgroundColor(ContextCompat.getColor(btnAq3.getContext(), R.color.purple_500));
            btnBq3.setBackgroundColor(ContextCompat.getColor(btnBq3.getContext(), R.color.purple_500));
            btnCq3.setBackgroundColor(ContextCompat.getColor(btnCq3.getContext(), R.color.purple_500));

        });

        btnPegaResposta3.setOnClickListener(view -> {

            if(pegaResposta3.isEmpty()){
                Toast toast = Toast.makeText(view.getContext(), "Escolha uma resposta", Toast.LENGTH_SHORT);
                toast.show();
            }
            else{

                switch (pegaResposta3){

                    case "A":

                        btnAq3.setBackgroundColor(ContextCompat.getColor(btnAq3.getContext(), R.color.holo_green_dark));
                        btnBq3.setBackgroundColor(ContextCompat.getColor(btnBq3.getContext(), R.color.holo_red_dark));
                        btnCq3.setBackgroundColor(ContextCompat.getColor(btnCq3.getContext(), R.color.holo_red_dark));
                        btnDq3.setBackgroundColor(ContextCompat.getColor(btnDq3.getContext(), R.color.holo_red_dark));

                        pontoAcumuladoAteQ3++;
                        textViewPontoResposta3.setText(String.valueOf(pontoAcumuladoAteQ3));
                        proximo();

                        break;
                    case "B":
                    case "C":
                    case "D":

                        btnAq3.setBackgroundColor(ContextCompat.getColor(btnAq3.getContext(), R.color.holo_green_dark));
                        btnBq3.setBackgroundColor(ContextCompat.getColor(btnBq3.getContext(), R.color.holo_red_dark));
                        btnCq3.setBackgroundColor(ContextCompat.getColor(btnCq3.getContext(), R.color.holo_red_dark));
                        btnDq3.setBackgroundColor(ContextCompat.getColor(btnDq3.getContext(), R.color.holo_red_dark));
                        textViewPontoResposta3.setText(String.valueOf(pontoAcumuladoAteQ3));
                        proximo();
                        break;
                }
            }
        });
    }
    public void iniciaDados(){

        btnAq3 = findViewById(R.id.btnAq3);
        btnBq3 = findViewById(R.id.btnBq3);
        btnCq3 = findViewById(R.id.btnCq3);
        btnDq3 = findViewById(R.id.btnDq3);
        btnPegaResposta3 = findViewById((R.id.resposta3));
        textViewPontoResposta3 = findViewById(R.id.textViewPontoTela3);
        textViewPegaResposta3 = findViewById(R.id.textViewPegaResposta3);
        // pb = findViewById(R.id.progressBar);

    }
    public void proximo(){

        Intent intent = new Intent(getBaseContext(), Resultado.class);
        intent.putExtra("PontoAcumuladoAteQ3", String.valueOf(pontoAcumuladoAteQ3));
        intent.putExtra("NOME", nome);
        intent.putExtra("IDADE", idade);
        startActivity(intent);

    }
}