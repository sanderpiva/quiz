package com.sanderpiva.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nome;
    EditText email;
    Button logar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.editTextNome);
        email = findViewById(R.id.editTextEmail);
        logar = findViewById(R.id.btnLogar);

        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome1 = nome.getText().toString();
                String email1 = email.getText().toString();
                //ver exercicio Login que tem mais recursos
                if(!nome1.isEmpty() && !email1.isEmpty()){

                    Intent intent = new Intent(MainActivity.this, Question1.class);
                    startActivity(intent);
                }else {

                    Toast.makeText(view.getContext(), "Preencha todos dados", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}