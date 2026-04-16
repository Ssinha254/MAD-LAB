package com.example.template;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Usage:
 * Open this from PreviewActivity on item click and pass data using intent extras.
 * Needs activity_detail.xml with textViewPrimary and textViewSecondary.
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView title = findViewById(R.id.textViewPrimary);
        TextView subtitle = findViewById(R.id.textViewSecondary);

        String receivedTitle = getIntent().getStringExtra(Constants.EXTRA_TITLE);
        String receivedSubtitle = getIntent().getStringExtra(Constants.EXTRA_SUBTITLE);

        title.setText(receivedTitle != null ? receivedTitle : "No title");
        subtitle.setText(receivedSubtitle != null ? receivedSubtitle : "No subtitle");
    }
}
