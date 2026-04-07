# MAD Lab Reference — ICT 3268

> Component-first reference. Every Android component, every listener/callback, all XML attributes, + GitHub solution links.
> Search in VS Code: Ctrl+F | Obsidian: Ctrl+F

---

## Table of Contents

- [MAD Lab Reference — ICT 3268](#mad-lab-reference--ict-3268)
  - [Table of Contents](#table-of-contents)
  - [TextView](#textview)
    - [XML — all key attributes](#xml--all-key-attributes)
    - [Java — all actions](#java--all-actions)
  - [EditText](#edittext)
    - [XML](#xml)
    - [Java — all listeners](#java--all-listeners)
  - [Button](#button)
    - [XML](#xml-1)
    - [Java — all listeners](#java--all-listeners-1)
  - [ImageView](#imageview)
    - [XML](#xml-2)
    - [Java](#java)
  - [CheckBox](#checkbox)
    - [XML](#xml-3)
    - [Java — all listeners](#java--all-listeners-2)
  - [RadioButton \& RadioGroup](#radiobutton--radiogroup)
    - [XML](#xml-4)
    - [Java — all listeners](#java--all-listeners-3)
  - [ToggleButton](#togglebutton)
    - [XML](#xml-5)
    - [Java — all listeners](#java--all-listeners-4)
  - [Switch](#switch)
    - [XML](#xml-6)
    - [Java](#java-1)
  - [SeekBar](#seekbar)
    - [XML](#xml-7)
    - [Java — all listeners](#java--all-listeners-5)
  - [Spinner](#spinner)
    - [XML](#xml-8)
    - [Java — basic + all listeners](#java--basic--all-listeners)
  - [ListView](#listview)
    - [XML](#xml-9)
    - [Java — all listeners](#java--all-listeners-6)
  - [GridView](#gridview)
    - [XML](#xml-10)
    - [Java — all listeners](#java--all-listeners-7)
  - [TabLayout + ViewPager](#tablayout--viewpager)
    - [XML](#xml-11)
    - [Java](#java-2)
  - [TableLayout](#tablelayout)
    - [XML](#xml-12)
  - [DatePickerDialog](#datepickerdialog)
  - [TimePickerDialog](#timepickerdialog)
  - [Intent](#intent)
  - [Toast](#toast)
  - [Options Menu](#options-menu)
    - [res/menu/menu_main.xml](#resmenumenu_mainxml)
    - [Java](#java-3)
  - [Toolbar / AppBar](#toolbar--appbar)
  - [Context Menu](#context-menu)
    - [res/menu/context_menu.xml](#resmenucontext_menuxml)
    - [Java](#java-4)
  - [Popup Menu](#popup-menu)
    - [res/menu/popup_menu.xml](#resmenupopup_menuxml)
    - [Java](#java-5)
  - [Contextual Action Mode](#contextual-action-mode)
    - [res/menu/contextual_action_menu.xml](#resmenucontextual_action_menuxml)
    - [Java](#java-6)
  - [SQLite](#sqlite)
    - [DatabaseHelper](#databasehelper)
    - [INSERT](#insert)
    - [SELECT all → ListView](#select-all--listview)
    - [SELECT with WHERE](#select-with-where)
    - [UPDATE](#update)
    - [DELETE](#delete)
    - [DB File path (Device File Explorer)](#db-file-path-device-file-explorer)
  - [Shared Preferences](#shared-preferences)
  - [Activity Lifecycle](#activity-lifecycle)
  - [Fragment](#fragment)
  - [Common Imports](#common-imports)

---

## TextView

### XML — all key attributes

```xml
<TextView
    android:id="@+id/textView"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Hello World"
    android:textColor="#FF5722"
    android:textSize="18sp"
    android:textStyle="bold"
    android:gravity="center"
    android:fontFamily="sans-serif-medium"
    android:padding="8dp"
    android:background="#EEEEEE"
    android:maxLines="2"
    android:ellipsize="end"
    android:textAllCaps="true"
    android:visibility="visible" />
```

### Java — all actions

```java
TextView tv = findViewById(R.id.textView);
tv.setText("New text");
String t = tv.getText().toString();
tv.setTextColor(Color.RED);
tv.setTextSize(20);
tv.setTypeface(null, Typeface.BOLD);
tv.setBackgroundColor(Color.YELLOW);
tv.setVisibility(View.VISIBLE);
tv.setVisibility(View.INVISIBLE);
tv.setVisibility(View.GONE);
tv.setOnClickListener(v -> Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show());
```

---

## EditText

### XML

```xml
<EditText
    android:id="@+id/editText"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="Enter name"
    android:inputType="text"
    android:maxLength="50"
    android:singleLine="true"
    android:imeOptions="actionDone"
    android:padding="8dp" />
```

### Java — all listeners

```java
EditText et = findViewById(R.id.editText);
String value = et.getText().toString().trim();
et.setText("Default");
if (value.isEmpty()) { et.setError("Required"); et.requestFocus(); return; }

// TextWatcher — every keystroke
et.addTextChangedListener(new TextWatcher() {
    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
    @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
        textView.setText("Typing: " + s);
    }
    @Override public void afterTextChanged(Editable s) {}
});

// Focus change
et.setOnFocusChangeListener((v, hasFocus) -> {
    if (!hasFocus) { /* validate */ }
});

// IME Done button
et.setOnEditorActionListener((v, actionId, event) -> {
    if (actionId == EditorInfo.IME_ACTION_DONE) { return true; }
    return false;
});

et.setEnabled(false); // disable editing
```

---

## Button

### XML

```xml
<Button
    android:id="@+id/button"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Submit"
    android:enabled="true"
    android:padding="12dp" />
```

### Java — all listeners

```java
Button btn = findViewById(R.id.button);

// Click
btn.setOnClickListener(v -> Toast.makeText(this, "Clicked!", Toast.LENGTH_SHORT).show());

// Long press
btn.setOnLongClickListener(v -> {
    Toast.makeText(this, "Long pressed!", Toast.LENGTH_SHORT).show();
    return true;
});

// Touch (raw)
btn.setOnTouchListener((v, event) -> {
    if (event.getAction() == MotionEvent.ACTION_DOWN) { /* pressed */ }
    if (event.getAction() == MotionEvent.ACTION_UP)   { /* released */ }
    return false;
});

btn.setEnabled(false);   // disable
btn.setText("Done");     // change label
```

---

## ImageView

### XML

```xml
<ImageView
    android:id="@+id/imageView"
    android:layout_width="100dp"
    android:layout_height="100dp"
    android:src="@drawable/my_image"
    android:scaleType="centerCrop"
    android:contentDescription="Image" />
```

### Java

```java
ImageView img = findViewById(R.id.imageView);
img.setImageResource(R.drawable.my_image);
img.setVisibility(View.VISIBLE);
img.setVisibility(View.GONE);
img.setOnClickListener(v -> Toast.makeText(this, "Image clicked", Toast.LENGTH_SHORT).show());
img.setScaleType(ImageView.ScaleType.CENTER_CROP);
```

---

## CheckBox

### XML

```xml
<CheckBox
    android:id="@+id/checkBox"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Option 1"
    android:checked="false" />
```

### Java — all listeners

```java
CheckBox cb = findViewById(R.id.checkBox);

// State change
cb.setOnCheckedChangeListener((btn, isChecked) -> {
    Toast.makeText(this, isChecked ? "Checked" : "Unchecked", Toast.LENGTH_SHORT).show();
});

// Click listener (alternative)
cb.setOnClickListener(v -> Log.d("CB", "Checked: " + ((CheckBox)v).isChecked()));

boolean checked = cb.isChecked();
cb.setChecked(true);
cb.setEnabled(false);  // lock state after submit
```

---

## RadioButton & RadioGroup

### XML

```xml
<RadioGroup android:id="@+id/radioGroup"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:orientation="vertical">
    <RadioButton android:id="@+id/rb1" android:text="Option A" android:checked="true" />
    <RadioButton android:id="@+id/rb2" android:text="Option B" />
</RadioGroup>
```

### Java — all listeners

```java
RadioGroup rg = findViewById(R.id.radioGroup);

rg.setOnCheckedChangeListener((group, checkedId) -> {
    if      (checkedId == R.id.rb1) Toast.makeText(this, "Option A", Toast.LENGTH_SHORT).show();
    else if (checkedId == R.id.rb2) Toast.makeText(this, "Option B", Toast.LENGTH_SHORT).show();
});

int selectedId = rg.getCheckedRadioButtonId();
String text = ((RadioButton) findViewById(selectedId)).getText().toString();
rg.check(R.id.rb1);
rg.clearCheck();
```

---

## ToggleButton

### XML

```xml
<ToggleButton android:id="@+id/toggleButton"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:textOn="Wi-Fi" android:textOff="Mobile Data"
    android:checked="false" />
```

### Java — all listeners

```java
ToggleButton toggle = findViewById(R.id.toggleButton);

toggle.setOnCheckedChangeListener((btn, isChecked) -> {
    img.setImageResource(isChecked ? R.drawable.wifi : R.drawable.mobile);
    Toast.makeText(this, isChecked ? "Wi-Fi ON" : "Mobile Data ON", Toast.LENGTH_SHORT).show();
});

boolean isOn = toggle.isChecked();
toggle.setChecked(true);
```

---

## Switch

### XML

```xml
<Switch android:id="@+id/switchBtn"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Dark Mode"
    android:textOn="ON" android:textOff="OFF" />
```

### Java

```java
Switch sw = findViewById(R.id.switchBtn);
sw.setOnCheckedChangeListener((btn, isChecked) ->
    Toast.makeText(this, isChecked ? "ON" : "OFF", Toast.LENGTH_SHORT).show());
boolean isOn = sw.isChecked();
sw.setChecked(true);
```

---

## SeekBar

### XML

```xml
<SeekBar android:id="@+id/seekBar"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:max="100" android:progress="50" />
```

### Java — all listeners

```java
SeekBar sb = findViewById(R.id.seekBar);
sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override public void onProgressChanged(SeekBar s, int progress, boolean fromUser) {
        textView.setText("Value: " + progress);
    }
    @Override public void onStartTrackingTouch(SeekBar s) { /* drag started */ }
    @Override public void onStopTrackingTouch(SeekBar s)  { /* drag ended */ }
});
int val = sb.getProgress();
sb.setProgress(75);
sb.setMax(200);
```

---

## Spinner

### XML

```xml
<Spinner android:id="@+id/spinner"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:spinnerMode="dropdown" />
```

### Java — basic + all listeners

```java
Spinner spinner = findViewById(R.id.spinner);
String[] items = {"Car","Bike","Bus","Truck"};
ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
    android.R.layout.simple_spinner_item, items);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinner.setAdapter(adapter);

spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override public void onItemSelected(AdapterView<?> parent, View v, int pos, long id) {
        Toast.makeText(getApplicationContext(), "Selected: " + items[pos], Toast.LENGTH_SHORT).show();
    }
    @Override public void onNothingSelected(AdapterView<?> parent) {}
});

String current = spinner.getSelectedItem().toString();
spinner.setSelection(0);
```

---

## ListView

### XML

```xml
<ListView android:id="@+id/listView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:dividerHeight="1dp" />
```

### Java — all listeners

```java
ListView lv = findViewById(R.id.listView);
String[] items = {"Cricket","Football","Tennis"};
lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));

lv.setOnItemClickListener((parent, view, pos, id) ->
    Toast.makeText(this, "Clicked: " + items[pos], Toast.LENGTH_SHORT).show());

lv.setOnItemLongClickListener((parent, view, pos, id) -> {
    Toast.makeText(this, "Long press: " + items[pos], Toast.LENGTH_SHORT).show();
    return true;
});

registerForContextMenu(lv); // for floating context menu

// Dynamic list
ArrayList<String> list = new ArrayList<>(Arrays.asList(items));
ArrayAdapter<String> dyn = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
lv.setAdapter(dyn);
list.add("Swimming");
dyn.notifyDataSetChanged();
```

---

## GridView

### XML

```xml
<GridView android:id="@+id/gridView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:numColumns="3"
    android:horizontalSpacing="8dp"
    android:verticalSpacing="8dp"
    android:stretchMode="columnWidth" />
```

### Java — all listeners

```java
GridView gv = findViewById(R.id.gridView);
String[] items = {"A","B","C","D","E","F"};
gv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));

gv.setOnItemClickListener((parent, view, pos, id) ->
    Toast.makeText(this, "Grid: " + items[pos], Toast.LENGTH_SHORT).show());

gv.setOnItemLongClickListener((parent, view, pos, id) -> {
    Toast.makeText(this, "Long: " + items[pos], Toast.LENGTH_SHORT).show();
    return true;
});
```

---

## TabLayout + ViewPager

### XML

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical">
    <com.google.android.material.tabs.TabLayout
        android:id="@+id/tabLayout"
        android:layout_width="match_parent" android:layout_height="wrap_content"
        app:tabMode="fixed" app:tabGravity="fill" />
    <androidx.viewpager.widget.ViewPager
        android:id="@+id/viewPager"
        android:layout_width="match_parent" android:layout_height="match_parent" />
</LinearLayout>
```

### Java

```java
TabLayout tabLayout = findViewById(R.id.tabLayout);
ViewPager viewPager  = findViewById(R.id.viewPager);
viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(),
        FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    @Override public Fragment getItem(int pos) {
        return new TabFragment(new String[]{"Top Stories","Sports","Entertainment"}[pos]);
    }
    @Override public int getCount() { return 3; }
    @Override public CharSequence getPageTitle(int pos) {
        return new String[]{"Top Stories","Sports","Entertainment"}[pos];
    }
});
tabLayout.setupWithViewPager(viewPager);

tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
    @Override public void onTabSelected(TabLayout.Tab tab) {
        Toast.makeText(MainActivity.this, "Tab: " + tab.getText(), Toast.LENGTH_SHORT).show();
    }
    @Override public void onTabUnselected(TabLayout.Tab tab) {}
    @Override public void onTabReselected(TabLayout.Tab tab) {}
});
```

---

## TableLayout

### XML

```xml
<TableLayout android:layout_width="match_parent"
    android:layout_height="wrap_content" android:stretchColumns="*">
    <TableRow android:background="#E0E0E0">
        <TextView android:text="Name"  android:textStyle="bold" android:padding="8dp"/>
        <TextView android:text="Score" android:textStyle="bold" android:padding="8dp"/>
    </TableRow>
    <TableRow>
        <TextView android:text="Alice" android:padding="8dp"/>
        <TextView android:text="95"    android:padding="8dp"/>
    </TableRow>
</TableLayout>
```

---

## DatePickerDialog

```java
Calendar cal = Calendar.getInstance();
new DatePickerDialog(this, (view, y, m, d) -> {
    tvDate.setText(d + "/" + (m+1) + "/" + y);
}, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show();

// No past dates
dpd.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
```

---

## TimePickerDialog

```java
Calendar cal = Calendar.getInstance();
new TimePickerDialog(this, (view, h, min) -> {
    tvTime.setText(String.format("%02d:%02d", h, min));
    // Premium after 12:00
    if (isPremium && h < 12) submitBtn.setEnabled(false);
    else submitBtn.setEnabled(true);
}, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show();
```

---

## Intent

```java
// Explicit
Intent i = new Intent(this, TargetActivity.class);
i.putExtra("key", "value"); i.putExtra("num", 42); i.putExtra("flag", true);
startActivity(i);
// Receive: getIntent().getStringExtra("key"); getIntent().getIntExtra("num",0);

// Open URL
startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://example.com")));

// Phone call
startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9876543210")));

// Email
Intent email = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:a@b.com"));
email.putExtra(Intent.EXTRA_SUBJECT, "Subject");
email.putExtra(Intent.EXTRA_TEXT, "Body");
startActivity(email);

// Share
Intent share = new Intent(Intent.ACTION_SEND);
share.setType("text/plain");
share.putExtra(Intent.EXTRA_TEXT, "Share this");
startActivity(Intent.createChooser(share, "Share via"));

// Back to specific activity
@Override public void onBackPressed() {
    Intent back = new Intent(this, MainActivity.class);
    back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(back); finish();
}
```

---

## Toast

```java
Toast.makeText(this, "Message", Toast.LENGTH_SHORT).show();
Toast.makeText(this, "Message", Toast.LENGTH_LONG).show();
// Custom position
Toast t = Toast.makeText(this, "Top", Toast.LENGTH_SHORT);
t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 100);
t.show();
```

---

## Options Menu

### res/menu/menu_main.xml

```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:id="@+id/action_search" android:title="Search"
        android:icon="@drawable/ic_search" android:showAsAction="ifRoom" />
    <item android:id="@+id/action_settings" android:title="Settings"
        android:showAsAction="never" />
    <item android:id="@+id/action_theme" android:title="Theme">
        <menu>
            <item android:id="@+id/theme_light" android:title="Light" />
            <item android:id="@+id/theme_dark"  android:title="Dark" />
        </menu>
    </item>
</menu>
```

### Java

```java
@Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu); return true;
}
@Override public boolean onPrepareOptionsMenu(Menu menu) {
    menu.findItem(R.id.action_search).setVisible(true); return super.onPrepareOptionsMenu(menu);
}
@Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case R.id.action_search:   Toast.makeText(this,"Search",Toast.LENGTH_SHORT).show(); return true;
        case R.id.action_settings: startActivity(new Intent(this,SettingsActivity.class)); return true;
        case R.id.theme_light:     Toast.makeText(this,"Light",Toast.LENGTH_SHORT).show(); return true;
        default: return super.onOptionsItemSelected(item);
    }
}
```

---

## Toolbar / AppBar

```xml
<androidx.appcompat.widget.Toolbar android:id="@+id/toolbar"
    android:layout_width="match_parent"
    android:layout_height="?attr/actionBarSize"
    android:background="?attr/colorPrimary"
    android:elevation="4dp" />
```

```java
Toolbar toolbar = findViewById(R.id.toolbar);
setSupportActionBar(toolbar);
getSupportActionBar().setTitle("My App");
getSupportActionBar().setDisplayHomeAsUpEnabled(true);
// handle back: if (item.getItemId() == android.R.id.home) { onBackPressed(); return true; }
```

---

## Context Menu

### res/menu/context_menu.xml

```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:id="@+id/action_open"   android:title="Open" />
    <item android:id="@+id/action_edit"   android:title="Edit" />
    <item android:id="@+id/action_delete" android:title="Delete" />
</menu>
```

### Java

```java
// Step 1 — register
registerForContextMenu(listView);

// Step 2 — create
@Override public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo info) {
    super.onCreateContextMenu(menu, v, info);
    menu.setHeaderTitle("Actions");
    getMenuInflater().inflate(R.menu.context_menu, menu);
}

// Step 3 — handle
@Override public boolean onContextItemSelected(MenuItem item) {
    AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
    // info.position = which item was long-pressed
    switch (item.getItemId()) {
        case R.id.action_open:   Toast.makeText(this,"Open",  Toast.LENGTH_SHORT).show(); return true;
        case R.id.action_edit:   Toast.makeText(this,"Edit",  Toast.LENGTH_SHORT).show(); return true;
        case R.id.action_delete: Toast.makeText(this,"Delete",Toast.LENGTH_SHORT).show(); return true;
        default: return super.onContextItemSelected(item);
    }
}
```

---

## Popup Menu

### res/menu/popup_menu.xml

```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:id="@+id/option_one"   android:title="Image 1" />
    <item android:id="@+id/option_two"   android:title="Image 2" />
    <item android:id="@+id/option_three" android:title="Image 3" />
</menu>
```

### Java

```java
btn.setOnClickListener(view -> {
    PopupMenu popup = new PopupMenu(MainActivity.this, view);
    popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
    popup.setOnMenuItemClickListener(item -> {
        switch (item.getItemId()) {
            case R.id.option_one:   imageView.setImageResource(R.drawable.img1); return true;
            case R.id.option_two:   imageView.setImageResource(R.drawable.img2); return true;
            default: return false;
        }
    });
    popup.setOnDismissListener(m -> Toast.makeText(this,"Closed",Toast.LENGTH_SHORT).show());
    popup.show();
});
```

---

## Contextual Action Mode

### res/menu/contextual_action_menu.xml

```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:id="@+id/action_delete" android:title="Delete"
        android:icon="@drawable/ic_delete" android:showAsAction="ifRoom" />
</menu>
```

### Java

```java
listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
    @Override public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        mode.getMenuInflater().inflate(R.menu.contextual_action_menu, menu); return true;
    }
    @Override public void onItemCheckedStateChanged(ActionMode mode, int pos, long id, boolean checked) {
        mode.setTitle(listView.getCheckedItemCount() + " selected");
    }
    @Override public boolean onPrepareActionMode(ActionMode m, Menu menu) { return false; }
    @Override public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        if (item.getItemId() == R.id.action_delete) { mode.finish(); return true; }
        return false;
    }
    @Override public void onDestroyActionMode(ActionMode mode) {}
});
```

---

## SQLite

### DatabaseHelper

```java
public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context ctx) { super(ctx, "AppDB.db", null, 1); }
    @Override public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tasks (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "name TEXT NOT NULL, due_date TEXT, priority TEXT)");
    }
    @Override public void onUpgrade(SQLiteDatabase db, int o, int n) {
        db.execSQL("DROP TABLE IF EXISTS tasks"); onCreate(db);
    }
}
```

### INSERT

```java
SQLiteDatabase db = dbHelper.getWritableDatabase();
ContentValues cv = new ContentValues();
cv.put("name","Buy milk"); cv.put("due_date","2025-12-01"); cv.put("priority","High");
long id = db.insert("tasks", null, cv);
db.close();
```

### SELECT all → ListView

```java
SQLiteDatabase db = dbHelper.getReadableDatabase();
Cursor c = db.rawQuery("SELECT * FROM tasks ORDER BY id DESC", null);
ArrayList<String> list = new ArrayList<>();
while (c.moveToNext())
    list.add(c.getString(c.getColumnIndexOrThrow("name")) + " [" + c.getString(c.getColumnIndexOrThrow("priority")) + "]");
c.close(); db.close();
listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list));
```

### SELECT with WHERE

```java
Cursor c = db.query("tasks", new String[]{"id","name","priority"},
    "priority = ?", new String[]{"High"}, null, null, "name ASC");
```

### UPDATE

```java
ContentValues cv = new ContentValues(); cv.put("priority","Low");
db.update("tasks", cv, "id = ?", new String[]{String.valueOf(taskId)});
db.close();
```

### DELETE

```java
db.delete("tasks", "id = ?", new String[]{String.valueOf(taskId)});
db.close();
```

### DB File path (Device File Explorer)

```
/data/data/<your.package.name>/databases/AppDB.db
```

---

## Shared Preferences

```java
SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
SharedPreferences.Editor editor = prefs.edit();

// SAVE
editor.putString("username","JohnDoe"); editor.putInt("age",25);
editor.putBoolean("isLoggedIn",true); editor.apply();

// READ
String  name  = prefs.getString("username","Guest");
int     age   = prefs.getInt("age",0);
boolean login = prefs.getBoolean("isLoggedIn",false);

// CHECK
boolean exists = prefs.contains("username");

// REMOVE / CLEAR
editor.remove("username"); editor.apply();
editor.clear(); editor.apply();

// Persist across app close
@Override protected void onResume() {
    super.onResume();
    editText.setText(getSharedPreferences("MyPrefs",MODE_PRIVATE).getString("savedText",""));
}
@Override protected void onPause() {
    super.onPause();
    getSharedPreferences("MyPrefs",MODE_PRIVATE).edit()
        .putString("savedText", editText.getText().toString()).apply();
}
```

---

## Activity Lifecycle

```java
@Override protected void onCreate(Bundle s)  { super.onCreate(s);  setContentView(R.layout.activity_main); Log.d("LC","onCreate"); }
@Override protected void onStart()           { super.onStart();   Log.d("LC","onStart"); }
@Override protected void onResume()          { super.onResume();  Log.d("LC","onResume"); }
@Override protected void onPause()           { super.onPause();   Log.d("LC","onPause"); }
@Override protected void onStop()            { super.onStop();    Log.d("LC","onStop"); }
@Override protected void onRestart()         { super.onRestart(); Log.d("LC","onRestart"); }
@Override protected void onDestroy()         { super.onDestroy(); Log.d("LC","onDestroy"); }

@Override protected void onSaveInstanceState(Bundle out) {
    super.onSaveInstanceState(out); out.putString("key","value");
}
@Override protected void onRestoreInstanceState(Bundle saved) {
    super.onRestoreInstanceState(saved); String v = saved.getString("key");
}
```

---

## Fragment

```java
public class TabFragment extends Fragment {
    private String content;
    public TabFragment(String content) { this.content = content; }
    @Override public View onCreateView(LayoutInflater inf, ViewGroup cont, Bundle b) {
        View v = inf.inflate(R.layout.fragment_tab, cont, false);
        ((TextView) v.findViewById(R.id.tabContent)).setText(content);
        return v;
    }
}

// Add programmatically
getSupportFragmentManager().beginTransaction()
    .replace(R.id.fragment_container, TabFragment.newInstance("Hello"))
    .addToBackStack(null).commit();
```

---

## Common Imports

```java
import android.widget.*;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.*;
```

---
