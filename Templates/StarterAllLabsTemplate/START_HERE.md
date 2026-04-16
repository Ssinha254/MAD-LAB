## Folder structure

- java/StarterActivity.java
- java/StarterDetailActivity.java
- java/StarterStringAdapter.java
- java/StarterFormData.java
- xml/activity_starter_all_labs.xml
- xml/activity_starter_detail.xml
- xml/row_simple_item.xml
- menu/menu_starter.xml

## Quick start steps

1. Copy Java files to: app/src/main/java/<your-package>/
2. Copy XML files:
   - activity_starter_all_labs.xml -> app/src/main/res/layout/
   - row_simple_item.xml -> app/src/main/res/layout/
3. Copy menu_starter.xml -> app/src/main/res/menu/
4. Rename package from com.example.startertemplate to your package.
5. Add activities in AndroidManifest.xml:
   <activity android:name=".StarterActivity" />
   <activity android:name=".StarterDetailActivity" />
6. Open StarterActivity and remove widgets not needed for your question.

## Included exam-ready actions

- Menu Open Next: demonstrates intent from StarterActivity to StarterDetailActivity.
- Menu Clear Fields: resets common input fields quickly.
- Back button: enabled in both activities using toolbar up navigation.
