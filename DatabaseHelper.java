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
    public static final String TABLE_ITEMS = "items";

    // 🔹 COLUMNS
    public static final String COL_ID = "id";
    public static final String COL_NAME = "item_name";
    public static final String COL_DATE = "due_date";
    public static final String COL_PRIORITY = "priority";

    // 🔹 CONSTRUCTOR
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // 🔹 CREATE TABLE
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_ITEMS + " (" +
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
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
    //  OPTIONAL: ITEM-SPECIFIC WRAPPER
    // =====================================================

    public long insertItem(String name, String date, String priority) {
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_DATE, date);
        values.put(COL_PRIORITY, priority);

        return insert(TABLE_ITEMS, values);
    }

    public int deleteItem(int id) {
        return delete(TABLE_ITEMS, "id=?", new String[]{String.valueOf(id)});
    }
}

    // =====================================================
    //  USAGE EXAMPLES (IMPORTANT)
    // =====================================================

    /*
    // 🔹 1. Initialize
    DatabaseHelper dbHelper = new DatabaseHelper(this);

    // 🔹 2. Insert (simple)
    dbHelper.insertItem("Study", "Tomorrow", "High");

    // 🔹 3. Insert (generic HashMap)
    HashMap<String, String> map = new HashMap<>();
    map.put(COL_NAME, "Workout");
    map.put(COL_DATE, "Today");
    map.put(COL_PRIORITY, "Medium");

    dbHelper.insertRow(TABLE_ITEMS, map);

    // 🔹 4. Get all
    List<HashMap<String, String>> list =
        dbHelper.getFiltered("SELECT * FROM " + TABLE_ITEMS, null);

    // 🔹 5. Sorting
    List<HashMap<String, String>> result = dbHelper.getFiltered(
        "SELECT * FROM " + TABLE_ITEMS + " ORDER BY " + COL_PRIORITY + " DESC",
        null
    );

    // 🔹 6. MAX
    List<HashMap<String, String>> result =
        dbHelper.getFiltered(
            "SELECT MAX(priority) as max_val FROM " + TABLE_ITEMS,
            null
        );

    String max = result.get(0).get("max_val");

    // 🔹 7. COUNT
    String count = dbHelper.getFiltered(
        "SELECT COUNT(*) as total FROM " + TABLE_ITEMS,
        null
    ).get(0).get("total");

    // 🔹 8. DELETE
    dbHelper.deleteItem(1);

    */


    
// =====================================================
////  MainActivity.java USAGE EXAMPLE 
// =====================================================

/*
// Class fields
private DatabaseHelper dbHelper;
private List<HashMap<String, String>> itemList;
private ArrayList<String> displayList;
private ArrayAdapter<String> adapter;
private ListView listView;
private Button btnSave;

// Generalized XML IDs used in this example:
// @+id/listViewItems, @+id/editTextInput, @+id/buttonActionPrimary
private EditText editTextInput;

private void initDbAndList() {
    dbHelper = new DatabaseHelper(this);

    listView = findViewById(R.id.listViewItems);
    editTextInput = findViewById(R.id.editTextInput);
    btnSave = findViewById(R.id.buttonActionPrimary);

    itemList = new ArrayList<>();
    displayList = new ArrayList<>();

    loadItems();

    btnSave.setOnClickListener(v -> saveItem());

    listView.setOnItemClickListener((parent, view, position, id) -> {
        HashMap<String, String> item = itemList.get(position);

        int itemId = Integer.parseInt(item.get(DatabaseHelper.COL_ID));

        String name = item.get(DatabaseHelper.COL_NAME);
        String date = item.get(DatabaseHelper.COL_DATE);
        String priority = item.get(DatabaseHelper.COL_PRIORITY);

        // Fill fields for editing
        editTextInput.setText(name + " | " + date + " | " + priority);

        // Example: delete directly
        // deleteItem(itemId);

        // OR update later:
        // updateItem(itemId);
    });
}

// Load data from DB -> ListView
private void loadItems() {
    itemList = dbHelper.getFiltered(
            "SELECT * FROM " + DatabaseHelper.TABLE_ITEMS,
            null
    );

    displayList.clear();

    for (HashMap<String, String> item : itemList) {
        String name = item.get(DatabaseHelper.COL_NAME);
        String date = item.get(DatabaseHelper.COL_DATE);
        String priority = item.get(DatabaseHelper.COL_PRIORITY);

        displayList.add(name + " | " + date + " | " + priority);
    }

    adapter = new ArrayAdapter<>(
            this,
            android.R.layout.simple_list_item_1,
            displayList
    );
    listView.setAdapter(adapter);
}

// Insert Item
private void saveItem() {
    String text = editTextInput.getText().toString().trim();
    if (text.isEmpty()) return;

    String[] parts = text.split("\\\\|");
    String name = parts.length > 0 ? parts[0].trim() : "";
    String date = parts.length > 1 ? parts[1].trim() : "NA";
    String priority = parts.length > 2 ? parts[2].trim() : "Medium";

    ContentValues values = new ContentValues();
    values.put(DatabaseHelper.COL_NAME, name);
    values.put(DatabaseHelper.COL_DATE, date);
    values.put(DatabaseHelper.COL_PRIORITY, priority);
     } else {
            values.put(DatabaseHelper.COL_STATUS, "Not Specified");

    dbHelper.insert(DatabaseHelper.TABLE_ITEMS, values);
    loadItems();
}

// Update Item
private void updateItem(int id) {
    String text = editTextInput.getText().toString().trim();
    if (text.isEmpty()) return;

    String[] parts = text.split("\\\\|");
    String name = parts.length > 0 ? parts[0].trim() : "";
    String date = parts.length > 1 ? parts[1].trim() : "NA";
    String priority = parts.length > 2 ? parts[2].trim() : "Medium";

    ContentValues values = new ContentValues();
    values.put(DatabaseHelper.COL_NAME, name);
    values.put(DatabaseHelper.COL_DATE, date);
    values.put(DatabaseHelper.COL_PRIORITY, priority);

    dbHelper.update(
            DatabaseHelper.TABLE_ITEMS,
            values,
            DatabaseHelper.COL_ID + "=?",
            new String[]{String.valueOf(id)}
    );

    loadItems();
}

// Delete Item
private void deleteItem(int id) {
    dbHelper.delete(
            DatabaseHelper.TABLE_ITEMS,
            DatabaseHelper.COL_ID + "=?",
            new String[]{String.valueOf(id)}
    );

    loadItems();
}
 
//Handle List Click 
listView.setOnItemClickListener((parent, view, position, id) -> {

    HashMap<String, String> item = itemList.get(position);

    int itemId = Integer.parseInt(item.get("id"));
    // Create PopupMenu
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
            popupMenu.inflate(R.menu.menu_task_options);  // Create this menu XML

            popupMenu.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.menu_edit) {
                    // Navigate to EditTaskActivity
                    Intent intent = new Intent(MainActivity.this, EditTaskActivity.class);
                    intent.putExtra("itemId", itemId);
                    startActivity(intent);
                    return true;

                } else if (item.getItemId() == R.id.menu_delete) {
                    deleteItem(itemId);
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