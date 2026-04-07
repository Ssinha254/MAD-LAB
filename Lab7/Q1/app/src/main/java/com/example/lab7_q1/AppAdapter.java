package com.example.lab7_q1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AppAdapter extends BaseAdapter {

    private final Context ctx;
    private final List<AppItem> list;
    public AppAdapter(Context ctx, List<AppItem> list){
        this.ctx = ctx;
        this.list = list;
    }

    @Override
    public int getCount(){
        return list.size();
    }

    @Override
    public Object getItem(int i){
        return list.get(i);
    }

    @Override
    public long getItemId(int i){
        return i;
    }
    @Override
    public View getView(int i , View convertView, ViewGroup parent){
        View v = convertView;
        if (v == null){
            v = LayoutInflater.from(ctx).inflate(R.layout.row_app, parent, false);
        }
        AppItem item = list.get(i);
        ImageView img = v.findViewById(R.id.imgIcon);
        TextView name = v.findViewById(R.id.txtName);
        TextView packageName = v.findViewById(R.id.txtPackage);

        img.setImageDrawable(item.icon);
        name.setText(item.name);
        packageName.setText(item.packageName);
        return v;
    }
}
