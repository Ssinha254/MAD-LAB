package com.example.lab5_q2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<PlaceModel> {

    Activity context;
    ArrayList<PlaceModel> placeList;

    public PlaceAdapter(Activity context, ArrayList<PlaceModel> placeList) {
        super(context, 0, placeList);
        this.context = context;
        this.placeList = placeList;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false);
        }

        ImageView imgPlace = convertView.findViewById(R.id.imgPlace);
        TextView txtPlaceName = convertView.findViewById(R.id.txtPlaceName);

        PlaceModel currentItem = placeList.get(position);

        imgPlace.setImageResource(currentItem.getImageResId());
        txtPlaceName.setText(currentItem.getPlaceName());

        return convertView;
    }
}
