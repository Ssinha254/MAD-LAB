package com.example.lab5_q3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookingSummaryActivity extends AppCompatActivity {
    TextView tvMovie, tvTheatre, tvDate, tvTime, tvTicketType, tvAvailableSeats;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_summary);

        tvMovie = findViewById(R.id.tvMovie);
        tvTheatre = findViewById(R.id.tvTheatre);
        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);
        tvTicketType = findViewById(R.id.tvTicketType);
        tvAvailableSeats = findViewById(R.id.tvAvailableSeats);
        btnBack = findViewById(R.id.btnBack);

        String movie = getIntent().getStringExtra("movie");
        String theatre = getIntent().getStringExtra("theatre");
        String date = getIntent().getStringExtra("date");
        String time = getIntent().getStringExtra("time");
        String ticketType = getIntent().getStringExtra("ticketType");
        int availableSeats = getIntent().getIntExtra("availableSeats", 0);

        tvMovie.setText("Movie            : " + movie);
        tvTheatre.setText("Theatre          : " + theatre);
        tvDate.setText("Show Date        : " + date);
        tvTime.setText("Show Time        : " + time);
        tvTicketType.setText("Ticket Type      : " + ticketType);
        tvAvailableSeats.setText("Available Seats : " + availableSeats);

        btnBack.setOnClickListener(v -> finish());
    }
}
