package com.example.lab1_q1;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tvText);

        Button btnRed = findViewById(R.id.btnRed);
        Button btnBlue = findViewById(R.id.btnBlue);
        Button btnBig = findViewById(R.id.btnBig);
        Button btnItalic = findViewById(R.id.btnItalic);
        Button btnFont = findViewById(R.id.btnFont);
        Button btnCenter = findViewById(R.id.btnCenter);

        btnRed.setOnClickListener(v ->
                tv.setTextColor(Color.RED));

        btnBlue.setOnClickListener(v ->
                tv.setTextColor(Color.BLUE));

        btnBig.setOnClickListener(v ->
                tv.setTextSize(26));

        btnItalic.setOnClickListener(v ->
                tv.setTypeface(null, Typeface.ITALIC));

        btnFont.setOnClickListener(v ->
                tv.setTypeface(Typeface.MONOSPACE));

        btnCenter.setOnClickListener(v ->
                tv.setGravity(Gravity.CENTER));
    }
}
