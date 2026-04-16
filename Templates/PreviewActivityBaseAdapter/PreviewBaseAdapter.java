package com.example.template;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Usage:
 * 1) Attach this adapter to ListView: listView.setAdapter(new PreviewBaseAdapter(...)).
 * 2) Requires row_preview_item.xml with ids: imageViewPreview, textViewPrimary, textViewSecondary.
 * 3) Uses ItemClickHandler callback to send click events to Activity/Fragment.
 * 4) Uses ViewHolder pattern for smoother scrolling.
 */
public class PreviewBaseAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<PreviewItem> items;
    private final LayoutInflater inflater;
    private final ItemClickHandler clickHandler;

    public PreviewBaseAdapter(Context context, ArrayList<PreviewItem> items, ItemClickHandler clickHandler) {
        this.context = context;
        this.items = items;
        this.inflater = LayoutInflater.from(context);
        this.clickHandler = clickHandler;
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

    static class ViewHolder {
        ImageView imageView;
        TextView titleText;
        TextView subtitleText;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_preview_item, parent, false);

            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.imageViewPreview);
            holder.titleText = convertView.findViewById(R.id.textViewPrimary);
            holder.subtitleText = convertView.findViewById(R.id.textViewSecondary);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        PreviewItem item = items.get(position);
        holder.titleText.setText(item.getTitle());
        holder.subtitleText.setText(item.getSubtitle());
        holder.imageView.setImageResource(item.getImageResId());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickHandler != null) {
                    clickHandler.onItemClicked(item, position);
                }
            }
        });

        return convertView;
    }
}
