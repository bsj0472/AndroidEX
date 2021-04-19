package com.mrhi2020.numbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //뷰들 참조변수 - 멤버변수
    EditText et;
    Button btn;
    TextView tv;

    //사용자가 맞춰야할 정답 숫자를 저장할 변수
    int com;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //xml의 뷰객체들을 찾아와서 참조변수에 대입
        et= findViewById(R.id.et);
        btn= findViewById(R.id.btn);
        tv= findViewById(R.id.tv);

        //컴퓨터 정답 값 랜덤하게 대입
        Random rnd= new Random();
        com= rnd.nextInt(501) + 500; //500~1000

        //버튼이 클릭되는 것을 듣는 리스너객체 생성
        View.OnClickListener listener= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //EditText의 글씨(숫자모양)를 얻어오기
                String s= et.getText().toString();

                //문자열(s)을 숫자(int형)으로 변환!!~
                int num= Integer.parseInt(s);

                //변환된 숫자(num)와 정답숫자(com)가 같은지 비교
                if( num>com){
                    tv.setText(num+"보다 작습니다.");
                }else if(num<com){
                    tv.setText(num+"보다 큽니다.");
                }else{
                    tv.setText("축하합니다.\n정답입니다.");
                }
            }
        };

        //버튼에 리스너객체 설정하기!!
        btn.setOnClickListener(listener);


    }
}