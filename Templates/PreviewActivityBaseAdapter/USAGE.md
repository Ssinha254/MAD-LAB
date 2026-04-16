# Preview Activity + BaseAdapter Template Usage

## What is inside this folder

- PreviewActivity.java
- PreviewBaseAdapter.java
- PreviewItem.java
- MockDataProvider.java
- ItemClickHandler.java
- DetailActivity.java

## How to use

1. Copy these Java files into your app package, for example:
   `app/src/main/java/com/example/yourapp/`
2. Update package name from `com.example.template` to your actual package.
3. Create these XML files:
   - `activity_preview.xml` with a ListView id: `listViewItems`
   - `row_preview_item.xml` with ids: `imageViewPreview`, `textViewPrimary`, `textViewSecondary`
   - `activity_detail.xml` with ids: `textViewPrimary`, `textViewSecondary` (if using DetailActivity)
4. Add drawable resources used in MockDataProvider:
   - `ic_android`, `ic_java`, `ic_xml`
5. Register activities in AndroidManifest.xml:
   - `PreviewActivity`
   - `DetailActivity` (optional)

## Typical flow

- PreviewActivity loads list data from MockDataProvider.
- PreviewBaseAdapter maps each PreviewItem to row_preview_item.xml.
- PreviewBaseAdapter sends row click to ItemClickHandler.
- PreviewActivity (implements ItemClickHandler) receives click and handles action.

## ItemClickHandler usage

1. Make Activity/Fragment implement `ItemClickHandler`.
2. Pass `this` into adapter constructor:
   `new PreviewBaseAdapter(this, itemList, this)`
3. Write logic in `onItemClicked(PreviewItem item, int position)`:
   - Show toast
   - Open DetailActivity
   - Update database or UI state

## XML index (generic IDs only)

- activity_preview.xml -> listViewItems
- row_preview_item.xml -> imageViewPreview, textViewPrimary, textViewSecondary
- activity_detail.xml -> textViewPrimary, textViewSecondary

## Optional enhancements

- Replace MockDataProvider with SQLite/Firebase/API data.
- Add filtering/search.
- Use RecyclerView + RecyclerView.Adapter for modern list performance.
