# MAD Midsem Offline Handbook (Labs 1-7)

## Table of Contents

- [MAD Midsem Offline Handbook (Labs 1-7)](#mad-midsem-offline-handbook-labs-1-7)
  - [Table of Contents](#table-of-contents)
  - [1) Component-Wise Handbook](#1-component-wise-handbook)
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
    - [SharedPreferences - `#sharedpreferences`](#sharedpreferences---sharedpreferences)
    - [SQLite Flow (DB + List + Table) - `#sqlite` `#view-table`](#sqlite-flow-db--list--table---sqlite-view-table)
    - [Q4: View SQLite Table / Use Prebuilt DB - `#sqlite-q4` `#sqlite-prebuilt`](#q4-view-sqlite-table--use-prebuilt-db---sqlite-q4-sqlite-prebuilt)
    - [SQLiteOpenHelper - `#sqliteopenhelper`](#sqliteopenhelper---sqliteopenhelper)
  - [6) Common Mistakes Checklist (Before Running)](#6-common-mistakes-checklist-before-running)
  - [8) Quick Path Index (Copy/Paste Friendly)](#8-quick-path-index-copypaste-friendly)

## 1) Component-Wise Handbook

### LinearLayout - `#linearlayout`

- [Lab2/Q3/app/src/main/res/layout/activity_linear.xml](Lab2/Q3/app/src/main/res/layout/activity_linear.xml)
- [Lab5/Q3/app/src/main/res/layout/activity_main.xml](Lab5/Q3/app/src/main/res/layout/activity_main.xml)

```xml
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:padding="20dp">
```

### RelativeLayout - `#relativelayout`

- [Lab2/Q3/app/src/main/res/layout/activity_relative.xml](Lab2/Q3/app/src/main/res/layout/activity_relative.xml)

```xml
<Button
    android:id="@+id/btnActionSecondary"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_below="@id/etInput"
    android:layout_toStartOf="@id/btnActionPrimary" />
```

### ScrollView - `#scrollview`

- [Lab5/Q3/app/src/main/res/layout/activity_main.xml](Lab5/Q3/app/src/main/res/layout/activity_main.xml)
- [Lab6/Q1/app/src/main/res/layout/activity_main.xml](Lab6/Q1/app/src/main/res/layout/activity_main.xml)
- [Lab7/Q3/app/src/main/res/layout/activity_main.xml](Lab7/Q3/app/src/main/res/layout/activity_main.xml)

```xml
<ScrollView
    android:layout_width="match_parent"
    android:layout_height="match_parent">
```

### TextView - `#textview`

- [Lab1/Q1/app/src/main/java/com/example/lab1_q1/MainActivity.java](Lab1/Q1/app/src/main/java/com/example/lab1_q1/MainActivity.java)
- [Lab6/Q1/app/src/main/java/com/example/lab6_q1/MainActivity.java](Lab6/Q1/app/src/main/java/com/example/lab6_q1/MainActivity.java)

```java
btnActionA.setOnClickListener(v -> textViewOutput.setTextColor(Color.RED));
btnActionB.setOnClickListener(v -> textViewOutput.setTextSize(26));
btnActionC.setOnClickListener(v -> textViewOutput.setGravity(Gravity.CENTER));
```

### EditText - `#edittext`

- [Lab2/Q3/app/src/main/res/layout/activity_relative.xml](Lab2/Q3/app/src/main/res/layout/activity_relative.xml)
- [Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java](Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java)

```xml
<EditText
    android:id="@+id/etInputValue"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="Enter vehicle number"
    android:inputType="text" /number />
```

```java
String inputValue = etInputValue.getText().toString().trim();
if (inputValue.isEmpty()) {
    etInputValue.setError("Enter value");
    etInputValue.requestFocus();
    return;
}
```

### Button - `#button`

- [Lab4/Q2/app/src/main/java/com/example/lab4_q2/MainActivity.java](Lab4/Q2/app/src/main/java/com/example/lab4_q2/MainActivity.java)
- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)

Snippet:

```java
btnActionPrimary.setOnClickListener(new View.OnClickListener() {
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
btnAction1.setOnClickListener(listener);
btnAction2.setOnClickListener(listener);
btnAction3.setOnClickListener(listener);
```

### ImageView - `#imageview`

- [Lab4/Q3/app/src/main/java/com/example/lab4_q3/MainActivity.java](Lab4/Q3/app/src/main/java/com/example/lab4_q3/MainActivity.java)
- [Lab7/Q2/app/src/main/java/com/example/lab7_q2/MainActivity.java](Lab7/Q2/app/src/main/java/com/example/lab7_q2/MainActivity.java)

```java
if (item.getItemId() == R.id.menu_item_2) {
    imageViewMain.setImageResource(R.drawable.image2);
    return true;
}
```

```xml
    <ImageView
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:id="@+id/imageViewMenu"
        android:src="@drawable/ic_launcher_foreground"
        />
```

### CheckBox - `#checkbox`

- [Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java](Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java)

```xml
<CheckBox
    android:id="@+id/cbOptionOne"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Option 1" />

<CheckBox
    android:id="@+id/cbOptionTwo"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Option 2" />
```

```java
ArrayList<String> items = new ArrayList<>();
ArrayList<Integer> costs = new ArrayList<>();
int total = 0;

if (cbOptionOne.isChecked()) {
    items.add("Option 1");
    costs.add(100);
    total += 100;
}

if (items.isEmpty()) {
    Toast.makeText(this, "Select at least one item", Toast.LENGTH_SHORT).show();
    return;
}
submitted = true;
setChecked(true/false)
cbOptionOne.setEnabled(true/false);
```

### RadioButton - `#radiobutton`

```xml
<RadioButton
    android:id="@+id/rbOptionOne"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Option 1" />
```

```java
RadioButton rbOptionOne = findViewById(R.id.rbOptionOne);
if (rbOptionOne.isChecked()) {
    Toast.makeText(this, "Option 1 selected", Toast.LENGTH_SHORT).show();
}
```

### RadioGroup - `#radiogroup`

```xml
<RadioGroup
    android:id="@+id/rgOptions"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:orientation="vertical">
    <RadioButton
        android:id="@+id/rbOptionOne"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Option 1" />

    <RadioButton
        android:id="@+id/rbOptionTwo"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Option 2" />
</RadioGroup>
```

```java
RadioGroup rgOptions = findViewById(R.id.rgOptions);
int selectedId = rgOptions.getCheckedRadioButtonId();

if (selectedId != -1) {
    RadioButton selected = findViewById(selectedId);
    String value = selected.getText().toString();
    Toast.makeText(this, "Selected: " + value, Toast.LENGTH_SHORT).show();

    rgOptions.clearCheck();
}
//Auto-listen when user changes selection. Use this if you want instant response on tap.

RadioGroup rgOptions = findViewById(R.id.rgOptions);

rgOptions.setOnCheckedChangeListener((group, checkedId) -> {
if (checkedId != -1) {
RadioButton selected = findViewById(checkedId);
String value = selected.getText().toString();
Toast.makeText(this, "Selected: " + value, Toast.LENGTH_SHORT).show();
}
});
//Individual RadioButton checked listeners
CompoundButton.OnCheckedChangeListener radioListener = (buttonView, isChecked) -> {
if (isChecked) {
Toast.makeText(this, "Selected: " + buttonView.getText(), Toast.LENGTH_SHORT).show();
}
};

rbOptionOne.setOnCheckedChangeListener(radioListener);
rbOptionTwo.setOnCheckedChangeListener(radioListener);

```

### ToggleButton - `#togglebutton`

- [Lab4/Q3/app/src/main/java/com/example/lab4_q3/MainActivity.java](Lab4/Q3/app/src/main/java/com/example/lab4_q3/MainActivity.java)
- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)

```xml
<ToggleButton
    android:id="@+id/toggleState"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:textOn="ON"
    android:textOff="OFF"
    android:checked="false" />
```

```java
toggleState.setOnCheckedChangeListener((buttonView, isChecked) -> {
    checkPremiumBookingRule();
});

toggleState.setOnClickListener(v -> {
    if (toggleState.isChecked()) {
        showToast("Toggle ON", R.drawable.panda);
    } else {
        showToast("Toggle OFF", R.drawable.rat);
    }
});
toggleState.setChecked(true/false)
```

### Switch - `#switch`

A modern two-state on/off control (alternative to `ToggleButton`).

```xml
<Switch
    android:id="@+id/switchState"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Enable Notifications" />
```

```java
Switch switchState = findViewById(R.id.switchState);
switchState.setOnCheckedChangeListener((buttonView, isChecked) -> {
    String msg = isChecked ? "Notifications ON" : "Notifications OFF";
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
});
```

### SeekBar - `#seekbar`

```xml
<TextView
    android:id="@+id/tvValue"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Value: 50" />

<SeekBar
    android:id="@+id/seekBarInput"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:max="100"
    android:progress="50" />
```

```java
SeekBar seekBarInput = findViewById(R.id.seekBarInput);
TextView tvValue = findViewById(R.id.tvValue);

tvValue.setText("Value: " + seekBarInput.getProgress());

seekBarInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (progress < 1) {
                    seekBar.setProgress(1);
        tvValue.setText("Value: " + progress);
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

- A button specialized for zoom in/zoom out actions.

```xml
<ZoomButton
    android:id="@+id/zoomButtonIn"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="+" />
```

```java
ZoomButton zoomButtonIn = findViewById(R.id.zoomButtonIn);
ImageView imageViewPreview = findViewById(R.id.imageViewPreview);

zoomButtonIn.setOnClickListener(v -> {
    imageViewPreview.setScaleX(imageViewPreview.getScaleX() + 0.1f);
    imageViewPreview.setScaleY(imageViewPreview.getScaleY() + 0.1f);
});
```

### Spinner - `#spinner`

- Single-select dropdown list.
- [Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java](Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java)
- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)

```xml
<Spinner
    android:id="@+id/spinnerOptions"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

```java
Spinner spinner = findViewById(R.id.spinnerOptions);

String[] options = {"Select Option", "Option 1", "Option 2", "Option 3"};

ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
        this,
        android.R.layout.simple_spinner_item,
        options
);
spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinner.setAdapter(spinnerAdapter);

// Access selected element anytime (for submit button etc.)
String selectedValue = spinner.getSelectedItem().toString();

// Access selected element when user changes selection
spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(MainActivity.this, "Selected: " + item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
});

private void clearFields() {
    spinner.setSelection(0);
}
```

### ArrayAdapter - `#arrayadapter`

- Bridges simple arrays/lists to UI lists and spinners.

- [Lab3/Ques2/app/src/main/java/com/example/lab3_q2/MainActivity.java](Lab3/Ques2/app/src/main/java/com/example/lab3_q2/MainActivity.java)
- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)
  Custom
  [Lab5/Q2/app/src/main/java/com/example/lab5_q2/PlaceAdapter.java](Lab5/Q2/app/src/main/java/com/example/lab5_q2/PlaceAdapter.java)
