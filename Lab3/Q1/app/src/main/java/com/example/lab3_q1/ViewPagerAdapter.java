package com.example.lab3_q1;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new ListFragment();
            case 1: return new GridFragment();
            case 2: return new TableFragment();
            default: return new ListFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
