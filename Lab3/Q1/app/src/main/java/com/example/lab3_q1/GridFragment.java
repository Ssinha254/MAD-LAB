package com.example.lab3_q1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

public class GridFragment extends Fragment {

    int[] images = {
            R.drawable.rat,
            R.drawable.tiger,
            R.drawable.zebra,
            R.drawable.panda,
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_grid, container, false);
        GridView gridView = view.findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(getContext(), images));
        return view;
    }
}