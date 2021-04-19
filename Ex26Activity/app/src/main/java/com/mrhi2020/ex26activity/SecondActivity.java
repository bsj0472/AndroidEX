package com.mrhi2020.ex26activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    //이 액티비티가 실행되면 자동으로 실행되는 콜벡메소드
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //제목줄(ActionBar) 관리객체 얻어오기
        ActionBar actionBar= getSupportActionBar();
        actionBar.setTitle("Second 화면");
    }
}
