package com.example.lab5_q2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookingDetailsActivity extends AppCompatActivity {
    TextView tvSource, tvDestination, tvDate, tvTripType;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);

        tvSource = findViewById(R.id.tvSource);
        tvDestination = findViewById(R.id.tvDestination);
        tvDate = findViewById(R.id.tvDate);
        tvTripType = findViewById(R.id.tvTripType);
        btnBack = findViewById(R.id.btnBack);

        String source = getIntent().getStringExtra("source");
        String destination = getIntent().getStringExtra("destination");
        String date = getIntent().getStringExtra("date");
        String tripType = getIntent().getStringExtra("tripType");

        tvSource.setText("Source: " + source);
        tvDestination.setText("Destination: " + destination);
        tvDate.setText("Travel Date: " + date);
        tvTripType.setText("Ticket Type: " + tripType);

        btnBack.setOnClickListener(view -> finish());
    }
}
