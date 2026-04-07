package com.example.lab7_q3;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvContent;
    private final String originalText = "Digital transformation is the process of using digital technologies to create new or modify existing business processes, culture, and customer experiences to meet changing business and market requirements. This reimagining of business in the digital age is digital transformation. It transcends traditional roles like sales, marketing, and customer service. Instead, digital transformation begins and ends with how you think about, and engage with, customers. As we move from paper to spreadsheets to smart applications for managing our business, we have the chance to reimagine how we do business how we engage our customers with digital technology on our side.";
    private String currentSearchKeyword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvContent = findViewById(R.id.tvContent);
        tvContent.setText(originalText);
        tvContent.setTextIsSelectable(true);

        // Setting custom CAB for text selection
        tvContent.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                getMenuInflater().inflate(R.menu.menu_cab, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.cab_highlight_selected) {
                    int start = tvContent.getSelectionStart();
                    int end = tvContent.getSelectionEnd();
                    if (start != -1 && end != -1 && start != end) {
                        highlightSelection(start, end);
                    }
                    mode.finish();
                    return true;
                } else if (id == R.id.cab_clear_highlight) {
                    tvContent.setText(tvContent.getText().toString()); // Simple way to clear spans
                    mode.finish();
                    return true;
                }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
            }
        });
    }

    private void highlightSelection(int start, int end) {
        SpannableString spannableString = new SpannableString(tvContent.getText());
        spannableString.setSpan(new BackgroundColorSpan(Color.YELLOW), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvContent.setText(spannableString);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_search) {
            showInputDialog("Search Keywords", (input) -> {
                currentSearchKeyword = input;
                if (originalText.toLowerCase().contains(input.toLowerCase())) {
                    Toast.makeText(this, "Found: " + input, Toast.LENGTH_SHORT).show();
                    highlightText(input, Color.YELLOW);
                } else {
                    Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
                }
            });
            return true;
        } else if (id == R.id.menu_highlight) {
            showInputDialog("Highlight Phrase", (input) -> highlightText(input, Color.CYAN));
            return true;
        } else if (id == R.id.menu_sort_alpha) {
            sortAlphabetically();
            return true;
        } else if (id == R.id.menu_sort_relevance) {
            sortByRelevance();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showInputDialog(String title, InputCallback callback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        final EditText input = new EditText(this);
        builder.setView(input);
        builder.setPositiveButton("OK", (dialog, which) -> callback.onInput(input.getText().toString().trim()));
        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
        builder.show();
    }

    private void highlightText(String phrase, int color) {
        if (phrase.isEmpty()) {
            tvContent.setText(originalText);
            return;
        }
        SpannableString spannableString = new SpannableString(tvContent.getText());
        String text = tvContent.getText().toString().toLowerCase();
        String search = phrase.toLowerCase();
        int index = text.indexOf(search);
        while (index >= 0) {
            spannableString.setSpan(new BackgroundColorSpan(color), index, index + phrase.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            index = text.indexOf(search, index + phrase.length());
        }
        tvContent.setText(spannableString);
    }

    private void sortAlphabetically() {
        String[] sentences = tvContent.getText().toString().split("\\. ");
        List<String> list = Arrays.asList(sentences);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s.trim());
            if (!s.endsWith(".")) sb.append(".");
            sb.append(" ");
        }
        tvContent.setText(sb.toString().trim());
    }

    private void sortByRelevance() {
        if (currentSearchKeyword.isEmpty()) {
            Toast.makeText(this, "Please search for keywords first", Toast.LENGTH_SHORT).show();
            return;
        }
        String[] sentences = tvContent.getText().toString().split("\\. ");
        List<String> list = new ArrayList<>(Arrays.asList(sentences));
        
        String keyword = currentSearchKeyword.toLowerCase();
        Collections.sort(list, (s1, s2) -> {
            int count1 = countOccurrences(s1.toLowerCase(), keyword);
            int count2 = countOccurrences(s2.toLowerCase(), keyword);
            return Integer.compare(count2, count1);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s.trim());
            if (!s.endsWith(".")) sb.append(".");
            sb.append(" ");
        }
        tvContent.setText(sb.toString().trim());
    }

    private int countOccurrences(String text, String keyword) {
        int count = 0;
        int index = text.indexOf(keyword);
        while (index != -1) {
            count++;
            index = text.indexOf(keyword, index + keyword.length());
        }
        return count;
    }

    interface InputCallback {
        void onInput(String input);
    }
}