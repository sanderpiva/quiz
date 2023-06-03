package com.sanderpiva.quiz;

import android.widget.Button;

import androidx.core.content.ContextCompat;

public class CorButtonQ3 {
    public CorButtonQ3(String resposta, Button btnAq3, Button btnBq3, Button btnCq3, Button btnDq3) {

        switch (resposta) {
            case "A":
                btnAq3.setBackgroundColor(ContextCompat.getColor(btnAq3.getContext(), R.color.holo_orange_dark));
                btnBq3.setBackgroundColor(ContextCompat.getColor(btnBq3.getContext(), R.color.purple_500));
                btnCq3.setBackgroundColor(ContextCompat.getColor(btnCq3.getContext(), R.color.purple_500));
                btnDq3.setBackgroundColor(ContextCompat.getColor(btnDq3.getContext(), R.color.purple_500));
                break;
            case "B":

                btnBq3.setBackgroundColor(ContextCompat.getColor(btnBq3.getContext(), R.color.holo_orange_dark));
                btnAq3.setBackgroundColor(ContextCompat.getColor(btnAq3.getContext(), R.color.purple_500));
                btnCq3.setBackgroundColor(ContextCompat.getColor(btnCq3.getContext(), R.color.purple_500));
                btnDq3.setBackgroundColor(ContextCompat.getColor(btnDq3.getContext(), R.color.purple_500));
                break;
            case "C":

                btnCq3.setBackgroundColor(ContextCompat.getColor(btnCq3.getContext(), R.color.holo_orange_dark));
                btnAq3.setBackgroundColor(ContextCompat.getColor(btnAq3.getContext(), R.color.purple_500));
                btnBq3.setBackgroundColor(ContextCompat.getColor(btnBq3.getContext(), R.color.purple_500));
                btnDq3.setBackgroundColor(ContextCompat.getColor(btnDq3.getContext(), R.color.purple_500));
                break;
            default:

                btnDq3.setBackgroundColor(ContextCompat.getColor(btnDq3.getContext(), R.color.holo_orange_dark));
                btnAq3.setBackgroundColor(ContextCompat.getColor(btnAq3.getContext(), R.color.purple_500));
                btnBq3.setBackgroundColor(ContextCompat.getColor(btnBq3.getContext(), R.color.purple_500));
                btnCq3.setBackgroundColor(ContextCompat.getColor(btnCq3.getContext(), R.color.purple_500));
                break;
        }
    }
}
