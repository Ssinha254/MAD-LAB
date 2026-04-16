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

    // 🔹 DATABASE INFO
    public static final String DATABASE_NAME = "AppDB";
    public static final int DATABASE_VERSION = 1;

    // 🔹 TABLE
    public static final String TABLE_TASKS = "tasks";

    // 🔹 COLUMNS
    public static final String COL_ID = "id";
    public static final String COL_NAME = "task_name";
    public static final String COL_DATE = "due_date";
    public static final String COL_PRIORITY = "priority";

    // 🔹 CONSTRUCTOR
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // 🔹 CREATE TABLE
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_TASKS + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " TEXT, " +
                COL_DATE + " TEXT, " +
                COL_PRIORITY + " TEXT" +
                ")";
        db.execSQL(CREATE_TABLE);
    }

    // 🔹 UPGRADE
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);
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

    // =====================================================
    //  OPTIONAL: TASK-SPECIFIC WRAPPER
    // =====================================================

    public long insertTask(String name, String date, String priority) {
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_DATE, date);
        values.put(COL_PRIORITY, priority);

        return insert(TABLE_TASKS, values);
    }

    public int deleteTask(int id) {
        return delete(TABLE_TASKS, "id=?", new String[]{String.valueOf(id)});
    }
}

    // =====================================================
    //  USAGE EXAMPLES (IMPORTANT)
    // =====================================================

    /*
    // 🔹 1. Initialize
    DatabaseHelper dbHelper = new DatabaseHelper(this);

    // 🔹 2. Insert (simple)
    dbHelper.insertTask("Study", "Tomorrow", "High");

    // 🔹 3. Insert (generic HashMap)
    HashMap<String, String> map = new HashMap<>();
    map.put(COL_NAME, "Workout");
    map.put(COL_DATE, "Today");
    map.put(COL_PRIORITY, "Medium");

    dbHelper.insertRow(TABLE_TASKS, map);

    // 🔹 4. Get all
    List<HashMap<String, String>> list =
        dbHelper.getFiltered("SELECT * FROM " + TABLE_TASKS, null);

    // 🔹 5. Sorting
    List<HashMap<String, String>> result = dbHelper.getFiltered(
        "SELECT * FROM " + TABLE_TASKS + " ORDER BY " + COL_PRIORITY + " DESC",
        null
    );

    // 🔹 6. MAX
    List<HashMap<String, String>> result =
        dbHelper.getFiltered(
            "SELECT MAX(priority) as max_val FROM " + TABLE_TASKS,
            null
        );

    String max = result.get(0).get("max_val");

    // 🔹 7. COUNT
    String count = dbHelper.getFiltered(
        "SELECT COUNT(*) as total FROM " + TABLE_TASKS,
        null
    ).get(0).get("total");

    // 🔹 8. DELETE
    dbHelper.deleteTask(1);

    */


    
// =====================================================
////  MainActivity.java USAGE EXAMPLE 
// =====================================================

