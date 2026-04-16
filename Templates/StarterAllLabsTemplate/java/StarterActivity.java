package com.example.startertemplate;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Starter activity for lab questions.
 * Keep only the widgets required by a specific question.
 */
public class StarterActivity extends AppCompatActivity {

    private static final String EXTRA_MESSAGE = "extra_message";

    private TextView textViewPrimary;
    private TextView textViewSecondary;
    private EditText editTextInput;
    private Button buttonActionPrimary;
    private ImageView imageViewPreview;
    private CheckBox checkBoxOption;
    private RadioGroup radioGroupOptions;
    private RadioButton radioButtonOption1;
    private RadioButton radioButtonOption2;
    private Switch switchState;
    private SeekBar seekBarValue;
    private Spinner spinnerOptions;
    private ListView listViewItems;
    private GridView gridViewItems;
    private TableLayout tableLayoutData;
    private DatePicker datePickerInput;
    private TimePicker timePickerInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter_all_labs);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        bindViews();
        setupSpinner();
        setupListView();
        setupButtonAction();
    }

    private void bindViews() {
        textViewPrimary = findViewById(R.id.textViewPrimary);
        textViewSecondary = findViewById(R.id.textViewSecondary);
        editTextInput = findViewById(R.id.editTextInput);
        buttonActionPrimary = findViewById(R.id.buttonActionPrimary);
        imageViewPreview = findViewById(R.id.imageViewPreview);
        checkBoxOption = findViewById(R.id.checkBoxOption);
        radioGroupOptions = findViewById(R.id.radioGroupOptions);
        radioButtonOption1 = findViewById(R.id.radioButtonOption1);
        radioButtonOption2 = findViewById(R.id.radioButtonOption2);
        switchState = findViewById(R.id.switchState);
        seekBarValue = findViewById(R.id.seekBarValue);
        spinnerOptions = findViewById(R.id.spinnerOptions);
        listViewItems = findViewById(R.id.listViewItems);
        gridViewItems = findViewById(R.id.gridViewItems);
        tableLayoutData = findViewById(R.id.tableLayoutData);
        datePickerInput = findViewById(R.id.datePickerInput);
        timePickerInput = findViewById(R.id.timePickerInput);
    }

    private void setupSpinner() {
        ArrayList<String> options = new ArrayList<>();
        options.add("Option A");
        options.add("Option B");
        options.add("Option C");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                options
        );
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptions.setAdapter(spinnerAdapter);
    }

    private void setupListView() {
        ArrayList<String> rows = new ArrayList<>();
        rows.add("Row 1");
        rows.add("Row 2");
        rows.add("Row 3");

        StarterStringAdapter adapter = new StarterStringAdapter(this, rows);
        listViewItems.setAdapter(adapter);
    }

    private void setupButtonAction() {
        buttonActionPrimary.setOnClickListener(v -> {
            StarterFormData formData = new StarterFormData(
                    editTextInput.getText().toString().trim(),
                    checkBoxOption.isChecked(),
                    getSelectedRadioText(),
                    switchState.isChecked(),
                    seekBarValue.getProgress(),
                    spinnerOptions.getSelectedItem() != null ? spinnerOptions.getSelectedItem().toString() : ""
            );

            textViewSecondary.setText(formData.toDisplayText());
            Toast.makeText(this, "Action completed", Toast.LENGTH_SHORT).show();
        });
    }

    private void clearFields() {
        editTextInput.setText("");
        textViewSecondary.setText("");
        checkBoxOption.setChecked(false);
        radioGroupOptions.clearCheck();
        switchState.setChecked(false);
        seekBarValue.setProgress(0);
        spinnerOptions.setSelection(0);
    }

    private void openNextScreen() {
        Intent intent = new Intent(this, StarterDetailActivity.class);
        intent.putExtra(EXTRA_MESSAGE, editTextInput.getText().toString().trim());
        startActivity(intent);
    }

    private String getSelectedRadioText() {
        int selectedId = radioGroupOptions.getCheckedRadioButtonId();
        if (selectedId == R.id.radioButtonOption1) {
            return radioButtonOption1.getText().toString();
        }
        if (selectedId == R.id.radioButtonOption2) {
            return radioButtonOption2.getText().toString();
        }
        return "None";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_starter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        if (item.getItemId() == R.id.menuActionPrimary) {
            openNextScreen();
            return true;
        }
        if (item.getItemId() == R.id.menuActionSecondary) {
            clearFields();
            Toast.makeText(this, "Fields cleared", Toast.LENGTH_SHORT).show();
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
