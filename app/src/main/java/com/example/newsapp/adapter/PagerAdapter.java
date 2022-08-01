package com.example.newsapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.newsapp.ui.HealthFragment;
import com.example.newsapp.ui.HomeFragment;
import com.example.newsapp.ui.ScienceFragment;
import com.example.newsapp.ui.SportsFragment;
import com.example.newsapp.ui.TechnologyFragment;

public class PagerAdapter extends FragmentPagerAdapter {
    int tabcount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new SportsFragment();
            case 2:
                return new ScienceFragment();
            case 3:
                return new TechnologyFragment();
            case 4:
                return new HealthFragment();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }


}
