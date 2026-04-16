## Table of Contents

- [01. HashMap-based - DB Row Access](#01-hashmap-based---db-row-access)
- [03. General - Cursor Reading](#03-general---cursor-reading)
- [04. General - getFiltered() Universal Query Engine](#04-general---getfiltered-universal-query-engine)
- [05. General - Spinner Populated from DB](#05-general---spinner-populated-from-db)
- [06. General - ListView Refresh (notifyDataSetChanged)](#06-general---listview-refresh-notifydatasetchanged)
- [07. General - GROUP BY / COUNT / SUM / AVG](#07-general---group-by--count--sum--avg)
- [08. General - Date Formatting](#08-general---date-formatting)
- [09. General - TableLayout Add Row Helper](#09-general---tablelayout-add-row-helper)
- [10. General - UI DatePicker, Fields, Dialogs](#10-general---ui-datepicker-fields-dialogs)
- [11. General - SQLite Data Types](#11-general---sqlite-data-types)
- [12. General - Misc Notes](#12-general---misc-notes)

## 01. HashMap-based - DB Row Access

### Case 1: Direct use, no model

```java
// Manually extract fields — no model class needed
String name = row.get("item_name");
String date = row.get("due_date");
```

### Case 2: Convert HashMap to model object

```java
// Flow: DB -> HashMap -> Model (Item)
HashMap<String, String> row = list.get(0);

Item item = new Item(
    Integer.parseInt(row.get("id")), // everything is String — convert manually
    row.get("item_name"),
    row.get("due_date"),
    row.get("priority")
);

// Int conversion pattern:
int id = Integer.parseInt(row.get("id"));
```

Earlier (Item model): `List<Item>` — access via `t.getItemName()`

Now (HashMap): `List<HashMap<String,String>>` — access via `t.get("item_name")`

### Common HashMap methods

```java
HashMap<String, String> map = new HashMap<>();

map.put("name", "Shambhavi"); // insert
String name = map.get("name"); // retrieve
map.containsKey("name"); // check key exists
map.remove("name"); // remove

for (String key : map.keySet()) { // loop all entries
    String value = map.get(key);
}
```

## 03. General - Cursor Reading

### Full pattern

```java
Cursor cursor = dbHelper.getAllItems();
// Pointer starts BEFORE first row

if (cursor != null) {
    if (cursor.moveToFirst()) {
        do {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String name = cursor.getString(cursor.getColumnIndexOrThrow("item_name"));
            int cost = cursor.getInt(cursor.getColumnIndexOrThrow("item_cost"));
            // use values...
        } while (cursor.moveToNext());
    }
    cursor.close(); // ALWAYS close
}
```

### Column reading

```java
// getColumnIndexOrThrow("id") -> finds column position (e.g. 0)
// getInt(columnIndex) -> reads int value from that column
// getString(columnIndex) -> reads String value

int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
String name = cursor.getString(cursor.getColumnIndexOrThrow("item_name"));
int cost = cursor.getInt(cursor.getColumnIndexOrThrow("item_cost"));

// Positional (0-indexed) — use only when column order is guaranteed:
cursor.getString(0); // col 0
cursor.getInt(1); // col 1
```

### Cursor navigation methods

| Method                    | What it does                             |
| ------------------------- | ---------------------------------------- |
| `cursor.moveToFirst()`    | Moves to first row                       |
| `cursor.moveToNext()`     | Moves to next row                        |
| `cursor.isAfterLast()`    | Checks if cursor passed last row         |
| `cursor.getColumnCount()` | Number of columns                        |
| `cursor.getColumnName(i)` | Name of column at index i                |
| `cursor.isNull(i)`        | Checks if column value is NULL           |
| `cursor.close()`          | MUST call when done — releases resources |

### Raw query - custom SQL

```java
SQLiteDatabase db = this.getReadableDatabase();
Cursor cursor = db.rawQuery(
    "SELECT MAX(marks) FROM students WHERE subject=?",
    new String[]{subject}
);
if (cursor.moveToFirst()) {
    int max = cursor.getInt(0);
}
cursor.close();

// Public helper in DatabaseHelper:
public Cursor executeQuery(String query, String[] args) {
    SQLiteDatabase db = this.getReadableDatabase();
    return db.rawQuery(query, args);
}
```

## 04. General - getFiltered() Universal Query Engine

### Complete generic template

```java
public List<HashMap<String, String>> getFiltered(String query, String[] args) {

    List<HashMap<String, String>> list = new ArrayList<>();
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = null;

    try {
        cursor = db.rawQuery(query, args);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                HashMap<String, String> row = new HashMap<>();

                // Loop all columns dynamically
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    String columnName = cursor.getColumnName(i);
                    row.put(columnName, cursor.isNull(i) ? null : cursor.getString(i));
                }

                list.add(row);
            } while (cursor.moveToNext());
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (cursor != null) cursor.close(); // VERY IMPORTANT
    }

    return list;
}
```

One function supports `WHERE`, `ORDER BY`, `GROUP BY`, `HAVING`, `MAX`, `SUM`, `COUNT`, `JOIN` - just change the SQL string.

### Usage examples

```java
// WHERE - filtering
dbHelper.getFiltered("SELECT * FROM students WHERE marks > ?", new String[]{"80"});

// ORDER BY - sorting (toppers first)
dbHelper.getFiltered("SELECT * FROM students ORDER BY marks DESC", null);

// GROUP BY - count per group
dbHelper.getFiltered("SELECT subject, COUNT(*) as total FROM students GROUP BY subject", null);
// Result: { "subject": "Math", "total": "5" }

// GROUP BY + HAVING
dbHelper.getFiltered(
    "SELECT subject, AVG(marks) as avg_marks FROM students GROUP BY subject HAVING avg_marks > 80",
    null
);

// Aggregate - MAX, SUM, COUNT
dbHelper.getFiltered("SELECT MAX(marks) as max_marks FROM students", null);
dbHelper.getFiltered("SELECT SUM(marks) FROM students", null);
```

### Reading results

```java
List<HashMap<String, String>> result = dbHelper.getFiltered(...);

// Access single aggregate value:
String max = result.get(0).get("max_marks");

// Loop all rows:
for (HashMap<String, String> row : result) {
    String name = row.get("name");
    String marks = row.get("marks");
    // Type conversion:
    int marksInt = Integer.parseInt(row.get("marks"));
}
```

### Important

Always use `AS` alias with aggregates.

```sql
-- Without alias - ugly key name, hard to use:
SELECT MAX(marks) FROM students;
result.get(0).get("MAX(marks)"); -- error-prone

-- With alias - clean key:
SELECT MAX(marks) AS max_marks FROM students;
result.get(0).get("max_marks"); -- clean
```

### SQL feature reference

| Feature            | SQL keyword          |
| ------------------ | -------------------- |
| Filter             | WHERE                |
| Sort               | ORDER BY             |
| Group              | GROUP BY             |
| Aggregate          | MAX, SUM, COUNT, AVG |
| Condition on group | HAVING               |

NOTE: GROUP BY only works with `rawQuery()` - not with `db.query()`

## 05. General - Spinner Populated from DB

Build spinner + handle selection (Lab 8 Q2)

```java
// Build parallel lists while reading cursor
ArrayList<Integer> itemIdList = new ArrayList<>();
ArrayList<String> itemList = new ArrayList<>();

Cursor cursor = dbHelper.getAllItems();
if (cursor != null) {
    if (cursor.moveToFirst()) {
        do {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String name = cursor.getString(cursor.getColumnIndexOrThrow("item_name"));
            int cost = cursor.getInt(cursor.getColumnIndexOrThrow("item_cost"));
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

// On Add button - get selected item's cost from DB
btnAdd.setOnClickListener(v -> {
    int position = spinnerItems.getSelectedItemPosition();
    if (position >= 0 && position < itemIdList.size()) {
        int itemId = itemIdList.get(position);
        Cursor c = dbHelper.getItemById(itemId);
        if (c != null && c.moveToFirst()) {
            String name = c.getString(c.getColumnIndexOrThrow("item_name"));
            int cost = c.getInt(c.getColumnIndexOrThrow("item_cost"));

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

// Spinner position check:
// Returns 0-based index. Returns -1 if nothing selected (rare with Spinner).
int position = spinnerItems.getSelectedItemPosition();
```

## 06. General - ListView Refresh (`notifyDataSetChanged`)

```java
// Keep ArrayList reference - NEVER use static String[]
ArrayList<String> displayList = new ArrayList<>();
ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
        android.R.layout.simple_list_item_1, displayList);
listView.setAdapter(adapter);

// Call after INSERT / UPDATE / DELETE
private void refreshList() {
    displayList.clear();
    Cursor c = dbHelper.getAll();
    while (c.moveToNext())
        displayList.add(c.getString(c.getColumnIndexOrThrow("item_name")));
    c.close();
    adapter.notifyDataSetChanged();
}

// Always reload in onResume so list refreshes when coming back from another screen
@Override
protected void onResume() {
    super.onResume();
    refreshList();
}

// After INSERT with display logic:
displayList.clear();
displayList.add("Top marks in Math: " + maxMarks);
adapter.notifyDataSetChanged();
```

## 07. General - GROUP BY / COUNT / SUM / AVG

```java
// Total and count per category
Cursor c = db.rawQuery(
    "SELECT category, COUNT(*), SUM(amount) FROM expenses GROUP BY category",
    null);
while (c.moveToNext()) {
    String cat = c.getString(0);
    int count = c.getInt(1);
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

// MAX example
Cursor cursor = db.rawQuery(
    "SELECT MAX(marks) FROM students WHERE subject=?",
    new String[]{subject}
);
if (cursor.moveToFirst()) {
    int max = cursor.getInt(0);
}
cursor.close();
```

Remember: GROUP BY only works with `rawQuery()` - not `db.query()`

## 08. General - Date Formatting

```java
String dbDate = "2026-04-10 14:30";

SimpleDateFormat inputFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
SimpleDateFormat outputFmt = new SimpleDateFormat("dd MMM yyyy, hh:mm a");

try {
    Date date = inputFmt.parse(dbDate);
    String formatted = outputFmt.format(date);
    tvDate.setText(formatted); // -> "10 Apr 2026, 02:30 PM"
} catch (ParseException e) {
    e.printStackTrace();
}
```

## 09. General - TableLayout Add Row Helper

### Helper method (Lab 8 Q3 - movie details)

```java
// Add one row per field
private void addTableRow(String key, String value) {
    TableRow row = new TableRow(this);
    TextView k = new TextView(this);
    TextView v = new TextView(this);
    k.setText(key); k.setPadding(8, 6, 16, 6); k.setTypeface(null, Typeface.BOLD);
    v.setText(value); v.setPadding(8, 6, 8, 6);
    row.addView(k);
    row.addView(v);
    tableLayout.addView(row);
}
```

### Usage - clear old rows first

```java
tableLayout.removeAllViews();
addTableRow("Movie", movieName);
addTableRow("Year", year);
addTableRow("Points", String.valueOf(rating));
```

### Save movie review + clear form (Lab 8 Q3)

```java
boolean inserted = dbHelper.insertMovie(movieName, year, rating);

if (inserted) {
    Toast.makeText(this, "Movie review saved", Toast.LENGTH_SHORT).show();
    etMovieName.setText("");
    etYear.setText("");
    seekBarRating.setProgress(1);
    tvRatingLabel.setText("Rating: 1");
    loadMovieNames(); // refresh ListView
    clearTable(); // clear TableLayout
} else {
    Toast.makeText(this, "Failed to save review", Toast.LENGTH_SHORT).show();
}
```

## 10. General - UI DatePicker, Fields, Dialogs

### DatePicker on EditText

```java
// User cannot type manually - must pick from picker
etDueDate.setFocusable(false);

etDueDate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        showDatePicker();
    }
});

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
```

### Field helpers

```java
// Read from EditText
String itemName = editTextInput.getText().toString().trim();

// Validate - check if empty
if (TextUtils.isEmpty(dueDate)) {
    etDueDate.setError("Select due date");
    return;
}

// Clear all fields
private void clearFields() {
    editTextInput.setText("");
    etDueDate.setText("");
    spinnerPriority.setSelection(0);
}

// Access item ID from list position
Item item = itemList.get(position);
int itemId = item.getId();

// Set ID when editing (update flow)
if (isEditing) {
    item.setId(existingId);
}
```

### Options dialog (Edit / Delete on long-press)

```java
private void showOptionsDialog(int position) {
    Item selectedItem = itemList.get(position);

    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Choose Option");
    builder.setItems(new CharSequence[]{"Edit", "Delete"}, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            if (which == 0) {
                editItem(selectedItem);
            } else if (which == 1) {
                deleteItem(selectedItem.getId());
            }
        }
    });
    builder.show();
}
```

### ArrayAdapter - built-in vs custom

```java
// Built-in (data is just text - no custom layout needed)
ArrayList<String> names = new ArrayList<>();
ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
        android.R.layout.simple_list_item_1, names);
listView.setAdapter(adapter);

// Custom adapter - use when row has image + text, or multiple fields
// See #custom-adapter in main handbook

// Generalized XML IDs to prefer in notes and examples:
// @+id/layoutRootLinear, @+id/layoutRootRelative, @+id/scrollContainer,
// @+id/layoutContent, @+id/textViewPrimary, @+id/textViewSecondary,
// @+id/editTextInput, @+id/buttonActionPrimary, @+id/imageViewPreview,
// @+id/checkBoxOption, @+id/radioGroupOptions, @+id/radioButtonOption1,
// @+id/radioButtonOption2, @+id/toggleButtonState, @+id/switchState,
// @+id/seekBarValue, @+id/zoomButtonIn, @+id/spinnerOptions,
// @+id/listViewItems, @+id/gridViewItems, @+id/tableLayoutData,
// @+id/datePickerInput, @+id/timePickerInput, @+id/toolbarMain,
// @+id/tabLayoutMain, @+id/viewPagerMain, @+id/menuActionPrimary,
// @+id/menuActionSecondary, @+id/fragmentContainerMain
```

## 11. General - SQLite Data Types

| Type    | Meaning                   |
| ------- | ------------------------- |
| INTEGER | Whole numbers             |
| REAL    | Decimal numbers           |
| TEXT    | String                    |
| BLOB    | Binary data (images etc.) |
| NULL    | Empty / no value          |

## 12. General - Misc Notes

### Visibility toggle

```java
// Show a hidden view on button click
btnShow.setOnClickListener(v -> {
    tvDetails.setVisibility(View.VISIBLE);
});

// XML - start hidden
android:visibility="gone" // hidden + takes NO space
android:visibility="invisible" // hidden + still takes space
```

### Disable all inputs after submit (Lab 4 Q4)

```java
btnSubmit.setEnabled(false);
cb1.setEnabled(false);
cb2.setEnabled(false);
cb3.setEnabled(false);
```

### EditText input types (XML)

```xml
android:inputType="number"
android:inputType="text"
android:autofillHints="none"
```

### TextView - make text selectable (Lab 7 Q3)

```java
tvContent.setTextIsSelectable(true);
```

### Manifest - declare new Activity

```xml
<activity android:name=".ResultActivity"/>
```

Always add a new Activity to AndroidManifest.xml - app will crash at runtime if missing.

### Toolbar - NoActionBar theme (styles.xml)

```xml
<style name="Theme.MyApp" parent="Theme.MaterialComponents.DayNight.NoActionBar">
    <!-- your colors -->
</style>
```

### Setup reminders

- Add vector assets to drawable
- Add new Activity to AndroidManifest
- Change id to main on root element of main layout
- Use getReadableDatabase() for SELECT, getWritableDatabase() for writes
