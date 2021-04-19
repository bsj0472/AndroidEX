package com.mrhi2020.ex45fragment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //프레그먼트 관리자 소환!!
        fragmentManager= getSupportFragmentManager();

    }

    public void clickBtn(View view) {
        //id가 container 인 녀석에 MyFragment를 추가

        //매니저에게 프레그먼트의 동적작업(추가/삭제/재배치) 시작한다고 명령
        FragmentTransaction ft= fragmentManager.beginTransaction();//작업시작

        myFragment= new MyFragment();

        //액티비티 전환시에 Extra Data 주듯이
        //프레그먼트를 추가할 때 값 전달도 가능함
        Bundle bundle= new Bundle();//데이터 꾸러미
        bundle.putString("name", "sam");
        bundle.putInt("age", 20);

        myFragment.setArguments(bundle);

        ft.add(R.id.container, myFragment);

        //프레그먼트를 액티비티처럼 백스택에 보관하기!
        ft.addToBackStack(null);

        //작업이 끝났다!! - 이 때 모든 코드가 실제 적용됨!!
        ft.commit();

    }
}