package com.example.startertemplate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Simple BaseAdapter starter for list-based questions.
 */
public class StarterStringAdapter extends BaseAdapter {

    private final ArrayList<String> items;
    private final LayoutInflater inflater;

    public StarterStringAdapter(Context context, ArrayList<String> items) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_simple_item, parent, false);
        }
        TextView title = convertView.findViewById(R.id.textViewPrimary);
        title.setText(items.get(position));
        return convertView;
    }
}
