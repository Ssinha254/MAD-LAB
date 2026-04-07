package com.example.lab4_q4;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class OrderSummaryActivity extends AppCompatActivity {

    TableLayout tableOrders;
    TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        tableOrders = findViewById(R.id.tableOrders);
        tvTotal = findViewById(R.id.tvTotal);

        ArrayList<String> items = getIntent().getStringArrayListExtra("items");
        ArrayList<Integer> costs = getIntent().getIntegerArrayListExtra("costs");
        int total = getIntent().getIntExtra("total", 0);

        // Header row
        TableRow header = new TableRow(this);
        TextView h1 = new TextView(this); h1.setText("Item");
        TextView h2 = new TextView(this); h2.setText("Cost");
        header.addView(h1);
        header.addView(h2);
        tableOrders.addView(header);

        // Data rows
        for (int i = 0; i < items.size(); i++) {
            TableRow row = new TableRow(this);

            TextView c1 = new TextView(this);
            c1.setText(items.get(i));

            TextView c2 = new TextView(this);
            c2.setText("₹" + costs.get(i));

            row.addView(c1);
            row.addView(c2);

            tableOrders.addView(row);
        }

        tvTotal.setText("Total Cost: ₹" + total);
    }
}
