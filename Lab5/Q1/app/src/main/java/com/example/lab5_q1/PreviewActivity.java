package com.example.lab5_q1;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle; // Add this extra

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PreviewActivity extends AppCompatActivity {
    TextView tvVehicleType, tvVehicleNumber, tvRcNumber;
    Button btnConfirm, btnEdit, btnBackHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview_activity);

        tvVehicleType = findViewById(R.id.tvVehicleType);
        tvVehicleNumber = findViewById(R.id.tvVehicleNumber);
        tvRcNumber = findViewById(R.id.tvRcNumber);
        btnConfirm = findViewById(R.id.btnConfirm);
        btnEdit = findViewById(R.id.btnEdit);
        btnBackHome = findViewById(R.id.btnBackHome);

        String vehicleType = getIntent().getStringExtra("vehicleType");
        String vehicleNumber = getIntent().getStringExtra("vehicleNumber");
        String rcNumber = getIntent().getStringExtra("rcNumber");

        tvVehicleType.setText("Vehicle Type: " + vehicleType);
        tvVehicleNumber.setText("Vehicle Number: " + vehicleNumber);
        tvRcNumber.setText("RC Number: " + rcNumber);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String serialNumber = generateSerialNumber();
                Toast.makeText(PreviewActivity.this,
                        "Parking Allotted! Serial No: " + serialNumber,
                        Toast.LENGTH_LONG).show();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // go back to MainActivity for editing
            }
        });

        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PreviewActivity.this, MainActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);
                finish();
            }
        });
    }
        private String generateSerialNumber() {
            Random random = new Random();
            int number = 1000 + random.nextInt(9000);
            return "VP" + number;
        }
    }

