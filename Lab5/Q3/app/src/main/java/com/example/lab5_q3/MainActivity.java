package com.example.lab5_q3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    Spinner spinnerMovie, spinnerTheatre;
    DatePicker datePickerShow;
    TimePicker timePickerShow;
    ToggleButton toggleTicketType;
    Button btnBookNow, btnReset;

    String[] movies = {"Select Movie", "Interstellar", "Inception", "Avengers", "KGF", "RRR"};
    String[] theatres = {"Select Theatre", "PVR Cinemas", "INOX", "Cinepolis", "Miraj Cinemas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerMovie = findViewById(R.id.spinnerMovie);
        spinnerTheatre = findViewById(R.id.spinnerTheatre);
        datePickerShow = findViewById(R.id.datePickerShow);
        timePickerShow = findViewById(R.id.timePickerShow);
        toggleTicketType = findViewById(R.id.toggleTicketType);
        btnBookNow = findViewById(R.id.btnBookNow);
        btnReset = findViewById(R.id.btnReset);

        ArrayAdapter<String> movieAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                movies
        );
        movieAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMovie.setAdapter(movieAdapter);

        ArrayAdapter<String> theatreAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                theatres
        );
        theatreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTheatre.setAdapter(theatreAdapter);

        setCurrentDateAndTime();

        toggleTicketType.setOnCheckedChangeListener((buttonView, isChecked) -> {
            checkPremiumBookingRule();
        });

        timePickerShow.setOnTimeChangedListener((view, hourOfDay, minute) -> {
            checkPremiumBookingRule();
        });

        btnBookNow.setOnClickListener(view -> {
            String movie = spinnerMovie.getSelectedItem().toString();
            String theatre = spinnerTheatre.getSelectedItem().toString();

            int day = datePickerShow.getDayOfMonth();
            int month = datePickerShow.getMonth() + 1;
            int year = datePickerShow.getYear();

            int hour, minute;
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                hour = timePickerShow.getHour();
                minute = timePickerShow.getMinute();
            } else {
                hour = timePickerShow.getCurrentHour();
                minute = timePickerShow.getCurrentMinute();
            }

            String date = day + "/" + month + "/" + year;
            String time = String.format("%02d:%02d", hour, minute);
            String ticketType = toggleTicketType.isChecked() ? "Premium" : "Standard";

            if (!validateInputs(movie, theatre)) {
                return;
            }

            if (ticketType.equals("Premium") && !isAfterNoon()) {
                Toast.makeText(MainActivity.this,
                        "Premium tickets can be booked only for shows after 12:00 PM",
                        Toast.LENGTH_SHORT).show();
                btnBookNow.setEnabled(false);
                return;
            }

            int availableSeats = getAvailableSeats(movie, theatre, time);

            Intent intent = new Intent(MainActivity.this, BookingSummaryActivity.class);
            intent.putExtra("movie", movie);
            intent.putExtra("theatre", theatre);
            intent.putExtra("date", date);
            intent.putExtra("time", time);
            intent.putExtra("ticketType", ticketType);
            intent.putExtra("availableSeats", availableSeats);
            startActivity(intent);
        });

        btnReset.setOnClickListener(view -> resetForm());
    }

    private boolean validateInputs(String movie, String theatre) {
        if (movie.equals("Select Movie")) {
            Toast.makeText(this, "Please select a movie", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (theatre.equals("Select Theatre")) {
            Toast.makeText(this, "Please select a theatre", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void checkPremiumBookingRule() {
        if (toggleTicketType.isChecked()) {
            if (isAfterNoon()) {
                btnBookNow.setEnabled(true);
            } else {
                btnBookNow.setEnabled(false);
                Toast.makeText(this,
                        "Premium booking enabled only for shows after 12:00 PM",
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            btnBookNow.setEnabled(true);
        }
    }

    private boolean isAfterNoon() {
        int hour;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            hour = timePickerShow.getHour();
        } else {
            hour = timePickerShow.getCurrentHour();
        }
        return hour >= 12;
    }

    private int getAvailableSeats(String movie, String theatre, String time) {
        int value = Math.abs((movie + theatre + time).hashCode());
        return (value % 50) + 1;
    }

    private void setCurrentDateAndTime() {
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        datePickerShow.updateDate(year, month, day);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        if (android.os.Build.VERSION.SDK_INT >= 23) {
            timePickerShow.setHour(hour);
            timePickerShow.setMinute(minute);
        } else {
            timePickerShow.setCurrentHour(hour);
            timePickerShow.setCurrentMinute(minute);
        }

        checkPremiumBookingRule();
    }

    private void resetForm() {
        spinnerMovie.setSelection(0);
        spinnerTheatre.setSelection(0);
        toggleTicketType.setChecked(false);
        setCurrentDateAndTime();

        Toast.makeText(this, "All fields reset", Toast.LENGTH_SHORT).show();
    }
}
