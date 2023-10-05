package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("BMI CALCULATER");
        //getSupportActionBar().setTitle("bmiapp");
        TextView txtresult;
        EditText edtheightft,edtheightinch,edtweight;
        Button btncalculate;
        LinearLayout llmain;

        edtweight=findViewById(R.id.edtweight);
        edtheightft=findViewById(R.id.edtheightft);
        edtheightinch=findViewById(R.id.edtheightinch);
        btncalculate=findViewById(R.id.btncalculate);
        txtresult=findViewById(R.id.txtresult);
        llmain=findViewById(R.id.llmain);

        btncalculate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
            int wt= Integer.parseInt(edtweight.getText().toString());
            int ft= Integer.parseInt(edtheightft.getText().toString());
            int in= Integer.parseInt(edtheightinch.getText().toString());

            int totalIn = ft*12 + in;
           double totalCm = totalIn*2.53;
           double totalM = totalCm/100;
           double bmi = wt/(totalM*totalM);

           if(bmi>25){
               txtresult.setText("You are over weigth");
               llmain.setBackgroundColor(getResources().getColor(R.color.overweigth));
           } else if (bmi<18) {
               txtresult.setText("You are under weigth");
               llmain.setBackgroundColor(getResources().getColor(R.color.underweight));

           }
           else  {
               txtresult.setText("You are healthy");
               llmain.setBackgroundColor(getResources().getColor(R.color.healthy));

           }
            }
        });
    }



}