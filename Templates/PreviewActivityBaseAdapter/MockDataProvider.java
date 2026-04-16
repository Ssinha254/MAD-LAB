package com.example.template;

import java.util.ArrayList;

/**
 * Usage:
 * Replace this with database/API data later.
 * For now it returns dummy data for quick adapter testing.
 */
public class MockDataProvider {

    public static ArrayList<PreviewItem> getPreviewItems() {
        ArrayList<PreviewItem> list = new ArrayList<>();

        list.add(new PreviewItem("Android", "Mobile development", R.drawable.ic_android));
        list.add(new PreviewItem("Java", "Object-oriented language", R.drawable.ic_java));
        list.add(new PreviewItem("XML", "UI layout design", R.drawable.ic_xml));

        return list;
    }
}
