package com.example.lab2_q3;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RelativeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);

        EditText et = findViewById(R.id.etInput);
        Button ok = findViewById(R.id.btnOk);
        Button cancel = findViewById(R.id.btnCancel);

        ok.setOnClickListener(v -> {
            String text = et.getText().toString().trim();
            Toast.makeText(this, "You typed: " + text, Toast.LENGTH_SHORT).show();
        });

        cancel.setOnClickListener(v -> {
            et.setText("");
            Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
        });
    }
}
