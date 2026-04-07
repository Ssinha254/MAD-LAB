package com.example.lab3_q2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tv = findViewById(R.id.tvResult);
        String result = getIntent().getStringExtra("result");
        tv.setText(result);
    }
}
