package com.sanderpiva.quiz;

import android.widget.Button;

import androidx.core.content.ContextCompat;

public class CorButtonQ2 {
    public CorButtonQ2(String resposta, Button btnAq2, Button btnBq2, Button btnCq2, Button btnDq2) {

        if(resposta.equals("A")){
            btnAq2.setBackgroundColor(ContextCompat.getColor(btnAq2.getContext(), R.color.holo_orange_dark));
            btnBq2.setBackgroundColor(ContextCompat.getColor(btnBq2.getContext(), R.color.purple_500));
            btnCq2.setBackgroundColor(ContextCompat.getColor(btnCq2.getContext(), R.color.purple_500));
            btnDq2.setBackgroundColor(ContextCompat.getColor(btnDq2.getContext(), R.color.purple_500));
        }
        else if(resposta.equals("B")){

            btnBq2.setBackgroundColor(ContextCompat.getColor(btnBq2.getContext(), R.color.holo_orange_dark));
            btnAq2.setBackgroundColor(ContextCompat.getColor(btnAq2.getContext(), R.color.purple_500));
            btnCq2.setBackgroundColor(ContextCompat.getColor(btnCq2.getContext(), R.color.purple_500));
            btnDq2.setBackgroundColor(ContextCompat.getColor(btnDq2.getContext(), R.color.purple_500));
        }
        else if(resposta.equals("C")){

            btnCq2.setBackgroundColor(ContextCompat.getColor(btnCq2.getContext(), R.color.holo_orange_dark));
            btnAq2.setBackgroundColor(ContextCompat.getColor(btnAq2.getContext(), R.color.purple_500));
            btnBq2.setBackgroundColor(ContextCompat.getColor(btnBq2.getContext(), R.color.purple_500));
            btnDq2.setBackgroundColor(ContextCompat.getColor(btnDq2.getContext(), R.color.purple_500));
        }
        else{

            btnDq2.setBackgroundColor(ContextCompat.getColor(btnDq2.getContext(), R.color.holo_orange_dark));
            btnAq2.setBackgroundColor(ContextCompat.getColor(btnAq2.getContext(), R.color.purple_500));
            btnBq2.setBackgroundColor(ContextCompat.getColor(btnBq2.getContext(), R.color.purple_500));
            btnCq2.setBackgroundColor(ContextCompat.getColor(btnCq2.getContext(), R.color.purple_500));
        }
    }
}
