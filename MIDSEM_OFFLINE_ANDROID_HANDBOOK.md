# MAD Midsem Offline Handbook (Labs 1-7)

Purpose: one-file, no-internet reference for exam coding.

How to use fast:

- Use `Ctrl+F` in this file with component tags like `#scrollview`, `#spinner`, `#intent-explicit`, `#menu-context`.
- Every component section has: what it does, how used, where used (links), snippet, and extension ideas.

## Table of Contents

- [MAD Midsem Offline Handbook (Labs 1-7)](#mad-midsem-offline-handbook-labs-1-7)
  - [Table of Contents](#table-of-contents)
  - [1) Component Index (Searchable)](#1-component-index-searchable)
  - [2) Component-Wise Handbook](#2-component-wise-handbook)
    - [LinearLayout - `#linearlayout`](#linearlayout---linearlayout)
    - [RelativeLayout - `#relativelayout`](#relativelayout---relativelayout)
    - [ScrollView - `#scrollview`](#scrollview---scrollview)
    - [TextView - `#textview`](#textview---textview)
    - [EditText - `#edittext`](#edittext---edittext)
    - [Button - `#button`](#button---button)
    - [ImageView - `#imageview`](#imageview---imageview)
    - [CheckBox - `#checkbox`](#checkbox---checkbox)
    - [RadioButton - `#radiobutton`](#radiobutton---radiobutton)
    - [RadioGroup - `#radiogroup`](#radiogroup---radiogroup)
    - [ToggleButton - `#togglebutton`](#togglebutton---togglebutton)
    - [Switch - `#switch`](#switch---switch)
    - [SeekBar - `#seekbar`](#seekbar---seekbar)
    - [ZoomButton - `#zoombutton`](#zoombutton---zoombutton)
    - [Spinner - `#spinner`](#spinner---spinner)
    - [ArrayAdapter - `#arrayadapter`](#arrayadapter---arrayadapter)
    - [Custom Adapter - `#custom-adapter`](#custom-adapter---custom-adapter)
    - [ListView - `#listview`](#listview---listview)
    - [GridView - `#gridview`](#gridview---gridview)
    - [TableLayout and TableRow - `#tablelayout` `#tablerow`](#tablelayout-and-tablerow---tablelayout-tablerow)
    - [DatePicker - `#datepicker`](#datepicker---datepicker)
    - [TimePicker - `#timepicker`](#timepicker---timepicker)
    - [Toolbar - `#toolbar`](#toolbar---toolbar)
    - [TabLayout + ViewPager2 + FragmentStateAdapter - `#tabs` `#viewpager2` `#fragment`](#tablayout--viewpager2--fragmentstateadapter---tabs-viewpager2-fragment)
    - [Intent (Implicit URL) - `#intent-implicit`](#intent-implicit-url---intent-implicit)
    - [Toast and Custom Toast - `#toast` `#custom-toast`](#toast-and-custom-toast---toast-custom-toast)
    - [Options Menu - `#menu-options`](#options-menu---menu-options)
    - [Context Menu - `#menu-context`](#context-menu---menu-context)
    - [Contextual Action Mode - `#actionmode` `#contextual-action-mode`](#contextual-action-mode---actionmode-contextual-action-mode)
    - [Popup Menu - `#menu-popup`](#popup-menu---menu-popup)
    - [AlertDialog - `#alertdialog`](#alertdialog---alertdialog)
    - [SpannableString and BackgroundColorSpan - `#spans`](#spannablestring-and-backgroundcolorspan---spans)
    - [Activity Lifecycle - `#activity-lifecycle`](#activity-lifecycle---activity-lifecycle)
  - [5) Lab 8 Component-Wise Usage + Links](#5-lab-8-component-wise-usage--links)
    - [SQLite Flow (DB + List + Table) - `#sqlite` `#view-table`](#sqlite-flow-db--list--table---sqlite-view-table)
    - [Q4: View SQLite Table / Use Prebuilt DB - `#sqlite-q4` `#sqlite-prebuilt`](#q4-view-sqlite-table--use-prebuilt-db---sqlite-q4-sqlite-prebuilt)
    - [SQLiteOpenHelper - `#sqliteopenhelper`](#sqliteopenhelper---sqliteopenhelper)
    - [SharedPreferences - `#sharedpreferences`](#sharedpreferences---sharedpreferences)
    - [End-to-end example reference](#end-to-end-example-reference)
  - [6) Common Mistakes Checklist (Before Running)](#6-common-mistakes-checklist-before-running)
  - [8) Quick Path Index (Copy/Paste Friendly)](#8-quick-path-index-copypaste-friendly)

## 1) Component Index (Searchable)

`#linearlayout` `#relativelayout` `#scrollview` `#textview` `#edittext` `#button` `#imageview` `#checkbox` `#radiobutton` `#radiogroup` `#switch` `#togglebutton` `#seekbar` `#zoombutton` `#spinner` `#listview` `#gridview` `#tablelayout` `#tablerow` `#datepicker` `#timepicker` `#toolbar` `#tabs` `#viewpager2` `#fragment` `#arrayadapter` `#custom-adapter` `#intent-explicit` `#intent-implicit` `#toast` `#custom-toast` `#menu-options` `#menu-context` `#actionmode` `#contextual-action-mode` `#menu-popup` `#alertdialog` `#spans` `#activity-lifecycle`

Notes:

- This file is now component-wise.
- `ConstraintLayout` is not used in the Lab1-7 Android Studio solution folders currently present in this workspace.

## 2) Component-Wise Handbook

### LinearLayout - `#linearlayout`

What it does:

- Arranges children in a single row or column.

How used in solutions:

- Vertical form stacking and nested row-column composition.

Where used:

- [Lab2/Q3/app/src/main/res/layout/activity_linear.xml](Lab2/Q3/app/src/main/res/layout/activity_linear.xml)
- [Lab5/Q3/app/src/main/res/layout/activity_main.xml](Lab5/Q3/app/src/main/res/layout/activity_main.xml)

Snippet:

```xml
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:padding="20dp">
```

### RelativeLayout - `#relativelayout`

What it does:

- Places views relative to other views or parent edges.

How used in solutions:

- Label -> input -> action buttons aligned in one row.

Where used:

- [Lab2/Q3/app/src/main/res/layout/activity_relative.xml](Lab2/Q3/app/src/main/res/layout/activity_relative.xml)

Snippet:

```xml
<Button
    android:id="@+id/btnCancel"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_below="@id/etInput"
    android:layout_toStartOf="@id/btnOk" />
```

### ScrollView - `#scrollview`

What it does:

- Makes long content vertically scrollable.

How used in solutions:

- Wraps long forms and long text pages.

Where used:

- [Lab5/Q3/app/src/main/res/layout/activity_main.xml](Lab5/Q3/app/src/main/res/layout/activity_main.xml)
- [Lab6/Q1/app/src/main/res/layout/activity_main.xml](Lab6/Q1/app/src/main/res/layout/activity_main.xml)
- [Lab7/Q3/app/src/main/res/layout/activity_main.xml](Lab7/Q3/app/src/main/res/layout/activity_main.xml)

Snippet:

```xml
<ScrollView
    android:layout_width="match_parent"
    android:layout_height="match_parent">
```

What more you can do:

- Pair with `fillViewport="true"` for better full-screen behavior.

### TextView - `#textview`

What it does:

- Displays text; also used for dynamic content updates.

How used in solutions:

- Styling demo, selected item display, content block updates.

Where used:

- [Lab1/Q1/app/src/main/java/com/example/lab1_q1/MainActivity.java](Lab1/Q1/app/src/main/java/com/example/lab1_q1/MainActivity.java)
- [Lab6/Q1/app/src/main/java/com/example/lab6_q1/MainActivity.java](Lab6/Q1/app/src/main/java/com/example/lab6_q1/MainActivity.java)

Snippet:

```java
btnRed.setOnClickListener(v -> tv.setTextColor(Color.RED));
btnBig.setOnClickListener(v -> tv.setTextSize(26));
btnCenter.setOnClickListener(v -> tv.setGravity(Gravity.CENTER));
```

What more you can do:

- Use `setMovementMethod` for clickable links.
- Use spans for partial formatting.

### EditText - `#edittext`

What it does:

- Accepts user input.

How used in solutions:

- Input reading, trim, validation, inline error.

Where used:

- [Lab2/Q3/app/src/main/res/layout/activity_relative.xml](Lab2/Q3/app/src/main/res/layout/activity_relative.xml)
- [Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java](Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java)

Snippet (XML):

```xml
<EditText
    android:id="@+id/etVehicleNumber"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="Enter vehicle number"
    android:inputType="text" /number />
```

Snippet (Java):

```java
String vehicleNumber = etVehicleNumber.getText().toString().trim();
if (vehicleNumber.isEmpty()) {
    etVehicleNumber.setError("Enter vehicle number");
    etVehicleNumber.requestFocus();
    return;
}
```

### Button - `#button`

What it does:

- Triggers actions on click.

How used in solutions:

- Submit, reset, navigate, switch state.

Where used:

- [Lab4/Q2/app/src/main/java/com/example/lab4_q2/MainActivity.java](Lab4/Q2/app/src/main/java/com/example/lab4_q2/MainActivity.java)
- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)

Snippet:

```java
btnSave.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        saveOrUpdateTask();
    }
});
```

Multiple On Click Listeners

```java
View.OnClickListener listener = v -> {
    Button b = (Button) v;
    String text = b.getText().toString();
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
};
btn1.setOnClickListener(listener);
btn2.setOnClickListener(listener);
btn3.setOnClickListener(listener);
```

### ImageView - `#imageview`

What it does:

- Displays drawable resources dynamically.

How used in solutions:

- Mode/icon swap and banner/image switching.

Where used:

- [Lab4/Q3/app/src/main/java/com/example/lab4_q3/MainActivity.java](Lab4/Q3/app/src/main/java/com/example/lab4_q3/MainActivity.java)
- [Lab7/Q2/app/src/main/java/com/example/lab7_q2/MainActivity.java](Lab7/Q2/app/src/main/java/com/example/lab7_q2/MainActivity.java)

Snippet:

```java
if (item.getItemId() == R.id.image2) {
    mainImage.setImageResource(R.drawable.image2);
    return true;
}


    <ImageView
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:id="@+id/menuIcon"
        android:src="@drawable/ic_launcher_foreground"
        />
```

What more you can do:

- Use `setScaleType` for crop/fit behavior.

### CheckBox - `#checkbox`

What it does:

- Multiple independent selections.

How used in solutions:

- Build itemized order and total cost.

Where used:

- [Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java](Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java)

Snippet (XML):

```xml
<CheckBox
    android:id="@+id/cbPizza"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Pizza (Rs. 150)" />

<CheckBox
    android:id="@+id/cbBurger"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Burger (Rs. 100)" />
```

Snippet (Java):

```java
ArrayList<String> items = new ArrayList<>();
ArrayList<Integer> costs = new ArrayList<>();
int total = 0;

if (cbPizza.isChecked()) {
    items.add("Pizza");
    costs.add(150);
    total += 150;
}

if (items.isEmpty()) {
    Toast.makeText(this, "Select at least one item", Toast.LENGTH_SHORT).show();
    return;
}
submitted = true;
setChecked(true/false)
cbPizza.setEnabled(true/false);
```

What more you can do:

- Pre-check defaults for recommended combos.

### RadioButton - `#radiobutton`

What it does:

- Represents one selectable option inside a `RadioGroup`.

How used in solutions:

- Not directly present in current Lab1-7 solution folders; commonly used for single-choice questions.

Snippet (XML):

```xml
<RadioButton
    android:id="@+id/rbMale"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Male" />
```

Snippet (Java):

```java
RadioButton rbMale = findViewById(R.id.rbMale);
if (rbMale.isChecked()) {
    Toast.makeText(this, "Male selected", Toast.LENGTH_SHORT).show();
}
```

### RadioGroup - `#radiogroup`

What it does:

- Groups radio buttons so only one option can be selected at a time.

How used in solutions:

- Not directly present in current Lab1-7 solution folders; useful for single-select forms.

Snippet (XML):

```xml
<RadioGroup
    android:id="@+id/rgGender"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:orientation="vertical">

    <RadioButton
        android:id="@+id/rbMale"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Male" />

    <RadioButton
        android:id="@+id/rbFemale"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Female" />
</RadioGroup>
```

Snippet (Java):

```java
RadioGroup rgGender = findViewById(R.id.rgGender);
int selectedId = rgGender.getCheckedRadioButtonId();

if (selectedId != -1) {
    RadioButton selected = findViewById(selectedId);
    String value = selected.getText().toString();
    Toast.makeText(this, "Selected: " + value, Toast.LENGTH_SHORT).show();
}
```

### ToggleButton - `#togglebutton`

What it does:

- Two-state switch.

How used in solutions:

- Mode switch and premium ticket gating.

Where used:

- [Lab4/Q3/app/src/main/java/com/example/lab4_q3/MainActivity.java](Lab4/Q3/app/src/main/java/com/example/lab4_q3/MainActivity.java)
- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)

Snippet (XML):

```xml
<ToggleButton
    android:id="@+id/toggleBtn"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:textOn="ON"
    android:textOff="OFF"
    android:checked="false" />
```

Snippet (Java):

```java
toggleTicketType.setOnCheckedChangeListener((buttonView, isChecked) -> {
    checkPremiumBookingRule();
});

toggleBtn.setOnClickListener(v -> {
    if (toggleBtn.isChecked()) {
        showToast("Toggle ON", R.drawable.panda);
    } else {
        showToast("Toggle OFF", R.drawable.rat);
    }
});
togglebtn.setChecked(true/false)
```

### Switch - `#switch`

What it does:

- A modern two-state on/off control (alternative to `ToggleButton`).

How used in solutions:

- Not directly present in current Lab1-7 solution folders; useful for settings-style toggles.

Snippet (XML):

```xml
<Switch
    android:id="@+id/switchNotifications"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Enable Notifications" />
```

Snippet (Java):

```java
Switch switchNotifications = findViewById(R.id.switchNotifications);
switchNotifications.setOnCheckedChangeListener((buttonView, isChecked) -> {
    String msg = isChecked ? "Notifications ON" : "Notifications OFF";
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
});
```

### SeekBar - `#seekbar`

What it does:

- Lets the user select a value in a range by dragging a thumb.

How used in solutions:

- Not directly present in current Lab1-7 solution folders; useful for brightness, volume, and rating selection.

Snippet (XML):

```xml
<TextView
    android:id="@+id/tvSeekValue"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Value: 50" />

<SeekBar
    android:id="@+id/seekBarValue"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:max="100"
    android:progress="50" />
```

Snippet (Java):

```java
SeekBar seekBarValue = findViewById(R.id.seekBarValue);
TextView tvSeekValue = findViewById(R.id.tvSeekValue);

tvSeekValue.setText("Value: " + seekBarValue.getProgress());

seekBarValue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (progress < 1) {
                    seekBar.setProgress(1);
        tvSeekValue.setText("Value: " + progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast.makeText(MainActivity.this, "Selected: " + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
    }
});
//To clear
seekBar.setProgress(1)
```

### ZoomButton - `#zoombutton`

What it does:

- A button specialized for zoom in/zoom out actions.

How used in solutions:

- Not directly present in current Lab1-7 solution folders; used in image/map style screens.

Snippet (XML):

```xml
<ZoomButton
    android:id="@+id/btnZoomIn"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="+" />
```

Snippet (Java):

```java
ZoomButton btnZoomIn = findViewById(R.id.btnZoomIn);
ImageView ivPhoto = findViewById(R.id.ivPhoto);

btnZoomIn.setOnClickListener(v -> {
    ivPhoto.setScaleX(ivPhoto.getScaleX() + 0.1f);
    ivPhoto.setScaleY(ivPhoto.getScaleY() + 0.1f);
});
```

### Spinner - `#spinner`

What it does:

- Single-select dropdown list.

How used in solutions:

- Vehicle/movie/theatre selections and source-destination booking.

Where used:

- [Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java](Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java)
- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)

Snippet (XML):

```xml
<Spinner
    android:id="@+id/spinnerMovie"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

Snippet (Java):

```java
ArrayAdapter<String> movieAdapter = new ArrayAdapter<>(
        this,
        android.R.layout.simple_spinner_item,
        movies
);
movieAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinnerMovie.setAdapter(movieAdapter);

private void clearFields() {
    spinnerVehicleType.setSelection(0);
    etVehicleNumber.setText("");
}
```

What more you can do:

- Use custom row adapter (image + text). - array adapter

### ArrayAdapter - `#arrayadapter`

What it does:

- Bridges simple arrays/lists to UI lists and spinners.

Where used:

- [Lab3/Ques2/app/src/main/java/com/example/lab3_q2/MainActivity.java](Lab3/Ques2/app/src/main/java/com/example/lab3_q2/MainActivity.java)
- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)

Snippet:

```java
ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
        android.R.layout.simple_list_item_1, sports);
listView.setAdapter(adapter);


//Custom Spiner Adapter
public class MySpinnerAdapter extends ArrayAdapter<ItemModel> {

    Context context;
    ArrayList<ItemModel> list;

    public MySpinnerAdapter(Context context, ArrayList<ItemModel> list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.spinner_item, parent, false);
        }

        ImageView img = convertView.findViewById(R.id.imgIcon);
        TextView name = convertView.findViewById(R.id.txtName);

        ItemModel item = list.get(position);

        img.setImageResource(item.getImage());
        name.setText(item.getName());

        return convertView;
    }
}

Spinner spinner = findViewById(R.id.spinner);

ArrayList<ItemModel> list = new ArrayList<>();

list.add(new ItemModel("Beach", R.drawable.beach));
list.add(new ItemModel("Temple", R.drawable.temple));
list.add(new ItemModel("Museum", R.drawable.museum));

MySpinnerAdapter adapter = new MySpinnerAdapter(this, list);

spinner.setAdapter(adapter);
```

### Custom Adapter - `#custom-adapter`

What it does:

- Custom view binding for non-trivial row items.

Where used:

- [Lab5/Q2/app/src/main/java/com/example/lab5_q2/PlaceAdapter.java](Lab5/Q2/app/src/main/java/com/example/lab5_q2/PlaceAdapter.java)
- [Lab3/Q1/app/src/main/java/com/example/lab3_q1/ImageAdapter.java](Lab3/Q1/app/src/main/java/com/example/lab3_q1/ImageAdapter.java)

Snippet:

```java
if (convertView == null) {
    convertView = LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false);
}
PlaceModel currentItem = placeList.get(position);
imgPlace.setImageResource(currentItem.getImageResId());
txtPlaceName.setText(currentItem.getPlaceName());
```

### ListView - `#listview`

What it does:

- Scrollable vertical list.

How used in solutions:

- Sports list click handling and app list context-menu operations.

Where used:

- [Lab3/Ques2/app/src/main/java/com/example/lab3_q2/MainActivity.java](Lab3/Ques2/app/src/main/java/com/example/lab3_q2/MainActivity.java) - simple
- [Lab7/Q1/app/src/main/res/layout/activity_main.xml](Lab7/Q1/app/src/main/res/layout/activity_main.xml)

Snippet:

```java
  listView = findViewById(R.id.listView);

        String[] items = {"Apple", "Banana", "Mango", "Orange", "Grapes"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                items
        );

        listView.setAdapter(adapter);
listView.setOnItemClickListener((parent, view, position, id) -> {
    String selectedSport = sports[position];
    tvSelected.setText("Selected Sport: " + selectedSport);
});


//CUSTOM LISTVIEW -- Create a data class and row_app.xml

//Step 2: Create Adapter
public class AppAdapter extends BaseAdapter {

    Context ctx;
    List<AppItem> list;

    public AppAdapter(Context ctx, List<AppItem> list) {
        this.ctx = ctx;
        this.list = list;
    }

    public int getCount() {
        return list.size();
    }

    public Object getItem(int i) {
        return list.get(i);
    }

    public long getItemId(int i) {
        return i;
    }

    public View getView(int i, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(ctx)
                    .inflate(R.layout.row_app, parent, false);
        }

        ImageView img = convertView.findViewById(R.id.imgIcon);
        TextView name = convertView.findViewById(R.id.txtName);
        TextView pkg = convertView.findViewById(R.id.txtPackage);

        AppItem item = list.get(i);

        img.setImageDrawable(item.icon);
        name.setText(item.name);
        pkg.setText(item.packageName);

        return convertView;
    }
}
//Step 3: Use it in Activity
ListView listView = findViewById(R.id.listView);

AppAdapter adapter = new AppAdapter(this, appList);

listView.setAdapter(adapter);
```

- In Android ListView, getView() is called only for the items that are currently visible on the screen, plus a few extra for smooth scrolling.
  To click on listView Items

```java
listViewTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        showOptionsDialog(position);
    }
});
```

position → index in list (0,1,2…)
id → listView Row ID

### GridView - `#gridview`

What it does:

- 2D grid of items.

Where used:

- [Lab3/Q1/app/src/main/res/layout/fragment_grid.xml](Lab3/Q1/app/src/main/res/layout/fragment_grid.xml)
- [Lab3/Q1/app/src/main/java/com/example/lab3_q1/ImageAdapter.java](Lab3/Q1/app/src/main/java/com/example/lab3_q1/ImageAdapter.java)

Snippet:

```xml
    <GridView
        android:id="@+id/gridView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:numColumns="3"
        android:horizontalSpacing="10dp"
        android:verticalSpacing="10dp"
        android:padding="10dp"/>

GRID ITEM
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="100dp"
    android:orientation="vertical"
    android:gravity="center"
    android:background="#E0E0E0"
    android:padding="10dp">

    <TextView
        android:id="@+id/tvItem"
        android:text="Item"
        android:textSize="18sp"
        android:textColor="@android:color/black"/>
</LinearLayout>
```

GRID ADAPTER

```java
package com.example.lab3_q3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

    Context context;
    String[] items;

    public GridAdapter(Context context, String[] items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.grid_item, parent, false);
        }

        TextView tv = convertView.findViewById(R.id.tvItem);
        tv.setText(items[position]);

        return convertView;
    }
}

MAIN
gridView = findViewById(R.id.gridView);

        GridAdapter adapter = new GridAdapter(this, items);
        gridView.setAdapter(adapter);
```

### TableLayout and TableRow - `#tablelayout` `#tablerow`

What it does:

- Renders row-column data in table form.

How used in solutions:

- Dynamic order summary table generation.

Where used:

- [Lab4/Q4/app/src/main/res/layout/activity_order_summary.xml](Lab4/Q4/app/src/main/res/layout/activity_order_summary.xml)
- [Lab4/Q4/app/src/main/java/com/example/lab4_q4/OrderSummaryActivity.java](Lab4/Q4/app/src/main/java/com/example/lab4_q4/OrderSummaryActivity.java)

Snippet:

```xml
<TableLayout
    android:id="@+id/tableLayout"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:stretchColumns="1"
    android:padding="10dp">

    <!-- Title Row -->
    <TableRow>

        <TextView
            android:layout_span="2"
            android:text="User Information"
            android:textSize="20sp"
            android:textStyle="bold"
            android:gravity="center"
            android:padding="8dp"/>

    </TableRow>
</TableLayout>
```

```java
TableLayout tableLayout = findViewById(R.id.tableLayout);

// create row
TableRow row = new TableRow(this);

// create views
TextView tv = new TextView(this);
tv.setText("City");

EditText et = new EditText(this);
et.setHint("Enter city");

// add views to row
row.addView(tv);
row.addView(et);

// add row to table
tableLayout.addView(row);

//Clear table
tableLayoutDetails.removeAllViews()
```

### DatePicker - `#datepicker`

What it does:

- Date selection via inline calendar/spinners.

Where used:

- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)

Snippet:

```java

  <DatePicker
            android:id="@+id/datePickerTravel"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:calendarViewShown="false"
            android:spinnersShown="true"
            android:datePickerMode="spinner"/>


int day = datePickerShow.getDayOfMonth();
int month = datePickerShow.getMonth() + 1;
int year = datePickerShow.getYear();
String date = day + "/" + month + "/" + year;

//To Reset to current date
toggleTripType.setChecked(false);

        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        datePickerTravel.updateDate(currentYear, currentMonth, currentDay);

    long today = calendar.getTimeInMillis();

        calendar.add(Calendar.DAY_OF_MONTH, 20);
        long maxDate = calendar.getTimeInMillis();

        datePicker.setMinDate(today);
        datePicker.setMaxDate(maxDate);

          calendar.getActualMaximum(Calendar.DAY_OF_MONTH));// max day in month

         int day = calendar.get(Calendar.DAY_OF_WEEK);
if(day == Calendar.SATURDAY //weekend

```

### TimePicker - `#timepicker`

What it does:

- Time selection and change callbacks.

Where used:

- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)

Snippet:

```java

 <TimePicker
                android:id="@+id/timePickerShow"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginBottom="16dp" />


timePickerShow.setOnTimeChangedListener((view, hourOfDay, minute) -> {
    checkPremiumBookingRule();
});

int hour, minute;
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                hour = timePickerShow.getHour();
                minute = timePickerShow.getMinute();
            } else {
                hour = timePickerShow.getCurrentHour();
                minute = timePickerShow.getCurrentMinute();
            }

 String time = String.format("%02d:%02d", hour, minute);

 //Reset Time
 int hour = calendar.get(Calendar.HOUR_OF_DAY); // hour in 24 hour system
        int minute = calendar.get(Calendar.MINUTE);

        if (android.os.Build.VERSION.SDK_INT >= 23) {
            timePickerShow.setHour(hour);
            timePickerShow.setMinute(minute);
        } else {
            timePickerShow.setCurrentHour(hour);
            timePickerShow.setCurrentMinute(minute);
        }

```

What more you can do:

- Toggle 24-hour/12-hour mode based on use-case.

### Toolbar - `#toolbar`

What it does:

- Replaces default action bar; hosts menu actions.

Where used:

- [Lab7/Q3/app/src/main/res/layout/activity_main.xml](Lab7/Q3/app/src/main/res/layout/activity_main.xml)
- [Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java](Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java)

Snippet:

```java
<style name="Theme.MyApp" parent="Theme.MaterialComponents.DayNight.NoActionBar">
    <!-- your colors -->
</style>

Toolbar toolbar = findViewById(R.id.toolbar);
setSupportActionBar(toolbar);
IN ACTIVITY_MAIN OR CUSTOM TOOLBAR
<androidx.appcompat.widget.Toolbar
    android:id="@+id/toolbar"
    android:layout_width="match_parent"
    android:layout_height="?attr/actionBarSize"
    android:background="?attr/colorPrimary"
    android:title="My App"
    android:titleTextColor="@android:color/white"/>
```

### TabLayout + ViewPager2 + FragmentStateAdapter - `#tabs` `#viewpager2` `#fragment`

What it does:

- Multi-screen swipeable UI with tab headers.

Where used:

- [Lab3/Q1/app/src/main/java/com/example/lab3_q1/MainActivity.java](Lab3/Q1/app/src/main/java/com/example/lab3_q1/MainActivity.java)
- [Lab3/Q1/app/src/main/java/com/example/lab3_q1/ViewPagerAdapter.java](Lab3/Q1/app/src/main/java/com/example/lab3_q1/ViewPagerAdapter.java)
- [Lab3/Q3/app/src/main/java/com/example/lab3_q3/NewsPagerAdapter.java](Lab3/Q3/app/src/main/java/com/example/lab3_q3/NewsPagerAdapter.java)

Snippet:

```xml
 <com.google.android.material.tabs.TabLayout
        android:id="@+id/tabLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:tabIndicatorColor="@android:color/white"
        app:tabTextColor="@android:color/black"
        app:tabSelectedTextColor="@android:color/black"/>

    <!-- Pages -->
    <androidx.viewpager2.widget.ViewPager2
        android:id="@+id/viewPager"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

````java
package com.example.lab3_q3;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            case 2:
                return new ThirdFragment();
            default:
                return new FirstFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // number of tabs
    }
//in activity main
TabLayout tabLayout = findViewById(R.id.tabLayout);
ViewPager2 viewPager = findViewById(R.id.viewPager);

// Adapter
ViewPagerAdapter adapter = new ViewPagerAdapter(this);
viewPager.setAdapter(adapter);

// Connect tabs + pages
new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
    switch (position) {
        case 0:
            tab.setText("Tab 1");
            break;
        case 1:
            tab.setText("Tab 2");
            break;
        case 2:
            tab.setText("Tab 3");
            break;
    }
}).attach();

import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    public FirstFragment() {
        // Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TextView tv = new TextView(getContext());
        tv.setText("This is First Fragment");
        tv.setTextSize(22);
        return tv;
    }
}

### Intent (Explicit) - `#intent-explicit`

What it does:

- Navigates to another activity inside the app and sends typed data.

Where used:

- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)
- [Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java](Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java)

Snippet:

```java
// Sender Activity (MainActivity)
Intent intent = new Intent(MainActivity.this, BookingSummaryActivity.class);
intent.putExtra("movie", movie);
intent.putExtra("availableSeats", availableSeats);
startActivity(intent);

// Receiver Activity (BookingSummaryActivity)
Intent receivedIntent = getIntent();
String selectedMovie = receivedIntent.getStringExtra("movie");
int seats = receivedIntent.getIntExtra("availableSeats", 0);
ArrayList<String> items = getIntent().getStringArrayListExtra("items");
ArrayList<Integer> costs = getIntent().getIntegerArrayListExtra("costs");

<activity android:name=".ResultActivity"/>
Manifest
TextView tvMovie = findViewById(R.id.tvMovie);
TextView tvSeats = findViewById(R.id.tvSeats);
tvMovie.setText("Movie: " + selectedMovie);
tvSeats.setText("Available Seats: " + seats);

btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // go back to MainActivity for editing
            }
        });

btnBackHome.setOnClickListener(new View.OnClickListener() { // back home
    @Override
        public void onClick(View view) {

                Intent intent = new Intent(PreviewActivity.this, MainActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);
                finish();
            }
        });
````

### Intent (Implicit URL) - `#intent-implicit`

What it does:

- Opens browser for provided URL.

Where used:

- [Lab2/Q4/app/src/main/java/com/example/lab2_q4/MainActivity.java](Lab2/Q4/app/src/main/java/com/example/lab2_q4/MainActivity.java)

Snippet:

```java
if (!url.startsWith("http://") && !url.startsWith("https://")) {
    url = "https://" + url;
}
Intent intent = new Intent(Intent.ACTION_VIEW);
intent.setData(Uri.parse(url));
startActivity(intent);
```

### Toast and Custom Toast - `#toast` `#custom-toast`

What it does:

- Quick user feedback.

Where used:

- [Lab2/Q1/app/src/main/java/com/example/lab2_q1/MainActivity.java](Lab2/Q1/app/src/main/java/com/example/lab2_q1/MainActivity.java)
- [Lab4/Q1/app/src/main/java/com/example/lab4_q1/MainActivity.java](Lab4/Q1/app/src/main/java/com/example/lab4_q1/MainActivity.java)

Snippet:

```java
Toast.makeText(this,text,Toast.LENGTH_SHORT).show();

Toast toast = new Toast(MainActivity.this);
toast.setDuration(Toast.LENGTH_SHORT);
toast.setView(layout);
toast.show();
```

Snippet (Custom Toast XML - `res/layout/custom_toast.xml`):

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:gravity="center_vertical"
    android:padding="12dp"
    android:background="@android:drawable/toast_frame">

    <ImageView
        android:id="@+id/toastImage"
        android:layout_width="24dp"
        android:layout_height="24dp"
        android:layout_marginEnd="8dp"
        android:contentDescription="Toast icon"
        android:src="@drawable/ic_launcher_foreground" />

    <TextView
        android:id="@+id/toastText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Message"
        android:textColor="@android:color/white"
        android:textStyle="bold" />

</LinearLayout>
```

Snippet (Custom Toast Java):

```java

//Custom Toast - Make xml file - custom_toast
private void showToast(String msg, int img){
LayoutInflater inflater = getLayoutInflater();
View layout = inflater.inflate(R.layout.custom_toast, null);

toastImage = layout.findViewById(R.id.toastImage);
toastText = layout.findViewById(R.id.toastText);
toastText.setText(msg);
toastImage.setImageResource(img);
Toast toast = new Toast(MainActivity.this);
toast.setDuration(Toast.LENGTH_SHORT);
toast.setView(layout);
toast.show();
}
```

### Options Menu - `#menu-options`

What it does:

- Shows activity-level actions in the app bar overflow/options area.

Where used:

- [Lab6/Q1/app/src/main/java/com/example/lab6_q1/MainActivity.java](Lab6/Q1/app/src/main/java/com/example/lab6_q1/MainActivity.java)
- Q3 - sorting searching etc

Snippet:

```java
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    if (item.getItemId() == R.id.menu_about) {
        tvTitle.setText("About Us");
        return true;
    }
    return super.onOptionsItemSelected(item);
}

//Add menu directory then menu resource
 <item
        android:id="@+id/menu_membership"
        android:title="Membership"
        app:showAsAction="never" />

    <item
        android:id="@+id/menu_home"
        android:icon="@drawable/ic_home"
        android:title="Homepage"
        app:showAsAction="ifRoom" />
```

### Context Menu - `#menu-context`

What it does:

- Shows item-level actions on long-press for a selected list item.

Where used:

- [Lab7/Q1/app/src/main/java/com/example/lab7_q1/MainActivity.java](Lab7/Q1/app/src/main/java/com/example/lab7_q1/MainActivity.java)

Snippet (Layout XML - `activity_main.xml`):

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Long press any item"
        android:textStyle="bold"
        android:layout_marginBottom="8dp" />

    <ListView
        android:id="@+id/listView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</LinearLayout>
```

Snippet (Menu XML - `res/menu/context_menu_app.xml`):

```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/menu_edit"
        android:title="Edit" />

    <item
        android:id="@+id/menu_delete"
        android:title="Delete" />
</menu>
```

Snippet (Java - `MainActivity.java`):

```java
public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] items = {"WhatsApp", "Instagram", "YouTube", "Gmail", "Maps"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                items
        );
        listView.setAdapter(adapter);

        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu_app, menu);
        menu.setHeaderTitle("Select Action");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        int position = info.position;

        if (item.getItemId() == R.id.menu_edit) {
            Toast.makeText(this, "Edit " + items[position], Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.menu_delete) {
            Toast.makeText(this, "Delete " + items[position], Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onContextItemSelected(item);
    }
}
```

### Contextual Action Mode - `#actionmode` `#contextual-action-mode`

What it does:

- This mode is a system implementation of ActionMode that displays a contextual action bar at the top of the screen with action items that affect the selected item(s).
- When this mode is active, users can perform an action on multiple items at once (if your app allows it).
- This provides a contextual action bar at the top for multiple item actions.

Snippet (Layout XML):

```xml
<ListView
    android:id="@+id/listView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:choiceMode="multipleModal" />
```

Snippet (Menu XML - `res/menu/cab_menu.xml`):

```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/action_delete"
        android:title="Delete"
        android:icon="@android:drawable/ic_menu_delete"
        android:showAsAction="ifRoom" />

    <item
        android:id="@+id/action_share"
        android:title="Share"
        android:showAsAction="never" />
</menu>
```

Snippet (Java):

```java
ListView listView = findViewById(R.id.listView);

ArrayList<String> items = new ArrayList<>(Arrays.asList(
        "Item 1", "Item 2", "Item 3", "Item 4", "Item 5"
));

ArrayAdapter<String> adapter = new ArrayAdapter<>(
        this,
        android.R.layout.simple_list_item_activated_1,
        items
);
listView.setAdapter(adapter);

listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
    int selectedCount = 0;

    @Override
    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
        if (checked) {
            selectedCount++;
        } else {
            selectedCount--;
        }
        mode.setTitle(selectedCount + " selected");
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        getMenuInflater().inflate(R.menu.cab_menu, menu);
        selectedCount = 0;
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        if (item.getItemId() == R.id.action_delete) {
            SparseBooleanArray checked = listView.getCheckedItemPositions();
            for (int i = items.size() - 1; i >= 0; i--) {
                if (checked.get(i)) {
                    items.remove(i);
                }
            }
            adapter.notifyDataSetChanged();
            mode.finish();
            return true;
        } else if (item.getItemId() == R.id.action_share) {
            Toast.makeText(MainActivity.this, selectedCount + " item(s) selected", Toast.LENGTH_SHORT).show();
            mode.finish();
            return true;
        }
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        selectedCount = 0;
    }
});
```

GENERAL SNIPPET

```java
 tvContent.setCustomSelectionActionModeCallback(new ActionMode.Callback() {

ActionMode.Callback cabCallback = new ActionMode.Callback() {

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cab, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_one) {
            handleActionOne();
            mode.finish();
            return true;

        } else if (id == R.id.action_two) {
            handleActionTwo();
            mode.finish();
            return true;
        }

        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
    }
};
```

### Popup Menu - `#menu-popup`

What it does:

- Shows quick actions anchored to a specific view (like an icon button).

Where used:

- [Lab7/Q2/app/src/main/java/com/example/lab7_q2/MainActivity.java](Lab7/Q2/app/src/main/java/com/example/lab7_q2/MainActivity.java)

Snippet (Layout XML - `activity_main.xml`):

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="16dp">

    <ImageView
        android:id="@+id/mainImage"
        android:layout_width="220dp"
        android:layout_height="220dp"
        android:src="@drawable/image1"
        android:scaleType="centerCrop"
        android:contentDescription="Selected image" />

    <ImageView
        android:id="@+id/menuIcon"
        android:layout_width="56dp"
        android:layout_height="56dp"
        android:layout_marginTop="16dp"
        android:src="@android:drawable/ic_menu_more"
        android:contentDescription="Open popup menu" />

</LinearLayout>
```

Snippet (Menu XML - `res/menu/pop_up_menu.xml`):

```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/image1"
        android:title="Image 1" />

    <item
        android:id="@+id/image2"
        android:title="Image 2" />

    <item
        android:id="@+id/image3"
        android:title="Image 3" />
</menu>
```

Snippet (Java - `MainActivity.java`):

```java
public class MainActivity extends AppCompatActivity {

    private ImageView mainImage;
    private ImageView menuIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainImage = findViewById(R.id.mainImage);
        menuIcon = findViewById(R.id.menuIcon);

        menuIcon.setOnClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, menuIcon);
            popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.image1) {
                    mainImage.setImageResource(R.drawable.image1);
                    return true;
                }
                if (item.getItemId() == R.id.image2) {
                    mainImage.setImageResource(R.drawable.image2);
                    return true;
                }
                if (item.getItemId() == R.id.image3) {
                    mainImage.setImageResource(R.drawable.image3);
                    return true;
                }
                return false;
            });

            popupMenu.show();
        });
    }
}
```

### AlertDialog - `#alertdialog`

What it does:

- Modal input prompt and decision UI.

Where used:

- [Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java](Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java)

Snippet:

```java
AlertDialog.Builder builder = new AlertDialog.Builder(this);
builder.setTitle(title);
final EditText input = new EditText(this);
builder.setView(input);
builder.setPositiveButton("OK", (dialog, which) -> callback.onInput(input.getText().toString().trim()));
builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
builder.show();
```

### SpannableString and BackgroundColorSpan - `#spans`

What it does:

- Highlights matched or selected text ranges.

Where used:

- [Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java](Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java)

Snippet:

```java
SpannableString spannableString = new SpannableString(tvContent.getText());
spannableString.setSpan(new BackgroundColorSpan(Color.YELLOW), start, end,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
tvContent.setText(spannableString);
```

### Activity Lifecycle - `#activity-lifecycle`

What it does:

- Defines activity state transitions (`onStart`, `onResume`, etc.).

Where used:

- [Lab2/Q1/app/src/main/java/com/example/lab2_q1/MainActivity.java](Lab2/Q1/app/src/main/java/com/example/lab2_q1/MainActivity.java)

Snippet:

```java
@Override
protected void onStart() {
    super.onStart();
    Toast.makeText(getApplicationContext(), "onStart called", Toast.LENGTH_LONG).show();
}
```

What more you can do:

- Save transient UI state in `onSaveInstanceState`.

## 5) Lab 8 Component-Wise Usage + Links

Note:

- Lab8 `Q4` folder is not present in the current workspace snapshot.
- Q4 is included here as a conceptual exam section: view SQLite table data and use a prebuilt SQLite database.
- Section 5 only includes Lab8 add-ons not already covered in Section 2.

### SQLite Flow (DB + List + Table) - `#sqlite` `#view-table`

What it does:

- Shows full exam flow: create DB, insert data, view list, and show selected row in table format.

How used in Lab 8:

- Q1/Q2/Q3 store data in SQLite.
- Q1/Q3 view records in `ListView`.
- Q3 displays selected record fields in `TableLayout`.

Where used:

- [Lab8/Q1/app/src/main/java/com/example/lab8_q1/MainActivity.java](Lab8/Q1/app/src/main/java/com/example/lab8_q1/MainActivity.java)
- [Lab8/Q1/app/src/main/java/com/example/lab8_q1/DatabaseHelper.java](Lab8/Q1/app/src/main/java/com/example/lab8_q1/DatabaseHelper.java)
- [Lab8/Q3/app/src/main/java/com/example/lab8_3/MainActivity.java](Lab8/Q3/app/src/main/java/com/example/lab8_3/MainActivity.java)
- [Lab8/Q3/app/src/main/java/com/example/lab8_3/DatabaseHelper.java](Lab8/Q3/app/src/main/java/com/example/lab8_3/DatabaseHelper.java)

Snippet:

java

Copy

```java
public class DatabaseHelper extends SQLiteOpenHelper {    public DatabaseHelper(Context context) {        super(context, "MovieReviewDB", null, 1);    }    @Override    public void onCreate(SQLiteDatabase db) {        db.execSQL("CREATE TABLE movies (id INTEGER PRIMARY KEY AUTOINCREMENT, movie_name TEXT, movie_year TEXT, movie_rating INTEGER)");    }    @Override    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {        db.execSQL("DROP TABLE IF EXISTS movies");        onCreate(db);    }    public long insertMovie(String name, String year, int rating) {        SQLiteDatabase db = getWritableDatabase();        ContentValues values = new ContentValues();        values.put("movie_name", name);        values.put("movie_year", year);        values.put("movie_rating", rating);        return db.insert("movies", null, values);    }    public Cursor getAllMovies() {        return getReadableDatabase().rawQuery("SELECT * FROM movies", null);    }    public Cursor getMovieById(int id) {        return getReadableDatabase().rawQuery("SELECT * FROM movies WHERE id = ?", new String[]{String.valueOf(id)});    }}// Activity usage (ListView + TableLayout)DatabaseHelper db = new DatabaseHelper(this);db.insertMovie("Inception", "2010", 5);ArrayList<String> names = new ArrayList<>();ArrayList<Integer> ids = new ArrayList<>();Cursor all = db.getAllMovies();while (all.moveToNext()) {    ids.add(all.getInt(all.getColumnIndexOrThrow("id")));    names.add(all.getString(all.getColumnIndexOrThrow("movie_name")));}all.close();listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names));listView.setOnItemClickListener((parent, view, position, itemId) -> {    Cursor one = db.getMovieById(ids.get(position));    if (one.moveToFirst()) {        tableLayout.removeAllViews();        TableRow row1 = new TableRow(this);        TextView k1 = new TextView(this);        TextView v1 = new TextView(this);        k1.setText("Year");        v1.setText(one.getString(one.getColumnIndexOrThrow("movie_year")));        row1.addView(k1);        row1.addView(v1);        tableLayout.addView(row1);    }    one.close();});
```

### Q4: View SQLite Table / Use Prebuilt DB - `#sqlite-q4` `#sqlite-prebuilt`

What it does:

- Shows how to read and display rows from a SQLite table.
- Shows how to use a pre-made SQLite database file copied from `assets` into app database folder.

How used in exams:

- Option A: Your app creates DB using `SQLiteOpenHelper` then reads table with `Cursor`.
- Option B: Your app ships with prebuilt `.db` file and opens it with `SQLiteDatabase.openDatabase(...)`.

Where used (related in this workspace):

- [Lab8/Q1/app/src/main/java/com/example/lab8_q1/DatabaseHelper.java](Lab8/Q1/app/src/main/java/com/example/lab8_q1/DatabaseHelper.java)
- [Lab8/Q2/app/src/main/java/com/example/lab8_q2/DatabaseHelper.java](Lab8/Q2/app/src/main/java/com/example/lab8_q2/DatabaseHelper.java)
- [Lab8/Q3/app/src/main/java/com/example/lab8_3/DatabaseHelper.java](Lab8/Q3/app/src/main/java/com/example/lab8_3/DatabaseHelper.java)

Snippet (prebuilt DB + view table rows):

```java
private static final String DB_NAME = "college.db";

// 🔹 Step 1: Copy DB from assets → internal storage (if not exists)
private SQLiteDatabase openPrebuiltDb(Context context) throws IOException {

    File dbFile = context.getDatabasePath(DB_NAME);

    // If DB doesn't exist → copy from assets
    if (!dbFile.exists()) {

        dbFile.getParentFile().mkdirs();

        try (
            InputStream in = context.getAssets().open(DB_NAME);
            OutputStream out = new FileOutputStream(dbFile)
        ) {
            byte[] buffer = new byte[4096];
            int len;

            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }

            out.flush();
        }
    }

    // Open database
    return SQLiteDatabase.openDatabase(
            dbFile.getPath(),
            null,
            SQLiteDatabase.OPEN_READWRITE
    );
}


// 🔹 Step 2: Load data into ListView
private void loadStudentsToList(SQLiteDatabase db, ListView listView) {

    ArrayList<String> rows = new ArrayList<>();

    Cursor c = db.rawQuery(
            "SELECT id, name, branch FROM students",
            null
    );

    while (c.moveToNext()) {
        int id = c.getInt(0);
        String name = c.getString(1);
        String branch = c.getString(2);

        rows.add(id + " | " + name + " | " + branch);
    }

    c.close();

    listView.setAdapter(
        new ArrayAdapter<>(
            this,
            android.R.layout.simple_list_item_1,
            rows
        )
    );
}
```

### SQLiteOpenHelper - `#sqliteopenhelper`

What it does:

- Creates local database, tables, and provides CRUD operations.

How used in Lab 8:

- Q1: `tasks` table for task manager CRUD.
- Q2: `grocery_items` table for item + cost.
- Q3: `movies` table for movie name, year, rating.

Where used:

- [Lab8/Q1/app/src/main/java/com/example/lab8_q1/DatabaseHelper.java](Lab8/Q1/app/src/main/java/com/example/lab8_q1/DatabaseHelper.java)
- [Lab8/Q2/app/src/main/java/com/example/lab8_q2/DatabaseHelper.java](Lab8/Q2/app/src/main/java/com/example/lab8_q2/DatabaseHelper.java)
- [Lab8/Q3/app/src/main/java/com/example/lab8_3/DatabaseHelper.java](Lab8/Q3/app/src/main/java/com/example/lab8_3/DatabaseHelper.java)

Refer DatabaseHelper.md

### SharedPreferences - `#sharedpreferences`

What it does:

- Stores small key-value app data locally (no database needed).

How used in Lab 8:

- Q5 stores name/email locally on `onPause()` and reloads on app open.

Where used:

- [Lab8/Q5/app/src/main/java/com/example/lab8_q5/MainActivity.java](Lab8/Q5/app/src/main/java/com/example/lab8_q5/MainActivity.java)
- [Lab8/Q5/app/src/main/res/layout/activity_main.xml](Lab8/Q5/app/src/main/res/layout/activity_main.xml)

Snippet:

```java
    SharedPreferences sharedPreferences;
    public static final String PREF_NAME = "MyPrefs";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";

    @Override
    protected void onPause() {
        super.onPause();
        saveData();   // Save when app is closed/minimized
    }

    private void saveData() {
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString(KEY_NAME, etName.getText().toString());
            editor.putString(KEY_EMAIL, etEmail.getText().toString());

            editor.apply(); // or commit()
        }

    private void loadData() {
        String name = sharedPreferences.getString(KEY_NAME, "");
        String email = sharedPreferences.getString(KEY_EMAIL, "");

        etName.setText(name);
        etEmail.setText(email);
    }
```

### End-to-end example reference

- Layout + navigation combo:
  [Lab2/Q3/app/src/main/res/layout/activity_linear.xml](Lab2/Q3/app/src/main/res/layout/activity_linear.xml)
  [Lab2/Q3/app/src/main/res/layout/activity_relative.xml](Lab2/Q3/app/src/main/res/layout/activity_relative.xml)
  [Lab2/Q3/app/src/main/java/com/example/lab2_q3/MainActivity.java](Lab2/Q3/app/src/main/java/com/example/lab2_q3/MainActivity.java)

```java
Button btn = findViewById(R.id.btnOpenRelative);
btn.setOnClickListener(v -> {
    Intent intent = new Intent(MainActivity.this, RelativeActivity.class);
    startActivity(intent);
});
```

## 6) Common Mistakes Checklist (Before Running)

- `findViewById` IDs exactly match XML IDs.
- New activity added in `AndroidManifest.xml`.
- For popup/context/options menu: menu XML IDs match Java `if` branches.
- After `Toast.makeText(...)`, call `.show()`.
- For intent extras, same key names in sender and receiver.
- For spinner defaults, validate `Select ...` before submit.
- For `TimePicker`, handle API level (`getHour/getMinute` vs old methods).

## 8) Quick Path Index (Copy/Paste Friendly)

- `Lab1/Q1/app/src/main/java/com/example/lab1_q1/MainActivity.java`
- `Lab2/Q1/app/src/main/java/com/example/lab2_q1/MainActivity.java`
- `Lab2/Q2/app/src/main/java/com/example/lab3_q2/MainActivity.java`
- `Lab2/Q2/app/src/main/java/com/example/lab3_q2/ResultActivity.java`
- `Lab2/Q3/app/src/main/java/com/example/lab2_q3/MainActivity.java`
- `Lab2/Q3/app/src/main/java/com/example/lab2_q3/RelativeActivity.java`
- `Lab2/Q4/app/src/main/java/com/example/lab2_q4/MainActivity.java`
- `Lab3/Q1/app/src/main/java/com/example/lab3_q1/MainActivity.java`
- `Lab3/Q1/app/src/main/java/com/example/lab3_q1/ViewPagerAdapter.java`
- `Lab3/Ques2/app/src/main/java/com/example/lab3_q2/MainActivity.java`
- `Lab3/Q3/app/src/main/java/com/example/lab3_q3/MainActivity.java`
- `Lab4/Q1/app/src/main/java/com/example/lab4_q1/MainActivity.java`
- `Lab4/Q2/app/src/main/java/com/example/lab4_q2/MainActivity.java`
- `Lab4/Q3/app/src/main/java/com/example/lab4_q3/MainActivity.java`
- `Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java`
- `Lab4/Q4/app/src/main/java/com/example/lab4_q4/OrderSummaryActivity.java`
- `Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java`
- `Lab5/Q1/app/src/main/java/com/example/lab5_q1/PreviewActivity.java`
- `Lab5/Q2/app/src/main/java/com/example/lab5_q2/MainActivity.java`
- `Lab5/Q2/app/src/main/java/com/example/lab5_q2/PlaceAdapter.java`
- `Lab5/Q2/app/src/main/java/com/example/lab5_q2/BookingDetailsActivity.java`
- `Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java`
- `Lab5/Q3/app/src/main/java/com/example/lab5_q3/BookingSummaryActivity.java`
- `Lab6/Q1/app/src/main/java/com/example/lab6_q1/MainActivity.java`
- `Lab7/Q1/app/src/main/java/com/example/lab7_q1/MainActivity.java`
- `Lab7/Q1/app/src/main/java/com/example/lab7_q1/AppAdapter.java`
- `Lab7/Q2/app/src/main/java/com/example/lab7_q2/MainActivity.java`
- `Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java`

---

Last updated from current repo state and lab notes in this workspace.
