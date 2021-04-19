package com.mrhi2020.ex93youtubeplayer;

import android.app.Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VideoPageAdapter extends FragmentPagerAdapter {

    ArrayList<String> videoIds;
    Fragment[] pages;

    public VideoPageAdapter(@NonNull FragmentManager fm, int behavior, ArrayList<String> videoIds) {
        super(fm, behavior);
        this.videoIds = videoIds;

        pages= new Fragment[videoIds.size()];
        for(int i=0; i<pages.length; i++){
            pages[i]= new PageFragment();
        }
    }



    @Override
    public int getCount() {
        return pages.length;
    }

    @NonNull
    @Override
    public androidx.fragment.app.Fragment getItem(int position) {
        return null;
    }
}
