package com.example.practice;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText editTextInput;
    private Button buttonActionPrimary;
    private RadioGroup radioGroupOptions;
    private Spinner spinnerOptions;
    private DatePicker datePickerInput;
    private TimePicker timePickerInput;
    private DatabaseHelper dbHelper;
    private int editId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);

        editTextInput = findViewById(R.id.editTextInput);
        buttonActionPrimary = findViewById(R.id.buttonActionPrimary);
        radioGroupOptions = findViewById(R.id.radioGroupOptions);
        spinnerOptions = findViewById(R.id.spinnerOptions);
        datePickerInput = findViewById(R.id.datePickerInput);
        timePickerInput = findViewById(R.id.timePickerInput);

        String[] options = {"Dr. Smith – Cardio", "Dr. Lee – Ortho", "Dr. Patel – General"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptions.setAdapter(spinnerAdapter);

        // SharedPreferences for hint
        SharedPreferences prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        String lastPatient = prefs.getString("last_patient", "");
        if (!lastPatient.isEmpty()) {
            editTextInput.setHint("Last: " + lastPatient);
        }

        // Check for Edit Intent
        if (getIntent().hasExtra("editId")) {
            editId = getIntent().getIntExtra("editId", -1);
            editTextInput.setText(getIntent().getStringExtra("name"));
            // For simplicity in this demo, we won't perfectly set spinner/date/time from intent, 
            // but in a real app you'd map them back.
            buttonActionPrimary.setText("Update Appointment");
        }

        buttonActionPrimary.setOnClickListener(v -> saveTask());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_1) {
            startActivity(new Intent(this, AppointmentDetails.class));
            return true;
        } else if (item.getItemId() == R.id.menu_2) {
            clearForm();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void clearForm() {
        editTextInput.setText("");
        radioGroupOptions.clearCheck();
        spinnerOptions.setSelection(0);
    }

    private void saveTask() {
        String name = editTextInput.getText().toString().trim();
        if (name.isEmpty()) {
            editTextInput.setError("Name is required");
            return;
        }

        int selectedRadioId = radioGroupOptions.getCheckedRadioButtonId();
        if (selectedRadioId == -1) {
            Toast.makeText(this, "Select Appointment Type", Toast.LENGTH_SHORT).show();
            return;
        }

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_NAME, name);
        values.put(DatabaseHelper.COL_DOCTOR, spinnerOptions.getSelectedItem().toString());
        values.put(DatabaseHelper.COL_DATE, datePickerInput.getDayOfMonth() + "/" + (datePickerInput.getMonth() + 1) + "/" + datePickerInput.getYear());
        
        int hour = (android.os.Build.VERSION.SDK_INT >= 23) ? timePickerInput.getHour() : timePickerInput.getCurrentHour();
        int minute = (android.os.Build.VERSION.SDK_INT >= 23) ? timePickerInput.getMinute() : timePickerInput.getCurrentMinute();
        values.put(DatabaseHelper.COL_TIME, String.format("%02d:%02d", hour, minute));
        
        RadioButton rb = findViewById(selectedRadioId);
        values.put(DatabaseHelper.COL_STATUS, "Pending (" + rb.getText() + ")");

        if (editId == -1) {
            long id = dbHelper.insert(DatabaseHelper.TABLE_NAME, values);
            Toast.makeText(this, "APPT-" + id, Toast.LENGTH_LONG).show();
        } else {
            dbHelper.update(DatabaseHelper.TABLE_NAME, values, DatabaseHelper.COL_ID + "=?", new String[]{String.valueOf(editId)});
            Toast.makeText(this, "Updated APPT-" + editId, Toast.LENGTH_SHORT).show();
        }

        // Save last patient name
        getSharedPreferences("AppPrefs", MODE_PRIVATE).edit().putString("last_patient", name).apply();
        
        startActivity(new Intent(this, AppointmentDetails.class));
        finish();
    }
}
