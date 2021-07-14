package com.example.zadaniea4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.net.Uri;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText textNumber;
    EditText textBody;
    EditText textGeoLocation;
    EditText textIndex;
    TextView textViewFullName;
    TextView textGrade;
    Button contactBt;
    Button smsBt;
    Button geoSearchBt;
    Button myActivityBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNumber = (EditText) findViewById(R.id.textNumber);
        textBody = (EditText) findViewById(R.id.textBody);
        textGeoLocation = (EditText) findViewById(R.id.textGeoLocation);
        textIndex = (EditText) findViewById(R.id.textIndex);
        textViewFullName = (TextView) findViewById(R.id.textViewFullName);
        textGrade = (EditText) findViewById(R.id.textGrade);
        smsBt = (Button) findViewById(R.id.SmsBt);
        smsBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "smsto:" + textNumber.getText().toString();
                String smsBody = textBody.getText().toString();
                Intent intent = new Intent(
                        Intent.ACTION_SENDTO,
                        Uri.parse(number));
                intent.putExtra("sms_body", smsBody);
                startActivity(intent);

            }
        });

        contactBt = (Button) findViewById(R.id.ContactBt);
        contactBt.setOnClickListener(v -> {
            String myData = "content://contacts/people/";
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(myData));
            startActivity(intent);
        });

        geoSearchBt = (Button) findViewById(R.id.GeoSearchBt);
        geoSearchBt.setOnClickListener(v -> {
            String thePlace = textGeoLocation.getText().toString();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=(" + thePlace + ")"));
            startActivity(intent);
        });

        myActivityBt = (Button) findViewById(R.id.MyActivityBt);
        myActivityBt.setOnClickListener(v -> {
            String temp = textIndex.getText().toString();
            int studentIndex = Integer.parseInt(temp);
            temp = textGrade.getText().toString();
            int studentGrade = Integer.parseInt(temp);
            Intent myIntentM1M2 = new Intent(MainActivity.this, MainActivity2.class);
            Bundle myDataBundle = new Bundle();
            myDataBundle.putInt("val1", studentIndex);
            myDataBundle.putInt("val2", studentGrade);

            myIntentM1M2.putExtras(myDataBundle);
            startActivityForResult(myIntentM1M2, 101);
        });
    }
}
