package com.example.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpensesList extends AppCompatActivity {
    Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expenses_list);

        DatabaseHelper db = new DatabaseHelper(this);
        ;
        List<HashMap<String, String>> expenseList = db.getAll("expenses");
        ArrayList<String> items = new ArrayList<>();
        for (HashMap<String, String> row : expenseList) {
            String name = row.get("title");
            String amount = row.get("amount");
            String category = row.get("category");
            String date = row.get("date");
            String mode = row.get("mode");
            String finaled = name + "\n" + amount + "\n" + category + "\n" + date + "\n" + mode;
            items.add(finaled);
        }
        ListView listView = findViewById(R.id.listView);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                items
        );

        listView.setAdapter(adapter);


        btnEdit = findViewById(R.id.btnEdit);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // go back to MainActivity for editing
            }
        });
        for(int i=0;i<expenseList.size();i++)
    }}



