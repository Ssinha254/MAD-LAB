package com.example.template;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Usage:
 * 1) Set this as an Activity in AndroidManifest.xml.
 * 2) Keep a ListView with id listViewItems in activity_preview.xml.
 * 3) This Activity implements ItemClickHandler for adapter callbacks.
 */
public class PreviewActivity extends AppCompatActivity implements ItemClickHandler {

    private ListView listView;
    private PreviewBaseAdapter adapter;
    private ArrayList<PreviewItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        listView = findViewById(R.id.listViewItems);

        itemList = MockDataProvider.getPreviewItems();
        adapter = new PreviewBaseAdapter(this, itemList, this);
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(PreviewItem item, int position) {
        Toast.makeText(this, "Clicked: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        // Optional: open DetailActivity here using an Intent.
    }
}
