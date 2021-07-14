package com.example.zadaniea4;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends MainActivity implements View.OnClickListener {
    TextView textName;
    TextView textSurname;
    Button buttonBack;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textSurname = (TextView) findViewById(R.id.textSurname);
        textName = (TextView) findViewById(R.id.textName);
        textGrade = (TextView) findViewById(R.id.textGrade);
        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener((View.OnClickListener) this);

        Intent myLocalIntent = getIntent();

        Bundle myBundle = myLocalIntent.getExtras();
        int v1 = myBundle.getInt("val1");
        int v2 = myBundle.getInt("val2");
        int v3 = myBundle.getInt("val3");

        String vResult1;
        String vResult2;
        String vResult3;
        if ((v1 == 249482) && (v2 == 3)) {
            textName.setText("Filip");
            textSurname.setText("Materak");
            textGrade.setText("4.5");
            vResult1 = "Filip";
            vResult2 = "Materak";
            vResult3 = "4.5";
        } else {
            textName.setText("ErrorNotFoundStudent");
            textSurname.setText("ErrorNotFoundStudent");
            vResult1 = "ErrorNotFoundStudent";
            vResult2 = "ErrorNotFoundStudent";
        }

        myBundle.putString("vresult1", vResult1);
        myBundle.putString("vresult2", vResult2);
        myBundle.putString("vresult3", vResult2);


        myLocalIntent.putExtras(myBundle);

        setResult(Activity.RESULT_OK, myLocalIntent);
    }

    public void onClick(View v) {
        finish();
    }
}