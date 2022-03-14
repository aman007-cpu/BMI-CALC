package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class bmiactivity extends AppCompatActivity {
   android.widget.Button mrecalbmi;
   TextView mbmidisp, mbmicat, mgender;
   Intent intent;
   ImageView mimageview;
   String mbmi;
   float intbmi;
   String height;
   String weight;
   float intheight, intweight;
   RelativeLayout mbackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

getSupportActionBar().setElevation(0);
getSupportActionBar().setTitle(Html.fromHtml("<font color=\'white'></font>"));
getSupportActionBar().setTitle("Result");
ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
getSupportActionBar().setBackgroundDrawable(colorDrawable);


intent = getIntent();

mbmidisp = findViewById(R.id.bmidisplay);
mbmicat = findViewById(R.id.bmicat);
mgender =findViewById(R.id.genderdisplay);
mbackground = findViewById(R.id.contentlayout);
height = intent.getStringExtra("height");
mimageview = findViewById(R.id.imageview);
mrecalbmi = findViewById(R.id.recalculatebmi);
weight = intent.getStringExtra("weight");
intheight = Float.parseFloat(height);
intweight = Float.parseFloat(weight);
intheight = intheight/100;
intbmi = intweight/(intheight*intheight);
mbmi = Float.toString(intbmi);
if(intbmi<16){

    mbmicat.setText("severe Thinness");
    mbackground.setBackgroundColor(Color.RED);
    mimageview.setImageResource(R.drawable.crosss);

}
else if(intbmi<16.9 && intbmi>16){
    mbmicat.setText("Moderate Thinness");
    mbackground.setBackgroundColor(Color.RED);
    mimageview.setImageResource(R.drawable.warning);
}

else if(intbmi<18.4 && intbmi>17){
    mbmicat.setText("Mild Thinness");
    mbackground.setBackgroundColor(Color.RED);
    mimageview.setImageResource(R.drawable.warning);
}
else if(intbmi<25 && intbmi>18.4){
            mbmicat.setText("Normal");
            mbackground.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.ok);
        }

else if(intbmi<29.4 && intbmi>25){
    mbmicat.setText("Overweight");
    mbackground.setBackgroundColor(Color.RED);
    mimageview.setImageResource(R.drawable.warning);
}
else{

        mbmicat.setText("Obese Class");
        mbackground.setBackgroundColor(Color.RED);
        mimageview.setImageResource(R.drawable.warning);

}

mgender.setText(intent.getStringExtra("gender"));
mbmidisp.setText(mbmi);


mrecalbmi = findViewById(R.id.recalculatebmi);
mrecalbmi.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent =  new Intent(bmiactivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
});
    }
}