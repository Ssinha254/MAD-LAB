package com.example.lab3_q2;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etNum1, etNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);

        findViewById(R.id.btnAdd).setOnClickListener(v -> calculate('+'));
        findViewById(R.id.btnSub).setOnClickListener(v -> calculate('-'));
        findViewById(R.id.btnMul).setOnClickListener(v -> calculate('*'));
        findViewById(R.id.btnDiv).setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char op) {
        String s1 = etNum1.getText().toString();
        String s2 = etNum2.getText().toString();

        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "Enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double n1 = Double.parseDouble(s1);
        double n2 = Double.parseDouble(s2);
        double result;

        if (op == '/' && n2 == 0) {
            Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (op) {
            case '+': result = n1 + n2; break;
            case '-': result = n1 - n2; break;
            case '*': result = n1 * n2; break;
            case '/': result = n1 / n2; break;
            default: return;
        }

        String symbol = (op == '*') ? "×" : (op == '/') ? "÷" : String.valueOf(op);
        String expression = s1 + " " + symbol + " " + s2 + " = " + result;

        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("result", expression);
        startActivity(intent);
    }
}
