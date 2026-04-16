package com.example.practice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // 🔹 DATABASE INFO
    public static final String DATABASE_NAME = "AppDB";
    public static final int DATABASE_VERSION = 1;

    // 🔹 TABLE
    public static final String TABLE_NAME = "patients";

    // 🔹 COLUMNS
    public static final String COL_ID = "id";
    public static final String COL_NAME = "patient_name";
    public static final String COL_DOCTOR = "doctor";
    public static final String COL_DATE = "date";
    public static final String COL_TIME = "time";
    public static final String COL_STATUS = "status";

    // 🔹 CONSTRUCTOR
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // 🔹 CREATE TABLE
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " TEXT, " +
                COL_DOCTOR + " TEXT, " +
                COL_DATE + " TEXT, " +
                COL_TIME + " TEXT," +
                COL_STATUS + " TEXT" +
                ")";
        db.execSQL(CREATE_TABLE);
    }

    // 🔹 UPGRADE
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // =====================================================
    //  GENERIC CORE FUNCTIONS
    // =====================================================

    public long insert(String tableName, ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.insert(tableName, null, values);
    }

    public int update(String tableName, ContentValues values, String whereClause, String[] whereArgs) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.update(tableName, values, whereClause, whereArgs);
    }

    public int delete(String tableName, String whereClause, String[] whereArgs) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(tableName, whereClause, whereArgs);
    }

    //  UNIVERSAL QUERY FUNCTION
    public List<HashMap<String, String>> getFiltered(String query, String[] args) {

        List<HashMap<String, String>> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.rawQuery(query, args);

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    HashMap<String, String> row = new HashMap<>();

                    for (int i = 0; i < cursor.getColumnCount(); i++) {
                        String columnName = cursor.getColumnName(i);

                        if (cursor.isNull(i)) {
                            row.put(columnName, null);
                        } else {
                            row.put(columnName, cursor.getString(i));
                        }
                    }
                    //getInt(i), getFloat(i) etc. can be used based on expected datatype

                    list.add(row);

                } while (cursor.moveToNext());
            }

        } finally {
            if (cursor != null) cursor.close();
        }

        return list;
    }

    // =====================================================
    //  WRAPPER FUNCTIONS (EASY USE)
    // =====================================================

    //  Insert using HashMap
    public long insertRow(String tableName, HashMap<String, String> data) {

        ContentValues values = new ContentValues();

        for (String key : data.keySet()) {
            values.put(key, data.get(key));
        }

        return insert(tableName, values);
    }

    //  Update using HashMap
    public int updateRow(String tableName,
                         HashMap<String, String> data,
                         String whereClause,
                         String[] whereArgs) {

        ContentValues values = new ContentValues();

        for (String key : data.keySet()) {
            values.put(key, data.get(key));
        }

        return update(tableName, values, whereClause, whereArgs);
    }
}


    // =====================================================
    //  OPTIONAL: TASK-SPECIFIC WRAPPER
    // =====================================================

