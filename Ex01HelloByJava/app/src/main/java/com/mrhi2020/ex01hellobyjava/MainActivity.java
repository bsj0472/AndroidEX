package com.mrhi2020.ex01hellobyjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //화면에 보이는 뷰들의 참조변수는 가급적 멤버변수로...
    TextView tv;
    Button btn;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Java언어 만으로 화면 꾸미기

        //액티비티에 놓여질 수 있는 것은 View클래스를
        //상속받은 클래스들만 가능함.

        //글씨를 보여주는 TextView객체 생성 및 설정
        tv= new TextView(this);
        tv.setText("Hello world!!");

        //액티비티에 View를 붙이기
        //setContentView(tv);

        //버튼역할을 하는 객체 생성 및 설정
        btn= new Button(this);
        btn.setText("버튼");

        //액티비티에 뷰를 붙이기
        //setContentView(btn);

        //액티비티는 한번에 1개의 뷰만 놓여질 수있음.
        //그럼 여러개를 놓으려먼..

        //View들을 여러개 담을 수 있는 ViewGroup객체를
        //1개 만들어서 거기에 모두 붙이고
        //그 ViewGroup 1개를 액티비티에 붙이기.

        //ViewGroup클래스들 중에서 가장 간단한..
        //LinearLayout 이라는 이름의 클래스를 객체로
        //만들어서 사용
        layout= new LinearLayout(this);
        layout.addView(tv);
        layout.addView(btn);

        //액티비티에 ViewGroup 붙이기
        setContentView(layout);

        //버튼이 클릭되는 것을 듣는 리스너객체를 생성하여
        //버튼에 설정해주기..
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Nice to meet you.");
            }
        });

    }
}