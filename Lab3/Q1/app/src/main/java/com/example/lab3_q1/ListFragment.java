
package com.example.lab3_q1;

import static java.security.AccessController.getContext;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {

    public ListFragment() {
        super(R.layout.fragment_list);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ListView listView = view.findViewById(R.id.listView);

        String[] items = {"Apple", "Banana", "Mango", "Orange"};

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(getContext(),
                        android.R.layout.simple_list_item_1,
                        items);

        listView.setAdapter(adapter);
    }
}

