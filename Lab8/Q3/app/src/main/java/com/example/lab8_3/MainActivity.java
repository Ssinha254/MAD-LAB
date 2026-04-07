package com.example.lab8_3;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etMovieName, etYear;
    SeekBar seekBarRating;
    TextView tvRatingLabel;
    Button btnSave;
    ListView listViewMovies;
    TableLayout tableLayoutDetails;

    DatabaseHelper dbHelper;

    ArrayList<String> movieNames;
    ArrayList<Integer> movieIds;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMovieName = findViewById(R.id.etMovieName);
        etYear = findViewById(R.id.etYear);
        seekBarRating = findViewById(R.id.seekBarRating);
        tvRatingLabel = findViewById(R.id.tvRatingLabel);
        btnSave = findViewById(R.id.btnSave);
        listViewMovies = findViewById(R.id.listViewMovies);
        tableLayoutDetails = findViewById(R.id.tableLayoutDetails);

        dbHelper = new DatabaseHelper(this);

        loadMovieNames();

        seekBarRating.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress < 1) {
                    seekBar.setProgress(1);
                    tvRatingLabel.setText("Rating: 1");
                } else {
                    tvRatingLabel.setText("Rating: " + progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveMovieReview();
            }
        });

        listViewMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int movieId = movieIds.get(position);
                showMovieDetails(movieId);
            }
        });
    }

    private void saveMovieReview() {
        String movieName = etMovieName.getText().toString().trim();
        String year = etYear.getText().toString().trim();
        int rating = seekBarRating.getProgress();

        if (TextUtils.isEmpty(movieName)) {
            etMovieName.setError("Enter movie name");
            return;
        }

        if (TextUtils.isEmpty(year)) {
            etYear.setError("Enter year");
            return;
        }

        if (rating < 1 || rating > 5) {
            Toast.makeText(this, "Give points between 1 and 5", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean inserted = dbHelper.insertMovie(movieName, year, rating);

        if (inserted) {
            Toast.makeText(this, "Movie review saved", Toast.LENGTH_SHORT).show();
            etMovieName.setText("");
            etYear.setText("");
            seekBarRating.setProgress(1);
            tvRatingLabel.setText("Rating: 1");
            loadMovieNames();
            clearTable();
        } else {
            Toast.makeText(this, "Failed to save review", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadMovieNames() {
        movieNames = new ArrayList<>();
        movieIds = new ArrayList<>();

        Cursor cursor = dbHelper.getAllMovies();

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("movie_name"));

                movieIds.add(id);
                movieNames.add(name);
            } while (cursor.moveToNext());
        }

        cursor.close();

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                movieNames
        );
        listViewMovies.setAdapter(adapter);
    }

    private void showMovieDetails(int movieId) {
        Cursor cursor = dbHelper.getMovieById(movieId);

        if (cursor.moveToFirst()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow("movie_name"));
            String year = cursor.getString(cursor.getColumnIndexOrThrow("movie_year"));
            int rating = cursor.getInt(cursor.getColumnIndexOrThrow("movie_rating"));

            clearTable();

            addTableRow("Movie Name", name);
            addTableRow("Year", year);
            addTableRow("Points", String.valueOf(rating));
        }

        cursor.close();
    }

    private void clearTable() {
        tableLayoutDetails.removeAllViews();
    }

    private void addTableRow(String key, String value) {
        TableRow row = new TableRow(this);

        TextView tvKey = new TextView(this);
        TextView tvValue = new TextView(this);

        tvKey.setText(key);
        tvKey.setPadding(20, 20, 20, 20);
        tvKey.setTextSize(18);

        tvValue.setText(value);
        tvValue.setPadding(20, 20, 20, 20);
        tvValue.setTextSize(18);

        row.addView(tvKey);
        row.addView(tvValue);

        tableLayoutDetails.addView(row);
    }
}