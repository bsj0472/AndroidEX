package com.mrhi2020.ex26activity;

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
        //SecondActivity class 실행!
        Intent intent= new Intent(this, SecondActivity.class);
        startActivity(intent);

        //이 액티비티(MainActivity)를 종료
        finish();
    }

    public void clickBtn2(View view) {
        //ThirdActivity 실행하기
        Intent intent= new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}