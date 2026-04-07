package com.example.lab4_q3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleMode;
    ImageView imgMode;
    TextView tvCurrentMode;
    Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCurrentMode = findViewById(R.id.tvcurrentmode);
        toggleMode = findViewById(R.id.toggleMode);
        imgMode = findViewById(R.id.imgMode);
        btnChange = findViewById(R.id.btnChange);

        // Initial UI
        updateUI(toggleMode.isChecked());

        // When user toggles manually
        toggleMode.setOnCheckedChangeListener((buttonView, isWifi) -> {
            updateUI(isWifi);
        });

        // Change Mode button: flip the toggle state
        btnChange.setOnClickListener(v -> {
            boolean current = toggleMode.isChecked();
            toggleMode.setChecked(!current); // this will trigger listener + updateUI
        });
    }

    private void updateUI(boolean isWifi) {
        if (isWifi) {
            tvCurrentMode.setText("Current Mode: Wi-Fi");
            imgMode.setImageResource(R.drawable.ic_wifi);
            Toast.makeText(this, "Current Mode: Wi-Fi", Toast.LENGTH_SHORT).show();
        } else {
            tvCurrentMode.setText("Current Mode: Mobile Data");
            imgMode.setImageResource(R.drawable.ic_mobile);
            Toast.makeText(this, "Current Mode: Mobile Data", Toast.LENGTH_SHORT).show();
        }
    }
}