- [Lab3/Q1/app/src/main/java/com/example/lab3_q1/ImageAdapter.java](Lab3/Q1/app/src/main/java/com/example/lab3_q1/ImageAdapter.java)

```java
ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
        android.R.layout.simple_list_item_1, sports);
listView.setAdapter(adapter);

//Custom Spinner Adapter

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

### ListView - `#listview`

- [Lab3/Ques2/app/src/main/java/com/example/lab3_q2/MainActivity.java](Lab3/Ques2/app/src/main/java/com/example/lab3_q2/MainActivity.java) - simple
- [Lab7/Q1/app/src/main/res/layout/activity_main.xml](Lab7/Q1/app/src/main/res/layout/activity_main.xml)

```java
listView = findViewById(R.id.listViewItems);

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
ListView listView = findViewById(R.id.listViewItems);

AppAdapter adapter = new AppAdapter(this, appList);

listView.setAdapter(adapter);
```

- In Android ListView, getView() is called only for the items that are currently visible on the screen, plus a few extra for smooth scrolling.
  To click on listView Items

```java
listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        showOptionsDialog(position);
    }
});

 private void showOptionsDialog(int position) {
        String selectedItem = items.get(position);

        String[] options = {"View", "Delete", "Share"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose action for " + selectedItem);

        builder.setItems(options, (dialog, which) -> {
            if (which == 0) {
                Toast.makeText(this, "View: " + selectedItem, Toast.LENGTH_SHORT).show();
            } else if (which == 1) {
                items.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
            } else if (which == 2) {
                Toast.makeText(this, "Share: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", null);
        builder.show();
    }
}
```

