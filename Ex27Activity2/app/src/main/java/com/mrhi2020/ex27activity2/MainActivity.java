package com.mrhi2020.ex27activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName= findViewById(R.id.et_name);
        etAge= findViewById(R.id.et_age);

    }

    public void clickBtn(View view) {

        //SecondActivity 로 화면전화하면서 보낼 데이터
        String name= etName.getText().toString();
        int age= Integer.parseInt(etAge.getText().toString());

        //SecondActivity 를 실행시켜 줄 택배기사 객체 생성
        Intent intent= new Intent(this, SecondActivity.class);

        //택배기사에게 데이터를 가지고 가도록..
        intent.putExtra("name", name); //String
        intent.putExtra("age", age);   //int

        startActivity(intent);


    }
}