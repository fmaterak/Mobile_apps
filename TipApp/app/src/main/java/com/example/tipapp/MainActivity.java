package com.example.tipapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText editTextPrice;
    EditText editTextTip;

    RatingBar ratingBarService;
    RatingBar ratingBarFood;

    Button buttonCalculate;
    Button buttonClear;

    TextView txtViewFinalPrice;

    double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.parseDouble(twoDForm.format(d));
    }


    double calculateTip(double payment, double ratingService, double ratingFood, double tipPercent) {
        return tipPercent * payment + (tipPercent * ratingFood * payment)/5 + (tipPercent * ratingService * payment)/5;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPrice = findViewById(R.id.editTextPrice);

        editTextTip = findViewById(R.id.editTextTip);
        editTextTip.setInputType(EditorInfo.TYPE_NULL);

        ratingBarFood = findViewById(R.id.ratingBarFood);
        ratingBarService = findViewById(R.id.ratingBarService);

        txtViewFinalPrice = findViewById(R.id.textViewFinalPrice);

        buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(v -> {
            txtViewFinalPrice.setText("0.00");
            editTextTip.setText("");
            editTextPrice.setText("");
            ratingBarFood.setRating(0);
            ratingBarService.setRating(0);
        });


        buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonCalculate.setOnClickListener(v -> {
            try {
                String paymentStr = editTextPrice.getText().toString();
                String tipStr = editTextTip.getText().toString();
                double payment = Double.parseDouble(paymentStr);
                double ratingService = ratingBarService.getRating();
                double ratingFood = ratingBarFood.getRating();
                double tipPercent = Double.parseDouble(tipStr) / 200;
                String tip = String.valueOf(roundTwoDecimals(calculateTip(payment, ratingService, ratingFood, tipPercent)));

                double finalPrice = Double.parseDouble(editTextPrice.getText().toString()) + Double.parseDouble(tip);

                txtViewFinalPrice.setText(String.valueOf(finalPrice));
            } catch (NumberFormatException e) {
                //
            }
        });
    }
}