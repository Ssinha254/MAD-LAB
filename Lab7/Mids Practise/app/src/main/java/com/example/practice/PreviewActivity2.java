package com.example.practice;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class PreviewActivity2 extends AppCompatActivity {

    Button btn3, btn4;
    TextView genderval, oeval, craval, messval, labval, stay;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // 1. Initialize all views from activity_summary.xml
        craval = findViewById(R.id.cra);
        oeval = findViewById(R.id.oe);
        labval = findViewById(R.id.lab);
        messval = findViewById(R.id.mess);
        stay = findViewById(R.id.stay);
        genderval = findViewById(R.id.gender);
        datePicker = findViewById(R.id.datePicker);
        btn3 = findViewById(R.id.btn3); // Confirm button
        btn4 = findViewById(R.id.btn4); // Back button

        // 2. Retrieve data passed from MainActivity
        ArrayList<String> options = getIntent().getStringArrayListExtra("options");
        String toggle = getIntent().getStringExtra("toggle");
        String gender = getIntent().getStringExtra("gender");

        // 3. Display the data in TextViews
        if (toggle != null) {
            stay.setText("Stay Mode: " + toggle);
        }
        
        // Reset texts before setting (optional but safer)
        craval.setText("");
        oeval.setText("");
        messval.setText("");
        labval.setText("");

        if (options != null) {
            if (options.contains("cra")) craval.setText("Selected: CRA");
            if (options.contains("oe")) oeval.setText("Selected: OE");
            if (options.contains("mess")) messval.setText("Selected: MESS");
            if (options.contains("lab")) labval.setText("Selected: LAB");
        }
        
        if (gender != null) {
            genderval.setText("Gender: " + gender);
        }

        // 4. Configure DatePicker
        Calendar calendar = Calendar.getInstance();
        datePicker.setMinDate(calendar.getTimeInMillis());

        // 5. Button Listeners
        btn3.setOnClickListener(view -> {
            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth() + 1;
            int year = datePicker.getYear();
            String date = day + "/" + month + "/" + year;
            Toast.makeText(PreviewActivity2.this, "Application Confirmed for: " + date, Toast.LENGTH_LONG).show();
        });

        btn4.setOnClickListener(view -> {
            finish(); // Returns to MainActivity
        });
    }

    // 6. Menu implementation
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_confirm) {
            Toast.makeText(this, "Confirmed via Menu", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.back) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
