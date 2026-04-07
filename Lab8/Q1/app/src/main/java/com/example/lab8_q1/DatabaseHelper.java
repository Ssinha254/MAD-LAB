package com.example.lab8_q1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TaskManagerDB";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_TASKS = "tasks";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TASK_NAME = "task_name";
    public static final String COLUMN_DUE_DATE = "due_date";
    public static final String COLUMN_PRIORITY = "priority";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_TASKS + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_TASK_NAME + " TEXT, "
                + COLUMN_DUE_DATE + " TEXT, "
                + COLUMN_PRIORITY + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);
        onCreate(db);
    }

    // Accepting a HashMap to insert task
    public boolean insertTask(Map<String, String> taskData) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_TASK_NAME, taskData.get(COLUMN_TASK_NAME));
        values.put(COLUMN_DUE_DATE, taskData.get(COLUMN_DUE_DATE));
        values.put(COLUMN_PRIORITY, taskData.get(COLUMN_PRIORITY));

        long result = db.insert(TABLE_TASKS, null, values);
        return result != -1;
    }

    // Returning a List of HashMaps instead of Task models
    public List<HashMap<String, String>> getAllTasks() {
        List<HashMap<String, String>> taskList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_TASKS, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> task = new HashMap<>();
                task.put(COLUMN_ID, String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))));
                task.put(COLUMN_TASK_NAME, cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TASK_NAME)));
                task.put(COLUMN_DUE_DATE, cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DUE_DATE)));
                task.put(COLUMN_PRIORITY, cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PRIORITY)));
                
                taskList.add(task);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return taskList;
    }

    // Accepting a HashMap to update task
    public boolean updateTask(Map<String, String> taskData) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_TASK_NAME, taskData.get(COLUMN_TASK_NAME));
        values.put(COLUMN_DUE_DATE, taskData.get(COLUMN_DUE_DATE));
        values.put(COLUMN_PRIORITY, taskData.get(COLUMN_PRIORITY));

        String id = taskData.get(COLUMN_ID);
        int result = db.update(TABLE_TASKS, values, COLUMN_ID + "=?", new String[]{id});
        return result > 0;
    }

    public boolean deleteTask(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_TASKS, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
        return result > 0;
    }
}
