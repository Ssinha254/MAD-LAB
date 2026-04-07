package com.example.lab5_q1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerVehicleType;
    EditText etVehicleNumber, etRcNumber;
    Button btnSubmit;

    String[] vehicleTypes = {"Select Vehicle Type", "Car", "Bike", "Scooter", "Bus", "Truck"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        spinnerVehicleType = findViewById(R.id.spinnerVehicleType);
        etVehicleNumber = findViewById(R.id.etVehicleNumber);
        etRcNumber = findViewById(R.id.etRcNumber);
        btnSubmit = findViewById(R.id.btnSubmit);

        clearFields();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                vehicleTypes
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVehicleType.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vehicleType = spinnerVehicleType.getSelectedItem().toString();
                String vehicleNumber = etVehicleNumber.getText().toString().trim();
                String rcNumber = etRcNumber.getText().toString().trim();

                if (vehicleType.equals("Select Vehicle Type")) {
                    Toast.makeText(MainActivity.this, "Please select vehicle type", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (vehicleNumber.isEmpty()) {
                    etVehicleNumber.setError("Enter vehicle number");
                    etVehicleNumber.requestFocus();
                    return;
                }

                if (rcNumber.isEmpty()) {
                    etRcNumber.setError("Enter RC number");
                    etRcNumber.requestFocus();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, PreviewActivity.class);
                intent.putExtra("vehicleType", vehicleType);
                intent.putExtra("vehicleNumber", vehicleNumber);
                intent.putExtra("rcNumber", rcNumber);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void clearFields() {
        spinnerVehicleType.setSelection(0);
        etVehicleNumber.setText("");
        etRcNumber.setText("");
    }
}
