# Android XML Component Reference

## Starter Template

Fast start bundle for new questions:

- Templates/StarterAllLabsTemplate/START_HERE.md
- Templates/StarterAllLabsTemplate/xml/activity_starter_all_labs.xml
- Templates/StarterAllLabsTemplate/java/StarterActivity.java

## Index

- 1. LinearLayout
- 2. RelativeLayout
- 3. ScrollView
- 4. TextView
- 5. EditText
- 6. Button
- 7. ImageView
- 8. CheckBox
- 9. RadioGroup + RadioButton
- 10. ToggleButton
- 11. Switch
- 12. SeekBar
- 13. ZoomButton
- 14. Spinner
- 15. ListView
- 16. GridView
- 17. TableLayout + TableRow
- 18. DatePicker
- 19. TimePicker
- 20. Toolbar
- 21. TabLayout + ViewPager2
- 22. Common Menu XML
- 23. Fragment Container

Note: This file uses generic IDs. If you copy snippets, keep IDs from the Generic ID List.

## Generic ID List

Use these IDs as a standard naming bank in your XML files:

- `@+id/layoutRootLinear`
- `@+id/layoutRootRelative`
- `@+id/scrollContainer`
- `@+id/layoutContent`
- `@+id/textViewPrimary`
- `@+id/textViewSecondary`
- `@+id/editTextInput`
- `@+id/buttonActionPrimary`
- `@+id/imageViewPreview`
- `@+id/checkBoxOption`
- `@+id/radioGroupOptions`
- `@+id/radioButtonOption1`
- `@+id/radioButtonOption2`
- `@+id/toggleButtonState`
- `@+id/switchState`
- `@+id/seekBarValue`
- `@+id/zoomButtonIn`
- `@+id/spinnerOptions`
- `@+id/listViewItems`
- `@+id/gridViewItems`
- `@+id/tableLayoutData`
- `@+id/datePickerInput`
- `@+id/timePickerInput`
- `@+id/toolbarMain`
- `@+id/tabLayoutMain`
- `@+id/viewPagerMain`
- `@+id/menuActionPrimary`
- `@+id/menuActionSecondary`
- `@+id/fragmentContainerMain`

## 1) LinearLayout

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:id="@+id/layoutRootLinear"
    android:padding="20dp">

</LinearLayout>
```

## 2) RelativeLayout

```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/layoutRootRelative"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <TextView
        android:id="@+id/textViewPrimary"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Label" />

    <EditText
        android:id="@+id/editTextInput"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/textViewPrimary"
        android:hint="Enter value" />

</RelativeLayout>
```

## 3) ScrollView

```xml
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/scrollContainer"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fillViewport="true">

    <LinearLayout
        android:id="@+id/layoutContent"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="16dp">

    </LinearLayout>

</ScrollView>
```

## 4) TextView

```xml
<TextView
    android:id="@+id/textViewPrimary"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Hello"
    android:textSize="20sp"
    android:textStyle="bold" />
```

## 5) EditText

```xml
<EditText
    android:id="@+id/editTextInput"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="Enter text"
    android:inputType="text" />
```

## 6) Button

```xml
<Button
    android:id="@+id/buttonActionPrimary"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Action" />
```

## 7) ImageView

```xml
<ImageView
    android:id="@+id/imageViewPreview"
    android:layout_width="120dp"
    android:layout_height="120dp"
    android:src="@drawable/ic_launcher_foreground"
    android:contentDescription="Image"
    android:scaleType="centerCrop" />
```

## 8) CheckBox

```xml
<CheckBox
    android:id="@+id/checkBoxOption"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Option" />
```

## 9) RadioGroup + RadioButton

```xml
<RadioGroup
    android:id="@+id/radioGroupOptions"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:orientation="vertical">

    <RadioButton
        android:id="@+id/radioButtonOption1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Option 1" />

    <RadioButton
        android:id="@+id/radioButtonOption2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Option 2" />

</RadioGroup>
```

## 10) ToggleButton

```xml
<ToggleButton
    android:id="@+id/toggleButtonState"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:textOn="ON"
    android:textOff="OFF" />
```

## 11) Switch

```xml
<Switch
    android:id="@+id/switchState"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Enable mode" />
```

## 12) SeekBar

```xml
<SeekBar
    android:id="@+id/seekBarValue"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:max="100"
    android:progress="50" />
```

## 13) ZoomButton

```xml
<ZoomButton
    android:id="@+id/zoomButtonIn"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="+" />
```

## 14) Spinner

```xml
<Spinner
    android:id="@+id/spinnerOptions"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

## 15) ListView

```xml
<ListView
    android:id="@+id/listViewItems"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```

## 16) GridView

```xml
<GridView
    android:id="@+id/gridViewItems"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:numColumns="3"
    android:horizontalSpacing="8dp"
    android:verticalSpacing="8dp" />
```

## 17) TableLayout + TableRow

```xml
<TableLayout
    android:id="@+id/tableLayoutData"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:stretchColumns="1">

    <TableRow>
        <TextView android:text="Field" />
        <TextView android:text="Value" />
    </TableRow>

</TableLayout>
```

## 18) DatePicker

```xml
<DatePicker
    android:id="@+id/datePickerInput"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:calendarViewShown="false"
    android:spinnersShown="true" />
```

## 19) TimePicker

```xml
<TimePicker
    android:id="@+id/timePickerInput"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:is24HourView="true" />
```

## 20) Toolbar

```xml
<androidx.appcompat.widget.Toolbar
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/toolbarMain"
    android:layout_width="match_parent"
    android:layout_height="?attr/actionBarSize"
    android:background="?attr/colorPrimary"
    android:title="My App"
    android:titleTextColor="@android:color/white" />
```

## 21) TabLayout + ViewPager2

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <com.google.android.material.tabs.TabLayout
        android:id="@+id/tabLayoutMain"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:tabIndicatorColor="@android:color/white" />

    <androidx.viewpager2.widget.ViewPager2
        android:id="@+id/viewPagerMain"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</LinearLayout>
```

## 22) Common Menu XML (Options/Context/Popup)

```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/menuActionPrimary"
        android:title="Action 1" />

    <item
        android:id="@+id/menuActionSecondary"
        android:title="Action 2" />
</menu>
```

## 23) Fragment Container (Optional, useful in labs)

```xml
<androidx.fragment.app.FragmentContainerView
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/fragmentContainerMain"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```
