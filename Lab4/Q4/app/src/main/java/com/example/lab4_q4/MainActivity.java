package com.example.lab4_q4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CheckBox cbPizza, cbBurger, cbDosa, cbCoffee;
    Button btnSubmit;

    boolean submitted = false; // to prevent changes after submit

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbPizza = findViewById(R.id.cbPizza);
        cbBurger = findViewById(R.id.cbBurger);
        cbDosa = findViewById(R.id.cbDosa);
        cbCoffee = findViewById(R.id.cbCoffee);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            if (submitted) return; // already submitted

            ArrayList<String> items = new ArrayList<>();
            ArrayList<Integer> costs = new ArrayList<>();
            int total = 0;

            if (cbPizza.isChecked()) { items.add("Pizza"); costs.add(150); total += 150; }
            if (cbBurger.isChecked()) { items.add("Burger"); costs.add(80); total += 80; }
            if (cbDosa.isChecked()) { items.add("Dosa"); costs.add(60); total += 60; }
            if (cbCoffee.isChecked()) { items.add("Coffee"); costs.add(30); total += 30; }

            if (items.isEmpty()) {
                Toast.makeText(this, "Select at least one item", Toast.LENGTH_SHORT).show();
                return;
            }

            // Disable checkboxes so order cannot be changed
            submitted = true;
            setCheckboxEnabled(false);

            Intent intent = new Intent(MainActivity.this, OrderSummaryActivity.class);
            intent.putStringArrayListExtra("items", items);
            intent.putIntegerArrayListExtra("costs", costs);
            intent.putExtra("total", total);
            startActivity(intent);
        });
    }

    private void setCheckboxEnabled(boolean enabled) {
        cbPizza.setEnabled(enabled);
        cbBurger.setEnabled(enabled);
        cbDosa.setEnabled(enabled);
        cbCoffee.setEnabled(enabled);
        btnSubmit.setEnabled(enabled); // optional: stop resubmitting
    }
}
