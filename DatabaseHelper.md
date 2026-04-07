# DatabaseHelper Reference — `#sqlite` `#sqliteopenhelper` `#cursor` `#hashmap`

> Search tags: `#sqlite` `#insert` `#update` `#delete` `#getall` `#cursor` `#hashmap` `#groupby` `#spinner-db` `#tablelayout-db` `#notifydatasetchanged`

---

## 1. CRUD Operations

### INSERT

```java
ContentValues v = new ContentValues();
v.put("task_name", "Study");
v.put("due_date",  "2026-04-10");
v.put("priority",  "High");

db.insert("tasks", v);
// or capture row ID:
long rowId = db.insert("tasks", v);
String serialNo = "TASK-" + String.format("%04d", rowId);
```

### GET ALL — returns List<HashMap<String, String>>

```java
List<HashMap<String, String>> list = db.getAll("tasks");

for (HashMap<String, String> row : list) {
    String name = row.get("task_name");
    String date = row.get("due_date");
}
```

### UPDATE

```java
ContentValues v = new ContentValues();
v.put("task_name", "Updated");

db.update("tasks", v, "id=?", new String[]{"1"});
```

### DELETE

```java
db.delete("tasks", "id=?", new String[]{"1"});
// Then refresh list:
adapter.notifyDataSetChanged();
```

---

## 2. HashMap — How it works with DB rows

### Case 1: Direct use (no model)

```java
// Manually extract fields from HashMap — no model class needed
String name = row.get("task_name");
String date = row.get("due_date");
```

### Case 2: Convert HashMap → Model object (IMPORTANT)

```java
// DB → HashMap → Model (Task)
HashMap<String, String> row = list.get(0);

Task task = new Task(
    Integer.parseInt(row.get("id")),   // everything stored as String — convert manually
    row.get("task_name"),
    row.get("due_date"),
    row.get("priority")
);

// int conversion pattern:
int id = Integer.parseInt(row.get("id"));
```

### Common HashMap methods

```java
HashMap<String, String> map = new HashMap<>();

map.put("name", "Shambhavi");          // insert
String name = map.get("name");         // retrieve
map.containsKey("name");               // check key exists
map.remove("name");                    // remove

for (String key : map.keySet()) {      // loop all entries
    String value = map.get(key);
}
```

---

## 3. Cursor — reading query results

### Full pattern: get cursor → loop rows → read columns

```java
// Step 1: get cursor
Cursor cursor = dbHelper.getAllItems();
// Cursor holds query result. Pointer is BEFORE first row.

// Step 2: move to first row
cursor.moveToFirst();

// Step 3: loop through all rows
if (cursor != null) {
    if (cursor.moveToFirst()) {
        do {
            int    id   = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String name = cursor.getString(cursor.getColumnIndexOrThrow("item_name"));
            int    cost = cursor.getInt(cursor.getColumnIndexOrThrow("item_cost"));
            // use values...
        } while (cursor.moveToNext());
    }
    cursor.close();   // always close
}
```

### Column reading breakdown

```java
// getColumnIndexOrThrow("id")  → finds column position (e.g. column 0)
// getInt(columnIndex)          → reads int value from that column
// getString(columnIndex)       → reads String value

int    id   = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
String name = cursor.getString(cursor.getColumnIndexOrThrow("item_name"));
int    cost = cursor.getInt(cursor.getColumnIndexOrThrow("item_cost"));
```

---

## 4. Spinner populated from DB + select item → total cost (Lab 8 Q2)

```java
// Build parallel lists while reading cursor
ArrayList<Integer> itemIdList = new ArrayList<>();
ArrayList<String>  itemList   = new ArrayList<>();

Cursor cursor = dbHelper.getAllItems();
if (cursor != null) {
    if (cursor.moveToFirst()) {
        do {
            int    id   = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String name = cursor.getString(cursor.getColumnIndexOrThrow("item_name"));
            int    cost = cursor.getInt(cursor.getColumnIndexOrThrow("item_cost"));
            itemIdList.add(id);
            itemList.add(name + " (₹" + cost + ")");
        } while (cursor.moveToNext());
    }
    cursor.close();
}

// Bind to Spinner
ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
    android.R.layout.simple_spinner_item, itemList);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinnerItems.setAdapter(adapter);

// On Add button — get selected item's cost from DB
btnAdd.setOnClickListener(v -> {
    int position = spinnerItems.getSelectedItemPosition();
    if (position >= 0 && position < itemIdList.size()) {
        int itemId = itemIdList.get(position);
        Cursor c = dbHelper.getItemById(itemId);
        if (c != null && c.moveToFirst()) {
            String name = c.getString(c.getColumnIndexOrThrow("item_name"));
            int    cost = c.getInt(c.getColumnIndexOrThrow("item_cost"));

            selectedItems.add(name + " - ₹" + cost);
            totalCost += cost;

            StringBuilder builder = new StringBuilder("Selected Items:\n");
            for (String item : selectedItems)
                builder.append(item).append("\n");

            tvSelectedItems.setText(builder.toString());
            tvTotal.setText("Total: ₹" + totalCost);
        }
        if (c != null) c.close();
    }
});
```

---

