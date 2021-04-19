package com.mrhi2020.ex27activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // 이 액티비티(SecondActivity)를 실행시켜 준
        // 택배기사 객체 참조하기
        Intent intent= getIntent();
        // 택배기사가 가지고 온 추가(Extra)데이터 받기
        String name= intent.getStringExtra("name");
        int age= intent.getIntExtra("age", 0);

        getSupportActionBar().setTitle(name);

        tv= findViewById(R.id.tv);
        tv.setText("당신의 나이는 : "+age);


    }
}