### GridView - `#gridview`

- [Lab3/Q1/app/src/main/res/layout/fragment_grid.xml](Lab3/Q1/app/src/main/res/layout/fragment_grid.xml)
- [Lab3/Q1/app/src/main/java/com/example/lab3_q1/ImageAdapter.java](Lab3/Q1/app/src/main/java/com/example/lab3_q1/ImageAdapter.java)

```xml Put GridView in activity_main.xml
<GridView
    android:id="@+id/gridView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:numColumns="3"
    android:horizontalSpacing="10dp"
    android:verticalSpacing="10dp"
    android:padding="10dp"/>

grid_item.xml
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

GridAdapter.java

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

//Connect to Adapter in MainActivity.java
gridView = findViewById(R.id.gridView);

GridAdapter adapter = new GridAdapter(this, items);
gridView.setAdapter(adapter);
```

### TableLayout and TableRow - `#tablelayout` `#tablerow`

- Renders row-column data in table form.

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

- Date selection via inline calendar/spinners.

- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)

```java

  <DatePicker
            android:id="@+id/datePickerInput"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:calendarViewShown="false"
            android:spinnersShown="true"
            android:datePickerMode="spinner"/>


int day = datePickerInput.getDayOfMonth();
int month = datePickerInput.getMonth() + 1;
int year = datePickerInput.getYear();
String date = day + "/" + month + "/" + year;

Calendar calendar = Calendar.getInstance();
int currentYear = calendar.get(Calendar.YEAR);
int currentMonth = calendar.get(Calendar.MONTH);
int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

datePickerInput.updateDate(currentYear, currentMonth, currentDay);

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

- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)

```java

 <TimePicker
        android:id="@+id/timePickerInput"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="16dp" />

