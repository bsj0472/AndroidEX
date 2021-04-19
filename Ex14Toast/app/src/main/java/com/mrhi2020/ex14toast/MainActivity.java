package com.mrhi2020.ex14toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //onClick 속성이 부여된 View 를 클릭하면
    //자동으로 발동하는 콜백메소드
    public void clickBtn(View v){

        String s= "Nice";
        // Toast 객체 만들기!
        Toast t= Toast.makeText(this, R.string.toast, Toast.LENGTH_SHORT);
        //위치 변경 ( 놓여질 위치로 중력을 당기기)
        t.setGravity(Gravity.CENTER, 0, 0);
        // Toast 보이기!
        t.show();
    }

    public void clickBtn2(View v){
        //Custom View Toast만들기
        //Toast객체 만들기
        Toast t= Toast.makeText(this, "", Toast.LENGTH_SHORT);

        //토스트가 보여줄 View를 설정
        //방법 1) Java 언어로 만들기
//        ImageView iv= new ImageView(this);
//        iv.setImageResource(android.R.drawable.ic_lock_silent_mode);
//
//        TextView tv= new TextView(this);
//        tv.setText("음소거");
//
//        LinearLayout layout= new LinearLayout(this);
//        layout.setOrientation(LinearLayout.VERTICAL);
//
//        layout.addView(iv);
//        layout.addView(tv);
//
//        t.setView(layout);

        //방법 2) View 모양을 xml로 설계하여 설정

        //layout폴더 안에 있는 toast.xml 이라는 문서를 읽어서
        //View 객체로 만들어 주는(inflate:부풀리다) 객체(LayoutInflater)를 Context 로 부터 얻어오기
        LayoutInflater inflater= getLayoutInflater();
        LinearLayout layout= (LinearLayout) inflater.inflate(R.layout.toast, null);
        t.setView(layout);

        t.setGravity(Gravity.CENTER, 0, 0);
        t.show();
    }

}