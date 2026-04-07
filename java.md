# Java Syntax Handbook - ICT 3268

> Java-first reference for MAD Lab exam prep.
> Search in VS Code: Ctrl+F
> Focus: syntax, data types, strings, collections, calendar/date-time, loops, methods, classes, adapters, and other Java building blocks actually used in your lab solutions.

---

## Table of Contents

- [Search Tags](#search-tags)
- [Data Types](#data-types)
- [Variables and Constants](#variables-and-constants)
- [String Basics](#string-basics)
- [String Functions](#string-functions)
- [StringBuilder](#stringbuilder)
- [Arrays](#arrays)
- [ArrayList and List](#arraylist-and-list)
- [Collections.sort and Comparator](#collectionssort-and-comparator)
- [Random](#random)
- [Calendar and Date-Time](#calendar-and-date-time)
- [If Else and Validation](#if-else-and-validation)
- [Switch](#switch)
- [Loops](#loops)
- [Methods and Return Types](#methods-and-return-types)
- [Classes, Objects, and Constructors](#classes-objects-and-constructors)
- [Generics and Adapters](#generics-and-adapters)
- [Intent Extras Data Passing](#intent-extras-data-passing)
- [Lambdas and Anonymous Classes](#lambdas-and-anonymous-classes)
- [Common Java Imports Used Here](#common-java-imports-used-here)
- [Question Referral Map](#question-referral-map)

---

## Search Tags

`#datatypes` `#variables` `#string` `#string-functions` `#stringbuilder` `#arrays` `#arraylist` `#list` `#collections` `#comparator` `#random` `#calendar` `#datetime` `#ifelse` `#switch` `#loops` `#methods` `#return` `#class` `#object` `#constructor` `#generics` `#adapter` `#intent-extras` `#lambda` `#anonymous-class`

---

## Data Types

### Tag: `#datatypes`

What to remember:

- `int` for counts, totals, positions, IDs, hours, minutes.
- `boolean` for flags like selected state, validation state, system app check.
- `String` for text input, labels, URL, date, time.
- `double` for calculator numeric input.
- `ArrayList<String>` and `ArrayList<Integer>` for variable-length grouped data.

Used in:

- [Lab2/Q2/app/src/main/java/com/example/lab3_q2/MainActivity.java](Lab2/Q2/app/src/main/java/com/example/lab3_q2/MainActivity.java)
- [Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java](Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java)
- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)
- [Lab7/Q1/app/src/main/java/com/example/lab7_q1/AppItem.java](Lab7/Q1/app/src/main/java/com/example/lab7_q1/AppItem.java)

Snippet from labs:

```java
ArrayList<String> items = new ArrayList<>();
ArrayList<Integer> costs = new ArrayList<>();
int total = 0;
boolean isSystem = (ai.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
double n1 = Double.parseDouble(num1);
```

Use elsewhere:

```java
int count = 10;
boolean valid = true;
String name = "Shambhavi";
double price = 99.5;
```

---

## Variables and Constants

### Tag: `#variables`

What to remember:

- Variables store values that may change during execution.
- Use clear names: `movie`, `theatre`, `total`, `vehicleNumber`, `currentSearchKeyword`.
- Prefer local variables inside listeners when the value is only needed there.

Used in:

- [Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java](Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java)
- [Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java](Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java)

Snippet from labs:

```java
String vehicleType = spinnerVehicleType.getSelectedItem().toString();
String vehicleNumber = etVehicleNumber.getText().toString().trim();
String rcNumber = etRcNumber.getText().toString().trim();

String keyword = currentSearchKeyword.toLowerCase();
```

Use elsewhere:

```java
final int MAX_COUNT = 50;
String title = "Booking Summary";
boolean submitted = false;
```

---

## String Basics

### Tag: `#string`

What to remember:

- Strings are objects, so compare content using `equals()`, not `==`.
- Use concatenation with `+` for short UI strings.
- Use `trim()` before validation when reading from `EditText`.

Used in:

- [Lab2/Q4/app/src/main/java/com/example/lab2_q4/MainActivity.java](Lab2/Q4/app/src/main/java/com/example/lab2_q4/MainActivity.java)
- [Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java](Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java)
- [Lab5/Q1/app/src/main/java/com/example/lab5_q1/PreviewActivity.java](Lab5/Q1/app/src/main/java/com/example/lab5_q1/PreviewActivity.java)

Snippet from labs:

```java
String url = etUrl.getText().toString().trim();
String vehicleType = spinnerVehicleType.getSelectedItem().toString();

tvVehicleType.setText("Vehicle Type: " + vehicleType);
tvVehicleNumber.setText("Vehicle Number: " + vehicleNumber);
```

Use elsewhere:

```java
String firstName = "Shambhavi";
String full = "Hello, " + firstName;
```

---

## String Functions

### Tag: `#string-functions`

Functions used in the labs:

- `trim()` removes extra spaces.
- `isEmpty()` checks blank input.
- `equals()` checks exact content.
- `toLowerCase()` helps case-insensitive search.
- `contains()` checks if substring exists.
- `startsWith()` checks prefix.
- `endsWith()` checks suffix.
- `split()` breaks a string into an array.
- `indexOf()` finds first match.
- `hashCode()` converts a string combination into an integer value.

Used in:

- [Lab2/Q4/app/src/main/java/com/example/lab2_q4/MainActivity.java](Lab2/Q4/app/src/main/java/com/example/lab2_q4/MainActivity.java)
- [Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java](Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java)
- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)
- [Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java](Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java)

Snippet from labs:

```java
if (url.isEmpty()) {
    Toast.makeText(this, "Please enter a URL", Toast.LENGTH_SHORT).show();
    return;
}

if (!url.startsWith("http://") && !url.startsWith("https://")) {
    url = "https://" + url;
}

if (vehicleType.equals("Select Vehicle Type")) {
    Toast.makeText(MainActivity.this, "Please select vehicle type", Toast.LENGTH_SHORT).show();
    return;
}

if (originalText.toLowerCase().contains(input.toLowerCase())) {
    Toast.makeText(this, "Found: " + input, Toast.LENGTH_SHORT).show();
}

String[] sentences = tvContent.getText().toString().split("\\. ");
int value = Math.abs((movie + theatre + time).hashCode());
```

Use elsewhere:

```java
String name = etName.getText().toString().trim();
if (name.isEmpty()) return;
if (name.equals("Admin")) { }
if (email.endsWith("@gmail.com")) { }
int pos = text.indexOf("java");
```

---

## StringBuilder

### Tag: `#stringbuilder`

What to remember:

- `StringBuilder` is better than repeated `+` when building a large string in loops.
- Used in sorting/rebuilding sentences in Lab 7 Q3.

Used in:

- [Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java](Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java)

Snippet from labs:

```java
StringBuilder sb = new StringBuilder();
for (String s : list) {
    sb.append(s.trim());
    if (!s.endsWith(".")) sb.append(".");
    sb.append(" ");
}
tvContent.setText(sb.toString().trim());
```

Use elsewhere:

```java
StringBuilder sb = new StringBuilder();
sb.append("Name: ").append(name).append("\n");
sb.append("Age: ").append(age);
String result = sb.toString();
```

---

## Arrays

### Tag: `#arrays`

What to remember:

- Arrays are fixed-size collections.
- Common in spinners, image sets, sentence splitting, and simple lists.

Used in:

- [Lab3/Q1/app/src/main/java/com/example/lab3_q1/ImageAdapter.java](Lab3/Q1/app/src/main/java/com/example/lab3_q1/ImageAdapter.java)
- [Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java](Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java)

Snippet from labs:

```java
int[] images;

public int getCount(){
    return images.length;
}

String[] sentences = tvContent.getText().toString().split("\\. ");
```

Use elsewhere:

```java
String[] items = {"Car", "Bike", "Bus"};
int[] marks = {90, 85, 78};
```

---

## ArrayList and List

### Tag: `#arraylist` `#list`

What to remember:

- `ArrayList` is resizable.
- Use it when item count changes dynamically.
- `List<String>` is the interface type; `ArrayList<String>` is the concrete implementation.

Used in:

- [Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java](Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java)
- [Lab4/Q4/app/src/main/java/com/example/lab4_q4/OrderSummaryActivity.java](Lab4/Q4/app/src/main/java/com/example/lab4_q4/OrderSummaryActivity.java)
- [Lab7/Q1/app/src/main/java/com/example/lab7_q1/MainActivity.java](Lab7/Q1/app/src/main/java/com/example/lab7_q1/MainActivity.java)
- [Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java](Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java)

Snippet from labs:

```java
ArrayList<String> items = new ArrayList<>();
ArrayList<Integer> costs = new ArrayList<>();

if (cbPizza.isChecked()) { items.add("Pizza"); costs.add(150); total += 150; }
if (cbBurger.isChecked()) { items.add("Burger"); costs.add(80); total += 80; }

List<String> list = new ArrayList<>(Arrays.asList(sentences));
ArrayList<AppItem> apps = new ArrayList<>();
```

Use elsewhere:

```java
ArrayList<String> names = new ArrayList<>();
names.add("Asha");
names.add("Riya");
String first = names.get(0);
```

---

## Collections.sort and Comparator

### Tag: `#collections` `#comparator`

What to remember:

- `Collections.sort(list)` sorts natural order.
- `Collections.sort(list, comparator)` sorts using custom logic.
- Comparator lambdas are useful for ranking, relevance, or lowercase alphabetical sorting.

Used in:

- [Lab7/Q1/app/src/main/java/com/example/lab7_q1/MainActivity.java](Lab7/Q1/app/src/main/java/com/example/lab7_q1/MainActivity.java)
- [Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java](Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java)

Snippet from labs:

```java
Collections.sort(apps, Comparator.comparing(a -> a.name.toLowerCase()));

Collections.sort(list);

Collections.sort(list, (s1, s2) -> {
    int count1 = countOccurrences(s1.toLowerCase(), keyword);
    int count2 = countOccurrences(s2.toLowerCase(), keyword);
    return Integer.compare(count2, count1);
});
```

Use elsewhere:

```java
Collections.sort(names);
Collections.sort(students, (a, b) -> Integer.compare(b.marks, a.marks));
```

---

## Random

### Tag: `#random`

What to remember:

- Use `Random` when you need generated numbers.
- `nextInt(9000)` gives values from `0` to `8999`.
- Add `1000` to shift to four-digit range.

Used in:

- [Lab5/Q1/app/src/main/java/com/example/lab5_q1/PreviewActivity.java](Lab5/Q1/app/src/main/java/com/example/lab5_q1/PreviewActivity.java)

Snippet from labs:

```java
private String generateSerialNumber() {
    Random random = new Random();
    int number = 1000 + random.nextInt(9000);
    return "VP" + number;
}
```

Use elsewhere:

```java
Random random = new Random();
int otp = 100000 + random.nextInt(900000);
```

---

## Calendar and Date-Time

### Tag: `#calendar` `#datetime`

What to remember:

- `Calendar.getInstance()` gets current system date/time.
- Month is zero-based in `Calendar.MONTH`.
- Time can be formatted using `String.format("%02d:%02d", hour, minute)`.

Used in:

- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)

Snippet from labs:

```java
Calendar calendar = Calendar.getInstance();

int year = calendar.get(Calendar.YEAR);
int month = calendar.get(Calendar.MONTH);
int day = calendar.get(Calendar.DAY_OF_MONTH);

int hour = calendar.get(Calendar.HOUR_OF_DAY);
int minute = calendar.get(Calendar.MINUTE);

String time = String.format("%02d:%02d", hour, minute);
```

Use elsewhere:

```java
Calendar cal = Calendar.getInstance();
int currentYear = cal.get(Calendar.YEAR);
```

---

## If Else and Validation

### Tag: `#ifelse`

What to remember:

- `if` runs a block only when condition is true.
- `else if` checks the next condition when earlier one failed.
- Most lab validation is built using `if`, early `return`, and `Toast` or `setError`.

Used in:

- [Lab2/Q4/app/src/main/java/com/example/lab2_q4/MainActivity.java](Lab2/Q4/app/src/main/java/com/example/lab2_q4/MainActivity.java)
- [Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java](Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java)
- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)
- [Lab7/Q1/app/src/main/java/com/example/lab7_q1/MainActivity.java](Lab7/Q1/app/src/main/java/com/example/lab7_q1/MainActivity.java)

Snippet from labs:

```java
if (vehicleType.equals("Select Vehicle Type")) {
    Toast.makeText(MainActivity.this, "Please select vehicle type", Toast.LENGTH_SHORT).show();
    return;
}

if (vehicleNumber.isEmpty()) {
    etVehicleNumber.setError("Enter vehicle number");
    etVehicleNumber.requestFocus();
    return;
}

if (ticketType.equals("Premium") && !isAfterNoon()) {
    Toast.makeText(MainActivity.this,
            "Premium tickets can be booked only for shows after 12:00 PM",
            Toast.LENGTH_SHORT).show();
    btnBookNow.setEnabled(false);
    return;
} else if (id == R.id.action_open) {
    Intent launch = pm.getLaunchIntentForPackage(selectedApp.packageName);
    if (launch != null) startActivity(launch);
}
```

Use elsewhere:

```java
if (age < 18) {
    status = "Minor";
} else if (age < 60) {
    status = "Adult";
} else {
    status = "Senior";
}
```

---

## Switch

### Tag: `#switch`

What to remember:

- Use `switch` when one variable decides multiple branches.
- Common in adapters, tab mapping, and menu handling.

Used in:

- [Lab3/Q1/app/src/main/java/com/example/lab3_q1/ViewPagerAdapter.java](Lab3/Q1/app/src/main/java/com/example/lab3_q1/ViewPagerAdapter.java)
- [Lab3/Q3/app/src/main/java/com/example/lab3_q3/NewsPagerAdapter.java](Lab3/Q3/app/src/main/java/com/example/lab3_q3/NewsPagerAdapter.java)

Snippet from labs:

```java
@Override
public Fragment createFragment(int position) {
    switch (position) {
        case 0: return new TopStoriesFragment();
        case 1: return new SportsFragment();
        case 2: return new EntertainmentFragment();
        default: return new TopStoriesFragment();
    }
}
```

Use elsewhere:

```java
switch (choice) {
    case 1: result = "Add"; break;
    case 2: result = "Edit"; break;
    default: result = "Unknown";
}
```

---

## Loops

### Tag: `#loops`

What to remember:

- `for` loop for index-based repetition.
- enhanced `for` for item-by-item traversal.
- `while` loop when repetition depends on search progression.

Used in:

- [Lab4/Q4/app/src/main/java/com/example/lab4_q4/OrderSummaryActivity.java](Lab4/Q4/app/src/main/java/com/example/lab4_q4/OrderSummaryActivity.java)
- [Lab7/Q1/app/src/main/java/com/example/lab7_q1/MainActivity.java](Lab7/Q1/app/src/main/java/com/example/lab7_q1/MainActivity.java)
- [Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java](Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java)

Snippet from labs:

```java
for (ApplicationInfo ai : installed) {
    if (ai.packageName.equals(getPackageName())) continue;
}

for (String s : list) {
    sb.append(s.trim());
}

while (index != -1) {
    count++;
    index = text.indexOf(keyword, index + keyword.length());
}
```

Use elsewhere:

```java
for (int i = 0; i < 5; i++) {
    Log.d("TAG", "i = " + i);
}
```

---

## Methods and Return Types

### Tag: `#methods` `#return`

What to remember:

- A method groups repeated logic.
- Return type tells what comes back: `void`, `boolean`, `int`, `String`, `Fragment`.
- Use helper methods for validation, generation, search counting, and UI reset.

Used in:

- [Lab5/Q1/app/src/main/java/com/example/lab5_q1/PreviewActivity.java](Lab5/Q1/app/src/main/java/com/example/lab5_q1/PreviewActivity.java)
- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)
- [Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java](Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java)

Snippet from labs:

```java
private boolean validateInputs(String movie, String theatre) {
    if (movie.equals("Select Movie")) {
        Toast.makeText(this, "Please select a movie", Toast.LENGTH_SHORT).show();
        return false;
    }
    return true;
}

private int getAvailableSeats(String movie, String theatre, String time) {
    int value = Math.abs((movie + theatre + time).hashCode());
    return (value % 50) + 1;
}

private String generateSerialNumber() {
    Random random = new Random();
    int number = 1000 + random.nextInt(9000);
    return "VP" + number;
}
```

Use elsewhere:

```java
private int add(int a, int b) {
    return a + b;
}

private void clearForm() {
    etName.setText("");
}
```

---

## Classes, Objects, and Constructors

### Tag: `#class` `#object` `#constructor`

What to remember:

- A class is a blueprint.
- An object is an instance created from the class.
- A constructor initializes fields when the object is created.

Used in:

- [Lab5/Q2/app/src/main/java/com/example/lab5_q2/PlaceModel.java](Lab5/Q2/app/src/main/java/com/example/lab5_q2/PlaceModel.java)
- [Lab7/Q1/app/src/main/java/com/example/lab7_q1/AppItem.java](Lab7/Q1/app/src/main/java/com/example/lab7_q1/AppItem.java)

Snippet from labs:

```java
public class PlaceModel {
    private String placeName;
    private int imageResId;

    public PlaceModel(String placeName, int imageResId) {
        this.placeName = placeName;
        this.imageResId = imageResId;
    }

    public String getPlaceName() {
        return placeName;
    }
}
```

Another lab snippet:

```java
public class AppItem {
    public String name;
    public String packageName;
    public android.graphics.drawable.Drawable icon;
    public boolean isSystemApp;

    public AppItem(String name, String packageName,
                   android.graphics.drawable.Drawable icon, boolean isSystemApp) {
        this.name = name;
        this.packageName = packageName;
        this.icon = icon;
        this.isSystemApp = isSystemApp;
    }
}
```

Use elsewhere:

```java
Student s1 = new Student("Asha", 91);
String name = s1.getName();
```

---

## Generics and Adapters

### Tag: `#generics` `#adapter`

What to remember:

- Generics specify the type stored in collections and adapters.
- `ArrayAdapter<String>` means adapter holds strings.
- `ArrayAdapter<PlaceModel>` means adapter holds `PlaceModel` objects.
- Custom adapters usually override `getView()` and sometimes `getDropDownView()`.

Used in:

- [Lab5/Q2/app/src/main/java/com/example/lab5_q2/PlaceAdapter.java](Lab5/Q2/app/src/main/java/com/example/lab5_q2/PlaceAdapter.java)
- [Lab3/Q1/app/src/main/java/com/example/lab3_q1/ImageAdapter.java](Lab3/Q1/app/src/main/java/com/example/lab3_q1/ImageAdapter.java)

Snippet from labs:

```java
public class PlaceAdapter extends ArrayAdapter<PlaceModel> {

    Activity context;
    ArrayList<PlaceModel> placeList;

    public PlaceAdapter(Activity context, ArrayList<PlaceModel> placeList) {
        super(context, 0, placeList);
        this.context = context;
        this.placeList = placeList;
    }
}
```

Custom view binding snippet:

```java
private View initView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
        convertView = LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false);
    }

    PlaceModel currentItem = placeList.get(position);
    imgPlace.setImageResource(currentItem.getImageResId());
    txtPlaceName.setText(currentItem.getPlaceName());
    return convertView;
}
```

Use elsewhere:

```java
ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
        android.R.layout.simple_list_item_1, names);
```

---

## Intent Extras Data Passing

### Tag: `#intent-extras`

What to remember:

- Use `putExtra()` for primitive/simple values.
- Use `putStringArrayListExtra()` and `putIntegerArrayListExtra()` for `ArrayList` payloads.
- Retrieve values using `getStringExtra()`, `getIntExtra()`, and related methods.

Used in:

- [Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java](Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java)
- [Lab4/Q4/app/src/main/java/com/example/lab4_q4/OrderSummaryActivity.java](Lab4/Q4/app/src/main/java/com/example/lab4_q4/OrderSummaryActivity.java)
- [Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java](Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java)
- [Lab5/Q1/app/src/main/java/com/example/lab5_q1/PreviewActivity.java](Lab5/Q1/app/src/main/java/com/example/lab5_q1/PreviewActivity.java)
- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)

Snippet from labs:

```java
Intent intent = new Intent(MainActivity.this, BookingSummaryActivity.class);
intent.putExtra("movie", movie);
intent.putExtra("theatre", theatre);
intent.putExtra("date", date);
intent.putExtra("time", time);
intent.putExtra("ticketType", ticketType);
intent.putExtra("availableSeats", availableSeats);
startActivity(intent);

Intent order = new Intent(MainActivity.this, OrderSummaryActivity.class);
order.putStringArrayListExtra("items", items);
order.putIntegerArrayListExtra("costs", costs);
order.putExtra("total", total);
```

Receive pattern from labs:

```java
String movie = getIntent().getStringExtra("movie");
int availableSeats = getIntent().getIntExtra("availableSeats", 0);
ArrayList<String> items = getIntent().getStringArrayListExtra("items");
```

---

## Lambdas and Anonymous Classes

### Tag: `#lambda` `#anonymous-class`

What to remember:

- Lambda: short form for single-method interfaces.
- Anonymous class: older, longer form still common in Android.
- Both are valid; your labs use both.

Used in:

- [Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java](Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java)
- [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)
- [Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java](Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java)
- [Lab5/Q1/app/src/main/java/com/example/lab5_q1/PreviewActivity.java](Lab5/Q1/app/src/main/java/com/example/lab5_q1/PreviewActivity.java)

Lambda snippet from labs:

```java
btnSubmit.setOnClickListener(v -> {
    if (submitted) return;
});

toggleTicketType.setOnCheckedChangeListener((buttonView, isChecked) -> {
    checkPremiumBookingRule();
});
```

Anonymous class snippet from labs:

```java
btnSubmit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String vehicleType = spinnerVehicleType.getSelectedItem().toString();
    }
});
```

When to use:

- Use lambdas for short event handling.
- Use anonymous classes when codebase already follows that style or when you want explicit override blocks.

---

## Common Java Imports Used Here

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
```

Related Android-side types often used together:

```java
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Toast;
```

---

## Question Referral Map

Use this section when you want to know which lab question to open for a syntax topic.

### Strings and validation

- Refer: Lab 2 Q4, Lab 5 Q1, Lab 5 Q3, Lab 7 Q3
- Files:
  [Lab2/Q4/app/src/main/java/com/example/lab2_q4/MainActivity.java](Lab2/Q4/app/src/main/java/com/example/lab2_q4/MainActivity.java)
  [Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java](Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java)
  [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)
  [Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java](Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java)

### ArrayList, grouped data, and loops

- Refer: Lab 4 Q4, Lab 7 Q1, Lab 7 Q3
- Files:
  [Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java](Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java)
  [Lab4/Q4/app/src/main/java/com/example/lab4_q4/OrderSummaryActivity.java](Lab4/Q4/app/src/main/java/com/example/lab4_q4/OrderSummaryActivity.java)
  [Lab7/Q1/app/src/main/java/com/example/lab7_q1/MainActivity.java](Lab7/Q1/app/src/main/java/com/example/lab7_q1/MainActivity.java)
  [Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java](Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java)

### Calendar, date, time, formatting

- Refer: Lab 5 Q3
- Files:
  [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)

### Random number generation

- Refer: Lab 5 Q1
- Files:
  [Lab5/Q1/app/src/main/java/com/example/lab5_q1/PreviewActivity.java](Lab5/Q1/app/src/main/java/com/example/lab5_q1/PreviewActivity.java)

### Constructors, model classes, custom objects

- Refer: Lab 5 Q2, Lab 7 Q1
- Files:
  [Lab5/Q2/app/src/main/java/com/example/lab5_q2/PlaceModel.java](Lab5/Q2/app/src/main/java/com/example/lab5_q2/PlaceModel.java)
  [Lab7/Q1/app/src/main/java/com/example/lab7_q1/AppItem.java](Lab7/Q1/app/src/main/java/com/example/lab7_q1/AppItem.java)

### Switch, adapter classes, fragment mapping

- Refer: Lab 3 Q1, Lab 3 Q3
- Files:
  [Lab3/Q1/app/src/main/java/com/example/lab3_q1/ViewPagerAdapter.java](Lab3/Q1/app/src/main/java/com/example/lab3_q1/ViewPagerAdapter.java)
  [Lab3/Q3/app/src/main/java/com/example/lab3_q3/NewsPagerAdapter.java](Lab3/Q3/app/src/main/java/com/example/lab3_q3/NewsPagerAdapter.java)

### Sorting, comparator, StringBuilder, search relevance

- Refer: Lab 7 Q3
- Files:
  [Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java](Lab7/Q3/app/src/main/java/com/example/lab7_q3/MainActivity.java)

### Intent extras and data transfer between activities

- Refer: Lab 4 Q4, Lab 5 Q1, Lab 5 Q3
- Files:
  [Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java](Lab4/Q4/app/src/main/java/com/example/lab4_q4/MainActivity.java)
  [Lab4/Q4/app/src/main/java/com/example/lab4_q4/OrderSummaryActivity.java](Lab4/Q4/app/src/main/java/com/example/lab4_q4/OrderSummaryActivity.java)
  [Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java](Lab5/Q1/app/src/main/java/com/example/lab5_q1/MainActivity.java)
  [Lab5/Q1/app/src/main/java/com/example/lab5_q1/PreviewActivity.java](Lab5/Q1/app/src/main/java/com/example/lab5_q1/PreviewActivity.java)
  [Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java](Lab5/Q3/app/src/main/java/com/example/lab5_q3/MainActivity.java)

---

_Java syntax reference built from the actual MAD Lab workspace so you can search syntax first, then jump to the lab where it is used._
