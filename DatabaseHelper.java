package com.example.lab8_q1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "AppDB";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Example table (you can add more here)
        db.execSQL("CREATE TABLE tasks (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "task_name TEXT, " +
                "due_date TEXT, " +
                "priority TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tasks");
        onCreate(db);
    }

    // 🔥 GENERIC INSERT
    public long insert(String tableName, ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.insert(tableName, null, values);
    }

    // 🔥 GENERIC GET ALL
    public List<HashMap<String, String>> getAll(String tableName) {
        List<HashMap<String, String>> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + tableName, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> row = new HashMap<>();

                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    row.put(cursor.getColumnName(i), cursor.getString(i));
                }

                list.add(row);

            } while (cursor.moveToNext());
        }

        cursor.close();
        return list;
    }

    // 🔥 GENERIC UPDATE
    public int update(String tableName, ContentValues values, String whereClause, String[] whereArgs) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.update(tableName, values, whereClause, whereArgs);
    }

    // 🔥 GENERIC DELETE
    public int delete(String tableName, String whereClause, String[] whereArgs) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(tableName, whereClause, whereArgs);
    }
}

/*
1. Initialize DB
DatabaseHelper dbHelper;
List<HashMap<String, String>> taskList;
ArrayAdapter<String> adapter;
ArrayList<String> displayList;
 2. Inside onCreate()
dbHelper = new DatabaseHelper(this);

displayList = new ArrayList<>();
taskList = new ArrayList<>();

loadTasks();
 3. Load data from DB → ListView
private void loadTasks() {

    taskList = dbHelper.getAll("tasks");
    displayList.clear();

    for (HashMap<String, String> task : taskList) {

        String name = task.get("task_name");
        String date = task.get("due_date");
        String priority = task.get("priority");

        displayList.add(name + " | " + date + " | " + priority);
    }

    adapter = new ArrayAdapter<>(
            this,
            android.R.layout.simple_list_item_1,
            displayList
    );

    listView.setAdapter(adapter);
}
 4. Insert Task
private void saveTask() {

    ContentValues values = new ContentValues();

    values.put("task_name", etTaskName.getText().toString());
    values.put("due_date", etDueDate.getText().toString());
    values.put("priority", etPriority.getText().toString());

    dbHelper.insert("tasks", values);

    loadTasks(); // refresh list
}
 5. Update Task
private void updateTask(int id) {

    ContentValues values = new ContentValues();

    values.put("task_name", etTaskName.getText().toString());
    values.put("due_date", etDueDate.getText().toString());
    values.put("priority", etPriority.getText().toString());

    dbHelper.update(
            "tasks",
            values,
            "id=?",
            new String[]{String.valueOf(id)}
    );

    loadTasks();
}
 6. Delete Task
private void deleteTask(int id) {

    dbHelper.delete(
            "tasks",
            "id=?",
            new String[]{String.valueOf(id)}
    );

    loadTasks();
}
 7. Handle List Click (VERY IMPORTANT)
listView.setOnItemClickListener((parent, view, position, id) -> {

    HashMap<String, String> task = taskList.get(position);

    int taskId = Integer.parseInt(task.get("id"));

    String name = task.get("task_name");
    String date = task.get("due_date");
    String priority = task.get("priority");

    // Fill fields for editing
    etTaskName.setText(name);
    etDueDate.setText(date);
    etPriority.setText(priority);

    // Example: delete directly
    deleteTask(taskId);
}); */