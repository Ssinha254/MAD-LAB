package com.example.lab8_q2;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etItemName, etItemCost;
    Button btnAddItem, btnSelectItem, btnShowTotal;
    Spinner spinnerItems;
    TextView tvSelectedItems, tvTotalCost;

    DatabaseHelper dbHelper;

    ArrayList<String> itemList;
    ArrayList<Integer> itemIdList;
    ArrayList<String> selectedItems;
    int totalCost = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etItemName = findViewById(R.id.etItemName);
        etItemCost = findViewById(R.id.etItemCost);
        btnAddItem = findViewById(R.id.btnAddItem);
        btnSelectItem = findViewById(R.id.btnSelectItem);
        btnShowTotal = findViewById(R.id.btnShowTotal);
        spinnerItems = findViewById(R.id.spinnerItems);
        tvSelectedItems = findViewById(R.id.tvSelectedItems);
        tvTotalCost = findViewById(R.id.tvTotalCost);

        dbHelper = new DatabaseHelper(this);
        selectedItems = new ArrayList<>();

        loadSpinnerData();

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemName = etItemName.getText().toString().trim();
                String itemCostStr = etItemCost.getText().toString().trim();

                if (itemName.isEmpty()) {
                    etItemName.setError(getString(R.string.hint_item_name));
                    return;
                }

                if (itemCostStr.isEmpty()) {
                    etItemCost.setError(getString(R.string.hint_item_cost));
                    return;
                }

                int itemCost;
                try {
                    itemCost = Integer.parseInt(itemCostStr);
                } catch (NumberFormatException e) {
                    etItemCost.setError("Invalid cost");
                    return;
                }

                boolean inserted = dbHelper.insertItem(itemName, itemCost);

                if (inserted) {
                    Toast.makeText(MainActivity.this, "Item added successfully", Toast.LENGTH_SHORT).show();
                    etItemName.setText("");
                    etItemCost.setText("");
                    loadSpinnerData();
                } else {
                    Toast.makeText(MainActivity.this, "Failed to add item", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSelectItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemIdList == null || itemIdList.isEmpty()) {
                    Toast.makeText(MainActivity.this, "No items available", Toast.LENGTH_SHORT).show();
                    return;
                }

                int position = spinnerItems.getSelectedItemPosition();

                if (position >= 0 && position < itemIdList.size()) {
                    int itemId = itemIdList.get(position);
                    Cursor cursor = dbHelper.getItemById(itemId);

                    if (cursor != null && cursor.moveToFirst()) {
                        String name = cursor.getString(cursor.getColumnIndexOrThrow("item_name"));
                        int cost = cursor.getInt(cursor.getColumnIndexOrThrow("item_cost"));

                        selectedItems.add(name + " - ₹" + cost);
                        totalCost += cost;

                        StringBuilder builder = new StringBuilder(getString(R.string.label_selected_items));
                        for (String item : selectedItems) {
                            builder.append(item).append("\n");
                        }

                        tvSelectedItems.setText(builder.toString());
                    }

                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        });

        btnShowTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTotalCost.setText(getString(R.string.total_cost_format, totalCost));
            }
        });
    }

    private void loadSpinnerData() {
        itemList = new ArrayList<>();
        itemIdList = new ArrayList<>();

        Cursor cursor = dbHelper.getAllItems();

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                    String name = cursor.getString(cursor.getColumnIndexOrThrow("item_name"));
                    int cost = cursor.getInt(cursor.getColumnIndexOrThrow("item_cost"));

                    itemIdList.add(id);
                    itemList.add(name + " (₹" + cost + ")");
                } while (cursor.moveToNext());
            }
            cursor.close();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                itemList
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerItems.setAdapter(adapter);
    }
}