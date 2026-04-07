# Universal Combo Templates for MAD Exams

Purpose: copy-first templates for mixed Android questions from your Lab 1-8 pattern.

How to use:

- Pick the closest template.
- Keep IDs same while testing first run.
- After it works, rename labels and business logic.

## Template 1: Form + Spinner + SQLite + ListView

Best for:

- Ticket booking, grocery/cart, task manager, student records.

Components:

- EditText, Spinner, Button, ListView, SQLiteOpenHelper, ArrayAdapter.

XML skeleton (`activity_main.xml`):

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/etName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter name" />

    <Spinner
        android:id="@+id/spCategory"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp" />

    <Button
        android:id="@+id/btnSave"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:text="Save" />

    <ListView
        android:id="@+id/listView"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:layout_marginTop="8dp" />
</LinearLayout>
```

Java skeleton (`MainActivity.java`):

```java
public class MainActivity extends AppCompatActivity {
    EditText etName;
    Spinner spCategory;
    Button btnSave;
    ListView listView;

    DatabaseHelper db;
    ArrayList<String> rows = new ArrayList<>();
    ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        spCategory = findViewById(R.id.spCategory);
        btnSave = findViewById(R.id.btnSave);
        listView = findViewById(R.id.listView);
        db = new DatabaseHelper(this);

        ArrayAdapter<String> spinAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                new String[]{"A", "B", "C"});
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategory.setAdapter(spinAdapter);

        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rows);
        listView.setAdapter(listAdapter);

        btnSave.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String cat = spCategory.getSelectedItem().toString();
            if (name.isEmpty()) { etName.setError("Required"); return; }
            db.insertRow(name, cat);
            etName.setText("");
            loadRows();
        });

        loadRows();
    }

    private void loadRows() {
        rows.clear();
        Cursor c = db.getAllRows();
        while (c.moveToNext()) {
            rows.add(c.getInt(0) + ": " + c.getString(1) + " (" + c.getString(2) + ")");
        }
        c.close();
        listAdapter.notifyDataSetChanged();
    }
}
```

DB skeleton (`DatabaseHelper.java`):

```java
public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context c) { super(c, "AppDB", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE items(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, category TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS items");
        onCreate(db);
    }

    public long insertRow(String name, String category) {
        ContentValues v = new ContentValues();
        v.put("name", name);
        v.put("category", category);
        return getWritableDatabase().insert("items", null, v);
    }

    public Cursor getAllRows() {
        return getReadableDatabase().rawQuery("SELECT * FROM items", null);
    }
}
```

## Template 2: Menu + Intent + Extras (Options/Popup/Context)

Best for:

- Open profile/about/settings, open details page with selected data.

Components:

- Toolbar or menu resource, Intent explicit, putExtra/getStringExtra, optional popup/context menu.

Menu XML (`res/menu/menu_main.xml`):

```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <item android:id="@+id/menu_about" android:title="About" app:showAsAction="never" />
    <item android:id="@+id/menu_next" android:title="Next" app:showAsAction="ifRoom" />
</menu>
```

Sender (`MainActivity.java`):

```java
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    if (item.getItemId() == R.id.menu_next) {
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra("name", "Alice");
        i.putExtra("count", 3);
        startActivity(i);
        return true;
    }
    if (item.getItemId() == R.id.menu_about) {
        Toast.makeText(this, "About clicked", Toast.LENGTH_SHORT).show();
        return true;
    }
    return super.onOptionsItemSelected(item);
}
```

Receiver (`DetailActivity.java`):

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    TextView tv = findViewById(R.id.tvResult);
    Intent in = getIntent();
    String name = in.getStringExtra("name");
    int count = in.getIntExtra("count", 0);
    tv.setText("Name: " + name + "\nCount: " + count);
}
```

Manifest reminder:

- Add `<activity android:name=".DetailActivity" />`.

## Template 3: DatePicker + TimePicker + Validation + Summary Screen

Best for:

