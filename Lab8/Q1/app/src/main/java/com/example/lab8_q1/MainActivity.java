package com.example.lab8_q1;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText etTaskName, etDueDate;
    Spinner spinnerPriority;
    Button btnSave;
    ListView listViewTasks;

    DatabaseHelper databaseHelper;
    ArrayList<String> taskDisplayList;
    ArrayAdapter<String> adapter;
    List<HashMap<String, String>> taskList;

    int selectedTaskId = -1; // for update mode

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTaskName = findViewById(R.id.etTaskName);
        etDueDate = findViewById(R.id.etDueDate);
        spinnerPriority = findViewById(R.id.spinnerPriority);
        btnSave = findViewById(R.id.btnSave);
        listViewTasks = findViewById(R.id.listViewTasks);

        databaseHelper = new DatabaseHelper(this);

        String[] priorities = {"High", "Medium", "Low"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                priorities
        );
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPriority.setAdapter(spinnerAdapter);

        etDueDate.setFocusable(false);
        etDueDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveOrUpdateTask();
            }
        });

        listViewTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showOptionsDialog(position);
            }
        });

        loadTasks();
    }

    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                MainActivity.this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    String date = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                    etDueDate.setText(date);
                },
                year, month, day
        );
        datePickerDialog.show();
    }

    private void saveOrUpdateTask() {
        String taskName = etTaskName.getText().toString().trim();
        String dueDate = etDueDate.getText().toString().trim();
        String priority = spinnerPriority.getSelectedItem().toString();

        if (TextUtils.isEmpty(taskName)) {
            etTaskName.setError("Enter task name");
            return;
        }

        if (TextUtils.isEmpty(dueDate)) {
            etDueDate.setError("Select due date");
            return;
        }

        // Create HashMap to store task data
        HashMap<String, String> taskData = new HashMap<>();
        taskData.put(DatabaseHelper.COLUMN_TASK_NAME, taskName);
        taskData.put(DatabaseHelper.COLUMN_DUE_DATE, dueDate);
        taskData.put(DatabaseHelper.COLUMN_PRIORITY, priority);

        new Thread(() -> {
            boolean success;
            String message;
            if (selectedTaskId == -1) {
                success = databaseHelper.insertTask(taskData);
                message = success ? "Task saved successfully" : "Failed to save task";
            } else {
                taskData.put(DatabaseHelper.COLUMN_ID, String.valueOf(selectedTaskId));
                success = databaseHelper.updateTask(taskData);
                message = success ? "Task updated successfully" : "Failed to update task";
            }

            runOnUiThread(() -> {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                if (success) {
                    if (selectedTaskId != -1) {
                        btnSave.setText("Save Task");
                        selectedTaskId = -1;
                    }
                    clearFields();
                    loadTasks();
                }
            });
        }).start();
    }

    private void loadTasks() {
        new Thread(() -> {
            taskList = databaseHelper.getAllTasks();
            taskDisplayList = new ArrayList<>();

            for (HashMap<String, String> task : taskList) {
                String item = "Task: " + task.get(DatabaseHelper.COLUMN_TASK_NAME) +
                        "\nDue Date: " + task.get(DatabaseHelper.COLUMN_DUE_DATE) +
                        "\nPriority: " + task.get(DatabaseHelper.COLUMN_PRIORITY);
                taskDisplayList.add(item);
            }

            runOnUiThread(() -> {
                adapter = new ArrayAdapter<>(
                        MainActivity.this,
                        android.R.layout.simple_list_item_1,
                        taskDisplayList
                );
                listViewTasks.setAdapter(adapter);
            });
        }).start();
    }

    private void showOptionsDialog(int position) {
        HashMap<String, String> selectedTask = taskList.get(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Option");
        builder.setItems(new CharSequence[]{"Edit", "Delete"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (which == 0) {
                    editTask(selectedTask);
                } else if (which == 1) {
                    int id = Integer.parseInt(selectedTask.get(DatabaseHelper.COLUMN_ID));
                    deleteTask(id);
                }
            }
        });
        builder.show();
    }

    private void editTask(HashMap<String, String> task) {
        etTaskName.setText(task.get(DatabaseHelper.COLUMN_TASK_NAME));
        etDueDate.setText(task.get(DatabaseHelper.COLUMN_DUE_DATE));

        String priority = task.get(DatabaseHelper.COLUMN_PRIORITY);
        if ("High".equals(priority)) {
            spinnerPriority.setSelection(0);
        } else if ("Medium".equals(priority)) {
            spinnerPriority.setSelection(1);
        } else {
            spinnerPriority.setSelection(2);
        }

        selectedTaskId = Integer.parseInt(task.get(DatabaseHelper.COLUMN_ID));
        btnSave.setText("Update Task");
    }

    private void deleteTask(int id) {
        new Thread(() -> {
            boolean deleted = databaseHelper.deleteTask(id);
            runOnUiThread(() -> {
                if (deleted) {
                    Toast.makeText(MainActivity.this, "Task deleted", Toast.LENGTH_SHORT).show();
                    loadTasks();
                } else {
                    Toast.makeText(MainActivity.this, "Failed to delete task", Toast.LENGTH_SHORT).show();
                }
            });
        }).start();
    }

    private void clearFields() {
        etTaskName.setText("");
        etDueDate.setText("");
        spinnerPriority.setSelection(0);
    }
}
