package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  android.widget.Button  mcalbmi;
  TextView  mcuheight;
  TextView mcurage,mcurweight;
  ImageView mincrage,mincrweight, mdcrage,mdcrweight;
  SeekBar mseekbarfrheight;
  RelativeLayout mmale,mfemale;
  int intwt = 55;
  int intage = 22;
  int currentprogress;
  String mintprogress = "170";
  String typeofuser = "0";
  String wht2 = "55";
  String age2 = "22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mcalbmi = findViewById(R.id.calculatebmi);
        mcurage = findViewById(R.id.currentage);
        mcurweight = findViewById(R.id.currentweight);
        mcuheight =  findViewById(R.id.currentheight);
        mincrage = findViewById(R.id.incage);
        mdcrage = findViewById(R.id.dcrcage);
        mincrweight = findViewById(R.id.incweight);
        mdcrweight = findViewById(R.id.decweight);
        mseekbarfrheight = findViewById(R.id.seekbarforheight);
        mmale = findViewById(R.id.male);
        mfemale = findViewById(R.id.female);

        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser = "Male";
            }
        });
        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser = "Female";
            }
        });

        mseekbarfrheight.setMax(300);
        mseekbarfrheight.setProgress(170);
        mseekbarfrheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                currentprogress = i;
                mintprogress = String.valueOf(currentprogress);
                mcuheight.setText(mintprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mincrage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intage = intage + 1 ;
                age2 = String.valueOf(intage);
                mcurage.setText(age2);
            }
        });
        mdcrage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intage = intage - 1 ;
                age2 = String.valueOf(intage);
                mcurage.setText(age2);
            }
        });

        mincrweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intwt = intwt + 1 ;
                wht2 = String.valueOf(intwt);
                mcurweight.setText(wht2);
            }
        });

        mdcrweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intwt = intwt - 1 ;
                wht2 = String.valueOf(intwt);
                mcurweight.setText(wht2);
            }
        });

        mcalbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(typeofuser.equals("0")){
                    Toast.makeText(MainActivity.this, "Select your gender first", Toast.LENGTH_SHORT).show();
                }
                else if(mintprogress.equals("0")){
                    Toast.makeText(MainActivity.this, "Select your Height first", Toast.LENGTH_SHORT).show();

                }
                else if(intage == 0 || intage<0){
                    Toast.makeText(MainActivity.this, "Age is Incorrect", Toast.LENGTH_SHORT).show();

                }
                else if(intwt == 0 || intwt<0){

                    Toast.makeText(MainActivity.this, "Age is Incorrect", Toast.LENGTH_SHORT).show();

                }
                else{
                    Intent intent = new Intent(MainActivity.this,bmiactivity.class);
                    intent.putExtra("gender", typeofuser);
                    intent.putExtra("height",mintprogress);
                    intent.putExtra("weight", wht2);
                    intent.putExtra("age", age2);



                    startActivity(intent);

                }

            }
        });
    }
}