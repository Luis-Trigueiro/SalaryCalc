package com.example.salarycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        result();
    }

    public void result() {
        Intent intent = getIntent();
        Intent intent2 = getIntent();
        Intent intent3 = getIntent();
        Intent intent4 = getIntent();
        Intent intent5 = getIntent();
        double inss = (double) intent.getSerializableExtra("inss");
        double irrf = (double) intent2.getSerializableExtra("irrf");
        double od = (double) intent3.getSerializableExtra("od");
        double salliq = (double) intent4.getSerializableExtra("salliq");
        double salb = (double) intent5.getSerializableExtra("salb");
        TextView resinss = (TextView) findViewById(R.id.inss);
        resinss.setText(String.valueOf(inss));
        TextView resirrf = (TextView) findViewById(R.id.irrf);
        resirrf.setText(String.valueOf(irrf));
        TextView resod = (TextView) findViewById(R.id.od);
        resod.setText(String.valueOf(od));
        TextView resliq = (TextView) findViewById(R.id.slq);
        resliq.setText(String.valueOf(salliq));
        TextView resbrut = (TextView) findViewById(R.id.sal);
        resbrut.setText(String.valueOf(salb));
    }

    public void mainActivity(View view) {
        Intent messageIntent = new Intent(this, MainActivity.class);
        startActivity(messageIntent);
    }
}