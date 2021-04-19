package com.mrhi2020.ex44fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    MyFragment myFragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= findViewById(R.id.tv);

        //프레그먼트를 관리해주는 관리자객체 소환!!
        fragmentManager= getSupportFragmentManager();
        myFragment= (MyFragment) fragmentManager.findFragmentById(R.id.frag);
    }

    public void clickBtn(View view) {
        //MyFragment의 TextView 글씨 변경하기

        //MyFragment 참조변수를 이용해서
        myFragment.tv.setText("Good!!!");
    }


    //프레그먼트가 보여주는 fragment_my.xml 안에있는
    //버튼의 onClick 속성에 지정된 메소드는 액티비티에서
    //대신 발동함
    public void clickBtn2(View view){
        tv.setText("Hello!!!");
    }
}