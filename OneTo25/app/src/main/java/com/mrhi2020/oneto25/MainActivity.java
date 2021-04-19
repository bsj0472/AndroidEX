package com.mrhi2020.oneto25;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btnRetry;

    //버튼 참조변수 25개짜리 배열참조변수
    Button[] btns= new Button[25];

    //현재 눌러야 할 번호
    int num=1;

    //버튼의 배경이미지 객체 참조변수
    Drawable btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= findViewById(R.id.tv);
        btnRetry= findViewById(R.id.btn_retry);

        ArrayList<Integer> arr= new ArrayList<>();
        for(int i=1; i<26; i++){
            arr.add(i);
        }
        Collections.shuffle(arr);//배열의 요소위치를 섞어주는 기능

        for(int i=0; i<btns.length; i++){
            btns[i]= findViewById(R.id.btn01+i);
            btns[i].setText(arr.get(i)+"");
            btns[i].setTag(arr.get(i));
        }

        //배경 이미지객체(Drawable) 얻어오기
        btnBack= btns[0].getBackground();

    }//onCreate method..

    //xml에서 뷰에 설정한 onClick속성에 값으로 지정한
    //메소드는 그 뷰가 클릭되면 자동으로 실행됨- 콜백메소드
    //절대조건
    //1. 반드시 접근제한자는 public
    //2. 리턴타입은 반드시 void
    //3. 파라미터는 View 타입 1개만 가능
    public void clickBtn(View v){

        //클릭한 버튼(v)의 글씨를 얻어와서
        //현재 눌러야 할 번호(num)와 같은지 비교

        //v의 자료형이 View로 되어 있어서
        //본인이 Button인지 모릅니다.
        Button btn= (Button)v;

        //방법 1.글씨를 얻어오는 방법
//        String s= btn.getText().toString();
//        int n= Integer.parseInt(s);

        //방법 2. 이미지로 되어있을 경우는...
        //tag 라는 특별한 View의 멤버변수를 이용
        String s= btn.getTag().toString();
        int n= Integer.parseInt(s);

        if(n==num){
            btn.setText("OK");
            btn.setTextColor(0xFFFF0000);//ARGB
            //btn.setVisibility(View.INVISIBLE);
            btn.setBackground(null);//배경 그림객체(Drawable) 지우기

            num++;//다음번호로 증가
            tv.setText(num+"");
        }

        //게임종료
        if(num>25){
            tv.setText("STAGE CLEAR~~");

            //리트라이 버튼을 활성화
            btnRetry.setEnabled(true);
        }
    }

    //retry버튼을 클릭했을때 자동으로 실행되는 콜백메소드
    public void clickRetry(View v){

        ArrayList<Integer> arr= new ArrayList<>();
        for(int n=1; n<26; n++){
            arr.add(n);
        }
        Collections.shuffle(arr);

        for(int i=0; i<btns.length; i++){
            btns[i].setText(  arr.get(i)+""  );
            btns[i].setTag(arr.get(i));
            btns[i].setTextColor(0xFF0000FF);//흰색
            //다시 버튼의 배경이미지객체(Drawable)를 설정
            btns[i].setBackground(btnBack);
        }

        num=1;
        tv.setText(num+"");

        btnRetry.setEnabled(false);

    }


}//MainActivity class..
