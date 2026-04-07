package com.example.lab5_q2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Calendar; //Add on ur own


public class MainActivity extends AppCompatActivity {
    Spinner spinnerSource, spinnerDestination;
    DatePicker datePickerTravel;
    ToggleButton toggleTripType;
    Button btnSubmit, btnReset;

    ArrayList<PlaceModel> placeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerSource = findViewById(R.id.spinnerSource);
        spinnerDestination = findViewById(R.id.spinnerDestination);
        datePickerTravel = findViewById(R.id.datePickerTravel);
        toggleTripType = findViewById(R.id.toggleTripType);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnReset = findViewById(R.id.btnReset);

        placeList = new ArrayList<>();
        placeList.add(new PlaceModel("Select City", R.drawable.delhi));
        placeList.add(new PlaceModel("Delhi", R.drawable.delhi));
        placeList.add(new PlaceModel("Mumbai", R.drawable.mumbai));


        PlaceAdapter adapter = new PlaceAdapter(this, placeList);
        spinnerSource.setAdapter(adapter);
        spinnerDestination.setAdapter(adapter);

        btnSubmit.setOnClickListener(view -> {
            String source = ((PlaceModel) spinnerSource.getSelectedItem()).getPlaceName();
            String destination = ((PlaceModel) spinnerDestination.getSelectedItem()).getPlaceName();

            int day = datePickerTravel.getDayOfMonth();
            int month = datePickerTravel.getMonth() + 1;
            int year = datePickerTravel.getYear();

            String date = day + "/" + month + "/" + year;
            String tripType = toggleTripType.isChecked() ? "Round Trip" : "One Way";

            if (source.equals("Select City")) {
                Toast.makeText(MainActivity.this, "Please select source", Toast.LENGTH_SHORT).show();
                return;
            }

            if (destination.equals("Select City")) {
                Toast.makeText(MainActivity.this, "Please select destination", Toast.LENGTH_SHORT).show();
                return;
            }

            if (source.equals(destination)) {
                Toast.makeText(MainActivity.this, "Source and destination cannot be same", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(MainActivity.this, BookingDetailsActivity.class);
            intent.putExtra("source", source);
            intent.putExtra("destination", destination);
            intent.putExtra("date", date);
            intent.putExtra("tripType", tripType);
            startActivity(intent);
        });

        btnReset.setOnClickListener(view -> resetForm());
    }

    private void resetForm() {
        spinnerSource.setSelection(0);
        spinnerDestination.setSelection(0);
        toggleTripType.setChecked(false);

        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        datePickerTravel.updateDate(currentYear, currentMonth, currentDay);

        Toast.makeText(this, "Form Reset Successfully", Toast.LENGTH_SHORT).show();
    }
}