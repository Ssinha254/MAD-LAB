package com.example.startertemplate;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Simple target screen used for intent navigation starter flow.
 */
public class StarterDetailActivity extends AppCompatActivity {

    private static final String EXTRA_MESSAGE = "extra_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView title = findViewById(R.id.textViewPrimary);
        TextView subtitle = findViewById(R.id.textViewSecondary);

        String received = getIntent().getStringExtra(EXTRA_MESSAGE);
        title.setText("Intent Target Screen");
        subtitle.setText(received == null || received.isEmpty() ? "No input passed" : "Received: " + received);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
