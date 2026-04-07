package com.example.lab8_q5;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail;

    SharedPreferences sharedPreferences;
    public static final String PREF_NAME = "MyPrefs";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);

        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        // Load saved data when app opens
        loadData();
    }

    private void loadData() {
        String name = sharedPreferences.getString(KEY_NAME, "");
        String email = sharedPreferences.getString(KEY_EMAIL, "");

        etName.setText(name);
        etEmail.setText(email);
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();   // Save when app is closed/minimized
    }

    private void saveData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_NAME, etName.getText().toString());
        editor.putString(KEY_EMAIL, etEmail.getText().toString());

        editor.apply(); // or commit()
    }
}