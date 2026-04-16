package com.example.demo;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button submit, clear;
    EditText title, amount;
    Spinner category;
    DatePicker datePicker;
    RadioGroup rg;
    DatabaseHelper dbHelper;
    List<HashMap<String, String>> expenseList;
    ArrayAdapter<String> adapter;
    ArrayList<String> displayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        dbHelper = new DatabaseHelper(this);

        displayList = new ArrayList<>();
        expenseList = new ArrayList<>();

        submit = findViewById(R.id.submit);
        clear = findViewById(R.id.clear);
        title = findViewById(R.id.title);
        amount = findViewById(R.id.amount);
        category = findViewById(R.id.category);
        datePicker = findViewById(R.id.datePicker);
        rg = findViewById(R.id.rg);
        ArrayList<String> cats = new ArrayList<>();
        cats.add("Food");
        cats.add("Transport");
        cats.add("Entertainment");

        ArrayAdapter<String> Adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                cats
        );
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(Adapter);


        submit.setOnClickListener(v -> saveTask());
        clear.setOnClickListener(v -> clear());


    }


    private void saveTask() {

        ContentValues values = new ContentValues();
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();
        String date = day + "/" + month + "/" + year;
        values.put("title", title.getText().toString());
        values.put("amount", amount.getText().toString());
        values.put("category", category.getSelectedItem().toString());
        values.put("date", date);
        int selectedId = rg.getCheckedRadioButtonId();

        if (selectedId != -1) {
            RadioButton selected = findViewById(selectedId);
            String value = selected.getText().toString();
            values.put("mode", value);
        }


        dbHelper.insert("expenses", values);

        Intent intent = new Intent(MainActivity.this, ExpensesList.class);

        startActivity(intent);
    }

    private void clear() {
        title.setText("");
        amount.setText("");
        category.setSelection(0);
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        datePicker.updateDate(currentYear, currentMonth, currentDay);
        rg.clearCheck();

    }
}