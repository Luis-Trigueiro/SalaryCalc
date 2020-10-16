package com.example.salarycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText n1, n2, n3;
    double salBruto, dependent, otherdisc;
    double inss, irrf, saliq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View view) {
        n1 = (EditText) findViewById(R.id.n1);
        salBruto = Double.parseDouble(n1.getText().toString());
        n2 = (EditText) findViewById(R.id.n2);
        dependent = Double.parseDouble(n2.getText().toString());
        n3 = (EditText) findViewById(R.id.n3);
        otherdisc = Double.parseDouble(n3.getText().toString());
        calculateInss();
        calculateIrrf();
        salLiq();
        nextPage();
    }

    public void calculateInss() {
        double a1 = 1045;
        double a2 = 2089.60;
        double a3 = 3134.40;
        double a4 = 6101.06;

        if (salBruto <= a1) {
            inss = salBruto * 7.5 / 100;
        }
        if (salBruto > a1 && salBruto <= a2) {
            inss = salBruto * 9 / 100 - 15.67;
        }
        if (salBruto > a2 && salBruto <= a3) {
            inss = salBruto * 12 / 100 - 78.36;
        }
        if (salBruto > a3 && salBruto <= a4) {
            inss = salBruto * 14 / 100 - 141.05;
        }
        if (salBruto > a4) {
            inss = 713.10;
        }
    }

    public void calculateIrrf() {
        double bc1 = 1903.98;
        double bc2 = 2826.65;
        double bc3 = 3757.05;
        double bc4 = 4664.68;

        double baseCalc = (salBruto - inss) - dependent * 189.59;

        if (baseCalc <= bc1) {
            irrf = 0;
        }
        if (baseCalc > bc1 && baseCalc <= bc2) {
            irrf = baseCalc * 7.5 / 100 - 142.80;
        }
        if (baseCalc > bc2 && baseCalc <= bc3) {
            irrf = baseCalc * 15.0 / 100 - 354.80;
        }
        if (baseCalc > bc3 && baseCalc <= bc4) {
            irrf = baseCalc * 22.5 / 100 - 636.13;
        }
        if (baseCalc > bc4) {
            irrf = baseCalc * 27.5 / 100 - 869.36;
        }
    }

    public void salLiq() {
        saliq = salBruto - inss - irrf - otherdisc;
    }

    public void nextPage() {
        Intent messageIntent = new Intent(this, NewActivity.class);
        messageIntent.putExtra("inss", inss);
        messageIntent.putExtra("irrf", irrf);
        messageIntent.putExtra("od", otherdisc);
        messageIntent.putExtra("salliq", saliq);
        messageIntent.putExtra("salb", salBruto);
        startActivity(messageIntent);
    }
}
