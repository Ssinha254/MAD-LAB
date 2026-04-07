package com.example.lab2_q3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        Button btn = findViewById(R.id.btnOpenRelative);
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RelativeActivity.class);
            startActivity(intent);
        });
    }
}