- Appointment booking, travel booking, show timing-based rules.

Components:

- DatePicker/DatePickerDialog, TimePicker, Toggle/Switch, Button, Intent extras.

Core logic (`MainActivity.java`):

```java
DatePicker datePicker = findViewById(R.id.datePicker);
TimePicker timePicker = findViewById(R.id.timePicker);
Button btnSubmit = findViewById(R.id.btnSubmit);

btnSubmit.setOnClickListener(v -> {
    int day = datePicker.getDayOfMonth();
    int month = datePicker.getMonth() + 1;
    int year = datePicker.getYear();

    int hour;
    int minute;
    if (Build.VERSION.SDK_INT >= 23) {
        hour = timePicker.getHour();
        minute = timePicker.getMinute();
    } else {
        hour = timePicker.getCurrentHour();
        minute = timePicker.getCurrentMinute();
    }

    String date = day + "/" + month + "/" + year;
    String time = String.format("%02d:%02d", hour, minute);

    Intent i = new Intent(MainActivity.this, SummaryActivity.class);
    i.putExtra("date", date);
    i.putExtra("time", time);
    startActivity(i);
});
```

Rule add-on example:

- If time > 20:00 then show premium message or disable normal booking.

## Template 4: Tabs + Fragment + List/Grid/Table Mix

Best for:

- "One app, multiple views" questions.

Components:

- TabLayout, ViewPager2, FragmentStateAdapter, Fragment layouts.

Activity (`MainActivity.java`):

```java
TabLayout tabLayout = findViewById(R.id.tabLayout);
ViewPager2 viewPager = findViewById(R.id.viewPager);
viewPager.setAdapter(new ViewPagerAdapter(this));

new TabLayoutMediator(tabLayout, viewPager, (tab, pos) -> {
    if (pos == 0) tab.setText("List");
    else if (pos == 1) tab.setText("Grid");
    else tab.setText("Table");
}).attach();
```

Adapter (`ViewPagerAdapter.java`):

```java
public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fa) { super(fa); }

    @NonNull @Override
    public Fragment createFragment(int position) {
        if (position == 0) return new ListFragment();
        if (position == 1) return new GridFragment();
        return new TableFragment();
    }

    @Override
    public int getItemCount() { return 3; }
}
```

Use case:

- Same data source shown in different UI styles without changing business logic.

## Template 5: Prebuilt SQLite DB + Search + Highlight/Selection

Best for:

- "Use existing database file and display/filter records" questions.

Components:

- assets DB copy, SQLiteDatabase.openDatabase, ListView, EditText search, optional Spannable highlight.

Prebuilt DB open:

```java
private SQLiteDatabase openDb() throws IOException {
    String dbName = "college.db";
    File dbFile = getDatabasePath(dbName);
    if (!dbFile.exists()) {
        dbFile.getParentFile().mkdirs();
        try (InputStream in = getAssets().open(dbName);
             OutputStream out = new FileOutputStream(dbFile)) {
            byte[] buf = new byte[4096];
            int len;
            while ((len = in.read(buf)) > 0) out.write(buf, 0, len);
            out.flush();
        }
    }
    return SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.OPEN_READWRITE);
}
```

Load and filter:

```java
private void loadByKeyword(SQLiteDatabase db, String key) {
    ArrayList<String> items = new ArrayList<>();
    Cursor c = db.rawQuery("SELECT name, branch FROM students WHERE name LIKE ?", new String[]{"%" + key + "%"});
    while (c.moveToNext()) {
        items.add(c.getString(0) + " - " + c.getString(1));
    }
    c.close();
    listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
}
```

## Rapid Exam Adaptation Checklist

- Keep IDs unchanged until app runs once.
- Validate all EditText inputs before DB/Intent.
- Close every Cursor.
- Add new Activity in manifest before run.
- Keep intent key names exactly same in sender and receiver.
- For TimePicker use API-level safe code.
- After logic works, then polish text and UI labels.
