package com.sanderpiva.quiz;

import android.widget.Button;

import androidx.core.content.ContextCompat;

public class CorButtonQ1 {
    public CorButtonQ1(String resposta, Button btnAq1, Button btnBq1, Button btnCq1, Button btnDq1) {

        if(resposta.equals("A")){

            btnAq1.setBackgroundColor(ContextCompat.getColor(btnAq1.getContext(), R.color.holo_orange_dark));
            btnBq1.setBackgroundColor(ContextCompat.getColor(btnBq1.getContext(), R.color.purple_500));
            btnCq1.setBackgroundColor(ContextCompat.getColor(btnCq1.getContext(), R.color.purple_500));
            btnDq1.setBackgroundColor(ContextCompat.getColor(btnDq1.getContext(), R.color.purple_500));
        }
        else if(resposta.equals("B")){

            btnBq1.setBackgroundColor(ContextCompat.getColor(btnBq1.getContext(), R.color.holo_orange_dark));
            btnAq1.setBackgroundColor(ContextCompat.getColor(btnAq1.getContext(), R.color.purple_500));
            btnCq1.setBackgroundColor(ContextCompat.getColor(btnCq1.getContext(), R.color.purple_500));
            btnDq1.setBackgroundColor(ContextCompat.getColor(btnDq1.getContext(), R.color.purple_500));
        }
        else if(resposta.equals("C")){

            btnCq1.setBackgroundColor(ContextCompat.getColor(btnCq1.getContext(), R.color.holo_orange_dark));
            btnAq1.setBackgroundColor(ContextCompat.getColor(btnAq1.getContext(), R.color.purple_500));
            btnBq1.setBackgroundColor(ContextCompat.getColor(btnBq1.getContext(), R.color.purple_500));
            btnDq1.setBackgroundColor(ContextCompat.getColor(btnDq1.getContext(), R.color.purple_500));
        }
        else{

            btnDq1.setBackgroundColor(ContextCompat.getColor(btnDq1.getContext(), R.color.holo_orange_dark));
            btnAq1.setBackgroundColor(ContextCompat.getColor(btnAq1.getContext(), R.color.purple_500));
            btnBq1.setBackgroundColor(ContextCompat.getColor(btnBq1.getContext(), R.color.purple_500));
            btnCq1.setBackgroundColor(ContextCompat.getColor(btnCq1.getContext(), R.color.purple_500));
        }
    }
}
