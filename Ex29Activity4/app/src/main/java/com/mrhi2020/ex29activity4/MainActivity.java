package com.mrhi2020.ex29activity4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickBtn(View view) {
        //SecondActivity.class 라는 이름을 사용하지 않고
        //SecondActivity 를 실행

        //묵시적 인텐트
        Intent intent= new Intent();
//        intent.setAction("aaa");
        intent.setAction("bbb");
        startActivity(intent);


    }
}