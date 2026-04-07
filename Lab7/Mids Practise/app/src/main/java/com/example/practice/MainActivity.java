package com.example.practice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleMode;
    CheckBox cra, oe, mess, lab;
    Button btn1, btn2;
    RadioGroup rgGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        toggleMode = findViewById(R.id.toggleMode);
        rgGender = findViewById(R.id.rgGender);
        cra =  findViewById(R.id.cra);
        oe = findViewById(R.id.oe);
        mess = findViewById(R.id.mess);
        lab = findViewById(R.id.lab);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        toggleMode.setOnCheckedChangeListener((buttonView, isWifi) -> {
            if (toggleMode.isChecked()){
                mess.setChecked(true);
            }
            if (!toggleMode.isChecked()){
                mess.setChecked(false);
            }
        });

        cra.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                oe.setEnabled(false);
            } else {
                oe.setEnabled(true);
            }
        });

        oe.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                cra.setEnabled(false);
            } else {
                cra.setEnabled(true);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> options = new ArrayList<>();
                String toggleVal ;
                toggleVal =toggleMode.isChecked()?"Hostel":"OffCampus";
                
                if (oe.isChecked()){
                    options.add("oe");
                };
                if (cra.isChecked()){
                    options.add("cra");
                };
                if (mess.isChecked()){
                    options.add("mess");
                };
                if (lab.isChecked()){
                    options.add("lab");
                };

                int selectedId = rgGender.getCheckedRadioButtonId();
                String value = "Not Selected";
                if (selectedId != -1) {
                    RadioButton selected = findViewById(selectedId);
                    value = selected.getText().toString();
                }
                
                Intent intent = new Intent(MainActivity.this, PreviewActivity2.class);
                intent.putStringArrayListExtra("options", options);
                intent.putExtra("toggle", toggleVal);
                intent.putExtra("gender", value);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleMode.setChecked(false);
                cra.setChecked(false);
                oe.setChecked(false);
                mess.setChecked(false);
                lab.setChecked(false);
                rgGender.clearCheck();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