timePickerInput.setIs24HourView(true);   // 24h display
// timePickerInput.setIs24HourView(false); // 12h display
timePickerInput.setOnTimeChangedListener((view, hourOfDay, minute) -> {
    checkPremiumBookingRule();
});

int hour, minute;
    if (android.os.Build.VERSION.SDK_INT >= 23) {
        hour = timePickerInput.getHour();
        minute = timePickerInput.getMinute();
    } else {
        hour = timePickerInput.getCurrentHour();
        minute = timePickerInput.getCurrentMinute();
     }

String time = String.format("%02d:%02d", hour, minute);

 //Set Time
int hour = calendar.get(Calendar.HOUR_OF_DAY); // hour in 24 hour system
int minute = calendar.get(Calendar.MINUTE);

if (android.os.Build.VERSION.SDK_INT >= 23) {
    timePickerInput.setHour(hour);
    timePickerInput.setMinute(minute);
    } else {
    timePickerInput.setCurrentHour(hour);
    timePickerInput.setCurrentMinute(minute);
}

//Set Min Max
//You enforce limits manually in listener by comparing selected total minutes.
//If invalid, show toast and reset to nearest allowed value.
final int minMinutes = 9 * 60;   // 09:00
final int maxMinutes = 18 * 60;  // 18:00