## 5. notifyDataSetChanged — refresh ListView after DB change

```java
// Keep ArrayList reference — NEVER use static String[]
ArrayList<String> displayList = new ArrayList<>();
ArrayAdapter<String> adapter  = new ArrayAdapter<>(this,
    android.R.layout.simple_list_item_1, displayList);
listView.setAdapter(adapter);

// Call after INSERT / UPDATE / DELETE
private void refreshList() {
    displayList.clear();
    Cursor c = dbHelper.getAll();
    while (c.moveToNext())
        displayList.add(c.getString(c.getColumnIndexOrThrow("task_name")));
    c.close();
    adapter.notifyDataSetChanged();
}

// Always reload in onResume so list refreshes when coming back from another screen
@Override
protected void onResume() {
    super.onResume();
    refreshList();
}
```

---

## 6. Save movie review — INSERT then clear form (Lab 8 Q3)

```java
boolean inserted = dbHelper.insertMovie(movieName, year, rating);

if (inserted) {
    Toast.makeText(this, "Movie review saved", Toast.LENGTH_SHORT).show();
    etMovieName.setText("");
    etYear.setText("");
    seekBarRating.setProgress(1);
    tvRatingLabel.setText("Rating: 1");
    loadMovieNames();    // refresh ListView
    clearTable();        // clear TableLayout
} else {
    Toast.makeText(this, "Failed to save review", Toast.LENGTH_SHORT).show();
}
```

---

## 7. TableLayout — add row helper (Lab 8 Q3 movie details)

```java
// Helper method — call once per field
private void addTableRow(String key, String value) {
    TableRow row = new TableRow(this);
    TextView k = new TextView(this);
    TextView v = new TextView(this);
    k.setText(key);   k.setPadding(8, 6, 16, 6); k.setTypeface(null, Typeface.BOLD);
    v.setText(value); v.setPadding(8, 6, 8, 6);
    row.addView(k);
    row.addView(v);
    tableLayout.addView(row);
}

// Usage:
tableLayout.removeAllViews();   // clear old rows first
addTableRow("Movie",  movieName);
addTableRow("Year",   year);
addTableRow("Points", String.valueOf(rating));
```

---

## 8. GROUP BY / COUNT / SUM / AVG — summary screen queries

```java
// Total and count per category
Cursor c = db.rawQuery(
    "SELECT category, COUNT(*), SUM(amount) FROM expenses GROUP BY category",
    null);
while (c.moveToNext()) {
    String cat   = c.getString(0);
    int    count = c.getInt(1);
    double total = c.getDouble(2);
}
c.close();

// Average marks for a student
Cursor avg = db.rawQuery(
    "SELECT AVG(marks) FROM marks WHERE roll_no = ?",
    new String[]{rollNo});
if (avg.moveToFirst()) {
    double a = avg.getDouble(0);
}
avg.close();

// NOTE: GROUP BY only works with rawQuery() — not with db.query()
```

---

## 9. Date formatting — display DB date nicely

```java
String dbDate = "2026-04-10 14:30";

SimpleDateFormat inputFmt  = new SimpleDateFormat("yyyy-MM-dd HH:mm");
SimpleDateFormat outputFmt = new SimpleDateFormat("dd MMM yyyy, hh:mm a");

try {
    Date date = inputFmt.parse(dbDate);
    String formatted = outputFmt.format(date);
    tvDate.setText(formatted);   // e.g. "10 Apr 2026, 02:30 PM"
} catch (ParseException e) {
    e.printStackTrace();
}
```

---

## 10. ArrayAdapter — when to use built-in vs custom

```java
// Built-in (use when data is just text — no custom layout needed)
ArrayList<String> names = new ArrayList<>();
ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
    android.R.layout.simple_list_item_1, names);
listView.setAdapter(adapter);

// Custom adapter — use when row has image + text, or multiple fields
// See #custom-adapter in main handbook
```

---

## Unrelated / Misc Notes

### Visibility toggle

```java
// Show a hidden view on button click
btnShow.setOnClickListener(v -> {
    tvDetails.setVisibility(View.VISIBLE);
});

// In XML: start hidden
android:visibility="gone"
// gone    = hidden + takes no space
// invisible = hidden + still takes space
```

### Disable all inputs after submit (Lab 4 Q4)

```java
btnSubmit.setEnabled(false);
cb1.setEnabled(false);
cb2.setEnabled(false);
cb3.setEnabled(false);
```

### Spinner position check

```java
int position = spinnerItems.getSelectedItemPosition();
// Returns 0-based index. Returns -1 if nothing selected (rare with Spinner).
```

### EditText inputType

```xml
android:inputType="number"
android:inputType="text"
android:autofillHints="none"
```

### TextView — make text selectable (Lab 7 Q3 highlight)

```java
tvContent.setTextIsSelectable(true);
```

### Manifest — new Activity must be declared

```xml
<activity android:name=".ResultActivity"/>
```

### Toolbar — use NoActionBar theme in styles.xml

```xml
<style name="Theme.MyApp" parent="Theme.MaterialComponents.DayNight.NoActionBar">
    <!-- your colors -->
</style>
```

---

_DatabaseHelper.md — part of MAD Midsem Offline Handbook_
