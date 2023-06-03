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
public class Question2 extends AppCompatActivity {
    Button btnAq2, btnBq2, btnCq2, btnDq2, btnPegaRespostaQ2;
    TextView textViewPontoAcumuladoAteRespostaQ2, textViewPegaRespostaQ2;
    ProgressBar pb;
    private String pegaRespostaQ2="";
    private int pontoAcumuladoAteQ2=0;
    private String nome, idade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        Intent intentChamadora = getIntent();
        String pontoQ1 = intentChamadora.getStringExtra("PontoAcumuladoAteQ1");
        nome = intentChamadora.getStringExtra("NOME");
        idade = intentChamadora.getStringExtra("IDADE");

        pontoAcumuladoAteQ2 = Integer.parseInt(pontoQ1);

        iniciaDados();

        textViewPontoAcumuladoAteRespostaQ2.setText(String.valueOf(pontoAcumuladoAteQ2));

        btnAq2.setOnClickListener(view -> {
            textViewPegaRespostaQ2.setText("A");
            pegaRespostaQ2 = textViewPegaRespostaQ2.getText().toString();
            CorButtonQ2 cor = new CorButtonQ2(pegaRespostaQ2, btnAq2, btnBq2, btnCq2, btnDq2);
        });

        btnBq2.setOnClickListener(view -> {

            textViewPegaRespostaQ2.setText("B");
            pegaRespostaQ2 = textViewPegaRespostaQ2.getText().toString();
            CorButtonQ2 cor = new CorButtonQ2(pegaRespostaQ2, btnAq2, btnBq2, btnCq2, btnDq2);
        });

        btnCq2.setOnClickListener(view -> {
            textViewPegaRespostaQ2.setText("C");
            pegaRespostaQ2 = textViewPegaRespostaQ2.getText().toString();
            CorButtonQ2 cor = new CorButtonQ2(pegaRespostaQ2, btnAq2, btnBq2, btnCq2, btnDq2);
        });

        btnDq2.setOnClickListener(view -> {

            textViewPegaRespostaQ2.setText("D");
            pegaRespostaQ2 = textViewPegaRespostaQ2.getText().toString();
            CorButtonQ2 cor = new CorButtonQ2(pegaRespostaQ2, btnAq2, btnBq2, btnCq2, btnDq2);
        });

        btnPegaRespostaQ2.setOnClickListener(view -> {

            if(pegaRespostaQ2.isEmpty()){
                Toast toast = Toast.makeText(view.getContext(), "Escolha uma resposta", Toast.LENGTH_SHORT);
                toast.show();
            }
            else{

                switch (pegaRespostaQ2){

                    case "B":

                        btnBq2.setBackgroundColor(ContextCompat.getColor(btnBq2.getContext(), R.color.holo_green_dark));
                        btnAq2.setBackgroundColor(ContextCompat.getColor(btnAq2.getContext(), R.color.holo_red_dark));
                        btnCq2.setBackgroundColor(ContextCompat.getColor(btnCq2.getContext(), R.color.holo_red_dark));
                        btnDq2.setBackgroundColor(ContextCompat.getColor(btnDq2.getContext(), R.color.holo_red_dark));

                        pontoAcumuladoAteQ2++;
                        textViewPontoAcumuladoAteRespostaQ2.setText(String.valueOf(pontoAcumuladoAteQ2));
                        proximaTela();

                        break;
                    case "A":
                    case "C":
                    case "D":

                        btnBq2.setBackgroundColor(ContextCompat.getColor(btnBq2.getContext(), R.color.holo_green_dark));
                        btnAq2.setBackgroundColor(ContextCompat.getColor(btnAq2.getContext(), R.color.holo_red_dark));
                        btnCq2.setBackgroundColor(ContextCompat.getColor(btnCq2.getContext(), R.color.holo_red_dark));
                        btnDq2.setBackgroundColor(ContextCompat.getColor(btnDq2.getContext(), R.color.holo_red_dark));
                        textViewPontoAcumuladoAteRespostaQ2.setText(String.valueOf(pontoAcumuladoAteQ2));
                        proximaTela();
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
        btnPegaRespostaQ2 = findViewById((R.id.resposta2));
        textViewPontoAcumuladoAteRespostaQ2 = findViewById(R.id.textViewPontoTela2);
        textViewPegaRespostaQ2 = findViewById(R.id.textViewPegaResposta2);
        pb = findViewById(R.id.progressBar2);
        pb.setVisibility(View.INVISIBLE);
    }
    public void proximaTela(){

        pb.setVisibility(View.VISIBLE);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                pb.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(getBaseContext(), Question3.class);
                intent.putExtra("PontoAcumuladoAteQ2", String.valueOf(pontoAcumuladoAteQ2));
                intent.putExtra("NOME", nome);
                intent.putExtra("IDADE", idade);
                startActivity(intent);
            }
        }, 3000);
    }
}