/*
// Class fields
private DatabaseHelper dbHelper;
private List<HashMap<String, String>> taskList;
private ArrayList<String> displayList;
private ArrayAdapter<String> adapter;
private ListView listView;

// EditTexts
private EditText etTaskName, etDueDate, etPriority;

private void initDbAndList() {
    dbHelper = new DatabaseHelper(this);

    taskList = new ArrayList<>();
    displayList = new ArrayList<>();

    loadTasks();

    listView.setOnItemClickListener((parent, view, position, id) -> {
        HashMap<String, String> task = taskList.get(position);

        int taskId = Integer.parseInt(task.get(DatabaseHelper.COL_ID));

        String name = task.get(DatabaseHelper.COL_NAME);
        String date = task.get(DatabaseHelper.COL_DATE);
        String priority = task.get(DatabaseHelper.COL_PRIORITY);

        // Fill fields for editing
        etTaskName.setText(name);
        etDueDate.setText(date);
        etPriority.setText(priority);

        // Example: delete directly
        // deleteTask(taskId);

        // OR update later:
        // updateTask(taskId);
    });
}

// Load data from DB -> ListView
private void loadTasks() {
    taskList = dbHelper.getFiltered(
            "SELECT * FROM " + DatabaseHelper.TABLE_TASKS,
            null
    );

    displayList.clear();

    for (HashMap<String, String> task : taskList) {
        String name = task.get(DatabaseHelper.COL_NAME);
        String date = task.get(DatabaseHelper.COL_DATE);
        String priority = task.get(DatabaseHelper.COL_PRIORITY);

        displayList.add(name + " | " + date + " | " + priority);
    }

    adapter = new ArrayAdapter<>(
            this,
            android.R.layout.simple_list_item_1,
            displayList
    );
    listView.setAdapter(adapter);
}

// Insert Task
private void saveTask() {
    ContentValues values = new ContentValues();
    values.put(DatabaseHelper.COL_NAME, etTaskName.getText().toString().trim());
    values.put(DatabaseHelper.COL_DATE, etDueDate.getText().toString().trim());
    values.put(DatabaseHelper.COL_PRIORITY, etPriority.getText().toString().trim());

    dbHelper.insert(DatabaseHelper.TABLE_TASKS, values);
    loadTasks();
}

// Update Task
private void updateTask(int id) {
    ContentValues values = new ContentValues();
    values.put(DatabaseHelper.COL_NAME, etTaskName.getText().toString().trim());
    values.put(DatabaseHelper.COL_DATE, etDueDate.getText().toString().trim());
    values.put(DatabaseHelper.COL_PRIORITY, etPriority.getText().toString().trim());

    dbHelper.update(
            DatabaseHelper.TABLE_TASKS,
            values,
            DatabaseHelper.COL_ID + "=?",
            new String[]{String.valueOf(id)}
    );

    loadTasks();
}

// Delete Task
private void deleteTask(int id) {
    dbHelper.delete(
            DatabaseHelper.TABLE_TASKS,
            DatabaseHelper.COL_ID + "=?",
            new String[]{String.valueOf(id)}
    );

    loadTasks();
}
 
//Handle List Click 
listView.setOnItemClickListener((parent, view, position, id) -> {

    HashMap<String, String> task = taskList.get(position);

    int taskId = Integer.parseInt(task.get("id"));
    // Create PopupMenu
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
            popupMenu.inflate(R.menu.menu_task_options);  // Create this menu XML

            popupMenu.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.menu_edit) {
                    // Navigate to EditTaskActivity
                    Intent intent = new Intent(MainActivity.this, EditTaskActivity.class);
                    intent.putExtra("taskId", taskId);
                    startActivity(intent);
                    return true;

                } else if (item.getItemId() == R.id.menu_delete) {
                    deleteTask(taskId);
                    return true;

                } else if (item.getItemId() == R.id.menu_cancel) {
                    popupMenu.dismiss();
                    return true;
                }
                return false;
            });

            popupMenu.show();
        });
    
}); 


Common Type Conversions:
Java Type	Convert TO Database	Convert FROM Database
int	String.valueOf(myInt)	Integer.parseInt(dbString)
long	String.valueOf(myLong)	Long.parseLong(dbString)
double	String.valueOf(myDouble)	Double.parseDouble(dbString)
boolean	String.valueOf(myBool)	Boolean.parseBoolean(dbString)
 

You should convert String → proper type BEFORE putting into ContentValues:
HashMap<String, String> task = new HashMap<>();
task.put("priority", "5");  // String

ContentValues values = new ContentValues();
values.put("priority", task.get("priority"));  // Putting String into INTEGER column
// SQLite tries to guess, might work but not ideal

//  CORRECT - convert first, then put with right method
ContentValues values = new ContentValues();
int priority = Integer.parseInt(task.get("priority"));  // Convert String → Integer
values.put("priority", priority);  // Put as INTEGER (matching schema)


ContentValues Methods:
// For TEXT columns
values.put("name", "Study");  // String → TEXT 
values.put("name", textString);

// For INTEGER columns
values.put("id", 5);  // int → INTEGER 
values.put("priority", Integer.parseInt(priorityString));

// For LONG columns
values.put("timestamp", 1234567890L);  // long → LONG/INTEGER 

// For REAL (Double) columns
values.put("rating", 4.5);  // double → REAL 
// 

*/