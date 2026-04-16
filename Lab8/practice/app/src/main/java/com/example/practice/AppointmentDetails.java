package com.example.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AppointmentDetails extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    private List<HashMap<String, String>> itemList;
    private ArrayList<String> displayList;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private boolean showOnlyPending = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointment_details);

        dbHelper = new DatabaseHelper(this);
        listView = findViewById(R.id.listViewItems);
        displayList = new ArrayList<>();

        registerForContextMenu(listView);
        loadItems();

        listView.setOnItemClickListener((parent, view, position, id) -> {
            HashMap<String, String> item = itemList.get(position);
            Intent intent = new Intent(this, EditTaskActivity.class); // Reusing EditTaskActivity as "Screen 3" logic
            intent.putExtra("itemId", Integer.parseInt(item.get(DatabaseHelper.COL_ID)));
            intent.putExtra("name", item.get(DatabaseHelper.COL_NAME));
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadItems();
    }

    private void loadItems() {
        String query = "SELECT * FROM " + DatabaseHelper.TABLE_NAME;
        if (showOnlyPending) {
            query += " WHERE " + DatabaseHelper.COL_STATUS + " LIKE 'Pending%'";
        }
        query += " ORDER BY " + DatabaseHelper.COL_DATE + " DESC";

        itemList = dbHelper.getFiltered(query, null);
        displayList.clear();

        for (HashMap<String, String> item : itemList) {
            displayList.add(item.get(DatabaseHelper.COL_NAME) + " | " + 
                           item.get(DatabaseHelper.COL_DOCTOR) + " | " + 
                           item.get(DatabaseHelper.COL_DATE) + " | " + 
                           item.get(DatabaseHelper.COL_STATUS));
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select Action");
        menu.add(0, 1, 0, "Mark Confirmed");
        menu.add(0, 2, 0, "Cancel Appointment");
        menu.add(0, 3, 0, "Delete");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int id = Integer.parseInt(itemList.get(info.position).get(DatabaseHelper.COL_ID));

        if (item.getItemId() == 1) { // Confirm
            updateStatus(id, "Confirmed");
        } else if (item.getItemId() == 2) { // Cancel
            updateStatus(id, "Cancelled");
        } else if (item.getItemId() == 3) { // Delete
            dbHelper.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.COL_ID + "=?", new String[]{String.valueOf(id)});
            loadItems();
        }
        return true;
    }

    private void updateStatus(int id, String status) {
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COL_STATUS, status);
        dbHelper.update(DatabaseHelper.TABLE_NAME, cv, DatabaseHelper.COL_ID + "=?", new String[]{String.valueOf(id)});
        loadItems();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 10, 0, "Show Pending Only");
        menu.add(0, 11, 0, "Show All");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 10) {
            showOnlyPending = true;
            loadItems();
        } else if (item.getItemId() == 11) {
            showOnlyPending = false;
            loadItems();
        }
        return super.onOptionsItemSelected(item);
    }
}
