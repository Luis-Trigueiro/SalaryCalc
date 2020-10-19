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

        double inss = (double) intent.getSerializableExtra("inss");
        double irrf = (double) intent.getSerializableExtra("irrf");
        double od = (double) intent.getSerializableExtra("od");
        double salliq = (double) intent.getSerializableExtra("salliq");
        double salb = (double) intent.getSerializableExtra("salb");
        double disc = (double) intent.getSerializableExtra("disc");

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
        TextView resdisc = (TextView) findViewById(R.id.disc);
        resdisc.setText(String.valueOf(disc));
    }

    public void mainActivity(View view) {
        Intent messageIntent = new Intent(this, MainActivity.class);
        startActivity(messageIntent);
    }
}