timePickerInput.setOnTimeChangedListener((view, h, m) -> {
    int selected = h * 60 + m;


```

### Toolbar - `#toolbar`

- Replaces default action bar; hosts menu actions.

- [Lab7/Q3/app/src/main/res/layout/activity_main.xml](Lab7/Q3/app/src/main/res/layout/activity_main.xml)
- [Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java](Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java)

Snippet:

```java In themes.xml
<style name="Theme.MyApp" parent="Theme.MaterialComponents.DayNight.NoActionBar">
    <!-- your colors -->
</style>

IN MainActivity
Toolbar toolbar = findViewById(R.id.toolbar);
setSupportActionBar(toolbar);
getSupportActionBar().setDisplayHomeAsUpEnabled(true);
Option Menu...

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

- Multi-screen swipeable UI with tab headers.
- [Lab3/Q1/app/src/main/java/com/example/lab3_q1/MainActivity.java](Lab3/Q1/app/src/main/java/com/example/lab3_q1/MainActivity.java)
- [Lab3/Q1/app/src/main/java/com/example/lab3_q1/ViewPagerAdapter.java](Lab3/Q1/app/src/main/java/com/example/lab3_q1/ViewPagerAdapter.java)
- [Lab3/Q3/app/src/main/java/com/example/lab3_q3/NewsPagerAdapter.java](Lab3/Q3/app/src/main/java/com/example/lab3_q3/NewsPagerAdapter.java)

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
//FirstFragment.java
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

- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)
- [Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java](Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java)

```java
// Sender Activity (MainActivity)
Intent intent = new Intent(MainActivity.this, BookingSummaryActivity.class);
intent.putExtra("movie", movie);
intent.putExtra("availableSeats", availableSeats);
intent.putStringArrayListExtra("items", items);
intent.putIntegerArrayListExtra("costs", costs);
startActivity(intent);

// Receiver Activity (BookingSummaryActivity)
Intent receivedIntent = getIntent();
String selectedMovie = receivedIntent.getStringExtra("movie");
int seats = receivedIntent.getIntExtra("availableSeats", 0);
ArrayList<String> items = getIntent().getStringArrayListExtra("items");
ArrayList<Integer> costs = getIntent().getIntegerArrayListExtra("costs");

<activity android:name=".ResultActivity"/>
Manifest
TextView tvFieldOne = findViewById(R.id.tvFieldOne);
TextView tvFieldTwo = findViewById(R.id.tvFieldTwo);
tvFieldOne.setText("Movie: " + selectedMovie);
tvFieldTwo.setText("Available Seats: " + seats);

BACK BUTTON CODE

btnEditEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // go back to MainActivity for editing
            }
        });

