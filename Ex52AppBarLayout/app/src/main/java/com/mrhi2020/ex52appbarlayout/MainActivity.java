package com.mrhi2020.ex52appbarlayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;

    ViewPager pager;
    MyTabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout= findViewById(R.id.layout_tab);
        //탭버튼(Tab객체) 생성 밑 붙이기
//        TabLayout.Tab tab= tabLayout.newTab();
//        tab.setTag("tab1"); //식별자 - id같은 역할
//        tab.setText("TAB1");
//        tabLayout.addTab(tab);
//
//        TabLayout.Tab tab2= tabLayout.newTab().setTag("tab2").setText("TAB2");
//        tabLayout.addTab(tab2);
//
//        tabLayout.addTab(tabLayout.newTab().setTag("tab3").setText("TAB3"));
//        tabLayout.addTab(tabLayout.newTab().setTag("tab3").setText("TAB3"));
//        tabLayout.addTab(tabLayout.newTab().setTag("tab3").setText("TAB3"));
//        tabLayout.addTab(tabLayout.newTab().setTag("tab3").setText("TAB3"));
//        tabLayout.addTab(tabLayout.newTab().setTag("tab3").setText("TAB3"));
//        tabLayout.addTab(tabLayout.newTab().setTag("tab3").setText("TAB3"));

        pager= findViewById(R.id.pager);
        tabAdapter= new MyTabAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        pager.setAdapter(tabAdapter);

        //뷰페이저와 TabLayout 을 연동하기
        //연동을 하면 자동으로 뷰페이저의 페이지 개수만큼
        //Tab버튼이 만들어짐.. 즉, 별도로 추가했던 작업은 무시됨
        tabLayout.setupWithViewPager(pager);


//        TabLayout.Tab tab= tabLayout.getTabAt(0);
//        tab.setIcon(R.drawable.ic_logo);




        //탭버튼 선택 리스너
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                if(tab.getTag().toString().equals("tab1")){
//                    pager.setCurrentItem(0);
//                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //프레그먼트에서 실행한 액티비티의 결과를 받는 메소드
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(this, "액티비티가 결과를 받았습니다.", Toast.LENGTH_SHORT).show();
    }
}