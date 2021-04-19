package com.mrhi2020.ex46fragmentpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    MyAdapter adapter;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager= getSupportFragmentManager();

        pager= findViewById(R.id.pager);
        adapter= new MyAdapter(fragmentManager);
        pager.setAdapter(adapter);
    }
}