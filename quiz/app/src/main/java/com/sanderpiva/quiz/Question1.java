package com.sanderpiva.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class Question1 extends AppCompatActivity {

    Button btnAq1, btnBq1, btnCq1, btnDq1, btnPegaResposta1;
    TextView textViewPontoResposta1, textViewPegaResposta1;
    //ProgressBar pb;
    private String pegaResposta1="";
    private int pontoAcumuladoAteQ1=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        Intent intentChamadora = getIntent();

        iniciaDados();

        textViewPontoResposta1.setText(String.valueOf(pontoAcumuladoAteQ1));

        btnAq1.setOnClickListener(view -> {
            textViewPegaResposta1.setText("A");
            pegaResposta1 = textViewPegaResposta1.getText().toString();
            btnAq1.setBackgroundColor(ContextCompat.getColor(btnAq1.getContext(), R.color.holo_orange_dark));
            btnBq1.setBackgroundColor(ContextCompat.getColor(btnBq1.getContext(), R.color.purple_500));
            btnCq1.setBackgroundColor(ContextCompat.getColor(btnCq1.getContext(), R.color.purple_500));
            btnDq1.setBackgroundColor(ContextCompat.getColor(btnDq1.getContext(), R.color.purple_500));

        });


        btnBq1.setOnClickListener(view -> {

            textViewPegaResposta1.setText("B");
            pegaResposta1 = textViewPegaResposta1.getText().toString();
            btnBq1.setBackgroundColor(ContextCompat.getColor(btnBq1.getContext(), R.color.holo_orange_dark));
            btnAq1.setBackgroundColor(ContextCompat.getColor(btnAq1.getContext(), R.color.purple_500));
            btnCq1.setBackgroundColor(ContextCompat.getColor(btnCq1.getContext(), R.color.purple_500));
            btnDq1.setBackgroundColor(ContextCompat.getColor(btnDq1.getContext(), R.color.purple_500));

        });


        btnCq1.setOnClickListener(view -> {
            textViewPegaResposta1.setText("C");
            pegaResposta1 = textViewPegaResposta1.getText().toString();
            btnCq1.setBackgroundColor(ContextCompat.getColor(btnCq1.getContext(), R.color.holo_orange_dark));
            btnAq1.setBackgroundColor(ContextCompat.getColor(btnAq1.getContext(), R.color.purple_500));
            btnBq1.setBackgroundColor(ContextCompat.getColor(btnBq1.getContext(), R.color.purple_500));
            btnDq1.setBackgroundColor(ContextCompat.getColor(btnDq1.getContext(), R.color.purple_500));

        });


        btnDq1.setOnClickListener(view -> {

            textViewPegaResposta1.setText("D");
            pegaResposta1 = textViewPegaResposta1.getText().toString();

            btnDq1.setBackgroundColor(ContextCompat.getColor(btnDq1.getContext(), R.color.holo_orange_dark));
            btnAq1.setBackgroundColor(ContextCompat.getColor(btnAq1.getContext(), R.color.purple_500));
            btnBq1.setBackgroundColor(ContextCompat.getColor(btnBq1.getContext(), R.color.purple_500));
            btnCq1.setBackgroundColor(ContextCompat.getColor(btnCq1.getContext(), R.color.purple_500));

        });

        btnPegaResposta1.setOnClickListener(view -> {

            if(pegaResposta1.isEmpty()){
                Toast toast = Toast.makeText(view.getContext(), "Escolha uma resposta", Toast.LENGTH_SHORT);
                toast.show();
            }
            else{

                switch (pegaResposta1){

                    case "A":

                        btnAq1.setBackgroundColor(ContextCompat.getColor(btnAq1.getContext(), R.color.holo_green_dark));
                        btnBq1.setBackgroundColor(ContextCompat.getColor(btnBq1.getContext(), R.color.holo_red_dark));
                        btnCq1.setBackgroundColor(ContextCompat.getColor(btnCq1.getContext(), R.color.holo_red_dark));
                        btnDq1.setBackgroundColor(ContextCompat.getColor(btnDq1.getContext(), R.color.holo_red_dark));
                        pontoAcumuladoAteQ1++;
                        textViewPontoResposta1.setText(String.valueOf(pontoAcumuladoAteQ1));
                        proximo();

                        break;
                    case "B":
                    case "C":
                    case "D":

                        btnAq1.setBackgroundColor(ContextCompat.getColor(btnDq1.getContext(), R.color.holo_green_dark));
                        btnBq1.setBackgroundColor(ContextCompat.getColor(btnDq1.getContext(), R.color.holo_red_dark));
                        btnCq1.setBackgroundColor(ContextCompat.getColor(btnDq1.getContext(), R.color.holo_red_dark));
                        btnDq1.setBackgroundColor(ContextCompat.getColor(btnDq1.getContext(), R.color.holo_red_dark));
                        textViewPontoResposta1.setText(String.valueOf(pontoAcumuladoAteQ1));
                        proximo();
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
        btnPegaResposta1 = findViewById((R.id.resposta1));
        textViewPontoResposta1 = findViewById(R.id.textViewPontoTela1);
        textViewPegaResposta1 = findViewById(R.id.textViewPegaResposta1);
       // pb = findViewById(R.id.progressBar);

    }

    public void proximo(){

        //ver como passa paramentro:
       // pb.setVisibility(View.VISIBLE);
        Intent intent = new Intent(Question1.this, Question2.class);
        intent.putExtra("PontoQ1", String.valueOf(pontoAcumuladoAteQ1));
        startActivity(intent);

    }

}

/*

Vamos analisar cada parâmetro da linha de código btnDq1.setBackgroundColor(ContextCompat.getColor(btnDq1.getContext(), R.color.purple_500));:

btnDq1: É uma referência a um objeto do tipo Button ou uma subclasse de Button. Este é o botão ao qual você deseja definir a cor de fundo.

setBackgroundColor(): É um método usado para definir a cor de fundo de um elemento de interface do usuário, como um botão. Ele recebe um valor de cor como argumento para definir a cor de fundo do elemento.

ContextCompat.getColor(): É um método auxiliar da classe ContextCompat que permite obter uma cor de recursos compatível com versões anteriores do Android. Ele recebe dois argumentos:

btnDq1.getContext(): Obtém o contexto do botão btnDq1. O contexto é usado para acessar os recursos do aplicativo, como cores, strings e layouts.

R.color.purple_500: É uma referência ao identificador de recurso da cor definida no arquivo colors.xml. O prefixo R.color indica que estamos referenciando uma cor no arquivo colors.xml, enquanto purple_500 é o nome da cor especificada no arquivo.

Dessa forma, a linha de código em questão define a cor de fundo do botão btnDq1 com a cor definida no arquivo colors.xml com o nome purple_500.


 */