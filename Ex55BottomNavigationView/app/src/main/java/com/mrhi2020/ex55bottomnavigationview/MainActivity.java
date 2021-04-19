package com.mrhi2020.ex55bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager= getSupportFragmentManager();

        FragmentTransaction tran= fragmentManager.beginTransaction();
        tran.add(R.id.container, new Tab1Fragment());
        //tran.addToBackStack(null);
        tran.commit();


        bnv= findViewById(R.id.bnv);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //탭의 선택에 따라 Fragment를 동적으로 변경
                FragmentTransaction tran= fragmentManager.beginTransaction();
                Fragment fragment=null;
                switch (item.getItemId()){
                    case R.id.bnv_aa:
                        fragment= new Tab1Fragment();
                        break;

                    case R.id.bnv_bb:
                        fragment= new Tab2Fragment();
                        break;

                    case R.id.bnv_cc:
                        fragment= new Tab3Fragment();
                        break;
                }//switch

                //기존 프래그먼트를 없애고 새로운 프래그먼트로 재배치
                tran.replace(R.id.container,fragment);
                //tran.addToBackStack(null);

                tran.commit();//작업완료

                //return true가 아니면 선택은 되지만 실제 BNV의 선택 효과가 이동하지 않음.
                return true;
            }
        });
    }
}