btnBackToHome.setOnClickListener(new View.OnClickListener() { // back home
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

- Opens browser for provided URL.
- [Lab2/Q4/app/src/main/java/com/example/lab2_q4/MainActivity.java](Lab2/Q4/app/src/main/java/com/example/lab2_q4/MainActivity.java)

```java
if (!url.startsWith("http://") && !url.startsWith("https://")) {
    url = "https://" + url;
}
Intent intent = new Intent(Intent.ACTION_VIEW);
intent.setData(Uri.parse(url));
startActivity(intent);
```

### Toast and Custom Toast - `#toast` `#custom-toast`

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

Custom Toast XML - `res/layout/custom_toast.xml`):

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

Custom Toast Java:

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

- Shows activity-level actions in the app bar overflow/options area.

- [Lab6/Q1/app/src/main/java/com/example/lab6_q1/MainActivity.java](Lab6/Q1/app/src/main/java/com/example/lab6_q1/MainActivity.java)
- Q3 - sorting searching etc

```java
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    if (item.getItemId() == R.id.menu_about) {
        tvHeading.setText("About Us");
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

- Shows item-level actions on long-press for a selected list item.

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
        android:id="@+id/listViewItems"
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
        android:title="Delete"
        android:showAsAction="ifRoom" />

    <item
        android:id="@+id/action_share"
        android:title="Share"
        android:showAsAction="never"  />
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

        listView = findViewById(R.id.listViewItems);

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

- This mode is a system implementation of ActionMode that displays a contextual action bar at the top of the screen with action items that affect the selected item(s).
- When this mode is active, users can perform an action on multiple items at once (if your app allows it).
- This provides a contextual action bar at the top for multiple item actions.

Snippet (Layout XML):

```xml
<ListView
    android:id="@+id/listViewItems"
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
ListView listView = findViewById(R.id.listViewItems);

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
        android:id="@+id/imageViewMain"
        android:layout_width="220dp"
        android:layout_height="220dp"
        android:src="@drawable/image1"
        android:scaleType="centerCrop"
        android:contentDescription="Selected image" />

    <ImageView
        android:id="@+id/imageViewMenu"
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
        android:id="@+id/menu_item_1"
        android:title="Image 1" />

    <item
        android:id="@+id/menu_item_2"
        android:title="Image 2" />

    <item
        android:id="@+id/menu_item_3"
        android:title="Image 3" />
</menu>
```

Snippet (Java - `MainActivity.java`):

```java
public class MainActivity extends AppCompatActivity {

    private ImageView imageViewMain;
    private ImageView imageViewMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewMain = findViewById(R.id.imageViewMain);
        imageViewMenu = findViewById(R.id.imageViewMenu);

        imageViewMenu.setOnClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, imageViewMenu);
            popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.menu_item_1) {
                    imageViewMain.setImageResource(R.drawable.image1);
                    return true;
                }
                if (item.getItemId() == R.id.menu_item_2) {
                    imageViewMain.setImageResource(R.drawable.image2);
                    return true;
                }
                if (item.getItemId() == R.id.menu_item_3) {
                    imageViewMain.setImageResource(R.drawable.image3);
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

- Highlights matched or selected text ranges.
- [Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java](Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java)

Snippet:

```java
SpannableString spannableString = new SpannableString(tvContent.getText());
spannableString.setSpan(new BackgroundColorSpan(Color.YELLOW), start, end,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
tvContent.setText(spannableString);
```

### Activity Lifecycle - `#activity-lifecycle`

- Defines activity state transitions (`onStart`, `onResume`, etc.).
- [Lab2/Q1/app/src/main/java/com/example/lab2_q1/MainActivity.java](Lab2/Q1/app/src/main/java/com/example/lab2_q1/MainActivity.java)

Snippet:

```java
@Override
protected void onStart() {
    super.onStart();
    Toast.makeText(getApplicationContext(), "onStart called", Toast.LENGTH_LONG).show();
}
```

### SharedPreferences - `#sharedpreferences`

- Stores small key-value app data locally (no database needed).
  stores name/email locally on `onPause()` and reloads on app open.

- [Lab8/Q5/app/src/main/java/com/example/lab8_q5/MainActivity.java](Lab8/Q5/app/src/main/java/com/example/lab8_q5/MainActivity.java)
- [Lab8/Q5/app/src/main/res/layout/activity_main.xml](Lab8/Q5/app/src/main/res/layout/activity_main.xml)

```java
    SharedPreferences sharedPreferences;
    public static final String PREF_NAME = "MyPrefs";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
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

### SQLite Flow (DB + List + Table) - `#sqlite` `#view-table`

- Q1/Q2/Q3 store data in SQLite.
- Q1/Q3 view records in `ListView`.
- Q3 displays selected record fields in `TableLayout`.

- [Lab8/Q1/app/src/main/java/com/example/lab8_q1/MainActivity.java](Lab8/Q1/app/src/main/java/com/example/lab8_q1/MainActivity.java)
- [Lab8/Q1/app/src/main/java/com/example/lab8_q1/DatabaseHelper.java](Lab8/Q1/app/src/main/java/com/example/lab8_q1/DatabaseHelper.java)
- [Lab8/Q3/app/src/main/java/com/example/lab8_3/MainActivity.java](Lab8/Q3/app/src/main/java/com/example/lab8_3/MainActivity.java)
- [Lab8/Q3/app/src/main/java/com/example/lab8_3/DatabaseHelper.java](Lab8/Q3/app/src/main/java/com/example/lab8_3/DatabaseHelper.java)

```java
 private DatabaseHelper db;
 private ListView listView;
 private TableLayout tableLayout;

 private final ArrayList<String> names = new ArrayList<>();
 private final ArrayList<Integer> ids = new ArrayList<>();
 private ArrayAdapter<String> adapter;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);

     listView = findViewById(R.id.listViewItems);
     tableLayout = findViewById(R.id.tableLayout);

     db = new DatabaseHelper(this);

     // Sample insert
     db.insertMovie("Inception", "2010", 5);

     loadMovies();

     listView.setOnItemClickListener((parent, view, position, itemId) -> {
         showMovieDetails(ids.get(position));
     });
 }

 private void loadMovies() {
     names.clear();
     ids.clear();

     Cursor c = db.getAllMovies();
     try {
         while (c.moveToNext()) {
             ids.add(c.getInt(c.getColumnIndexOrThrow(DatabaseHelper.COL_ID)));
             names.add(c.getString(c.getColumnIndexOrThrow(DatabaseHelper.COL_NAME)));
         }
     } finally {
         c.close();
     }

     adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
     listView.setAdapter(adapter);
 }

 private void showMovieDetails(int movieId) {
     Cursor c = db.getMovieById(movieId);
     try {
         if (c.moveToFirst()) {
             tableLayout.removeAllViews();

             addRow("Name", c.getString(c.getColumnIndexOrThrow(DatabaseHelper.COL_NAME)));
             addRow("Year", c.getString(c.getColumnIndexOrThrow(DatabaseHelper.COL_YEAR)));
             addRow("Rating", String.valueOf(c.getInt(c.getColumnIndexOrThrow(DatabaseHelper.COL_RATING))));
         }
     } finally {
         c.close();
     }
 }

 private void addRow(String key, String value) {
     TableRow row = new TableRow(this);

     TextView k = new TextView(this);
     TextView v = new TextView(this);

     k.setText(key);
     v.setText(value);

     row.addView(k);
     row.addView(v);

     tableLayout.addView(row);
 }
```

### Q4: View SQLite Table / Use Prebuilt DB - `#sqlite-q4` `#sqlite-prebuilt`

- Shows how to read and display rows from a SQLite table.
- Shows how to use a pre-made SQLite database file copied from `assets` into app database folder.

- Option A: Your app creates DB using `SQLiteOpenHelper` then reads table with `Cursor`.
- Option B: Your app ships with prebuilt `.db` file and opens it with `SQLiteDatabase.openDatabase(...)`.
- [Lab8/Q1/app/src/main/java/com/example/lab8_q1/DatabaseHelper.java](Lab8/Q1/app/src/main/java/com/example/lab8_q1/DatabaseHelper.java)
- [Lab8/Q2/app/src/main/java/com/example/lab8_q2/DatabaseHelper.java](Lab8/Q2/app/src/main/java/com/example/lab8_q2/DatabaseHelper.java)
- [Lab8/Q3/app/src/main/java/com/example/lab8_3/DatabaseHelper.java](Lab8/Q3/app/src/main/java/com/example/lab8_3/DatabaseHelper.java)

```java
private static final String DB_NAME = "college.db";

//  Step 1: Copy DB from asset internal storage (if not exists)
private SQLiteDatabase openPrebuiltDb(Context context) throws IOException {

    File dbFile = context.getDatabasePath(DB_NAME);


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


//  Step 2: Load data into ListView
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

- [Lab8/Q1/app/src/main/java/com/example/lab8_q1/DatabaseHelper.java](Lab8/Q1/app/src/main/java/com/example/lab8_q1/DatabaseHelper.java)
- [Lab8/Q2/app/src/main/java/com/example/lab8_q2/DatabaseHelper.java](Lab8/Q2/app/src/main/java/com/example/lab8_q2/DatabaseHelper.java)
- [Lab8/Q3/app/src/main/java/com/example/lab8_3/DatabaseHelper.java](Lab8/Q3/app/src/main/java/com/example/lab8_3/DatabaseHelper.java)

Refer DatabaseHelper.md

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
