package com.mrhi2020.ex04imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //뷰들 참조변수 - 멤버변수
    ImageView iv;
    Button btnAus, btnBel, btnCan, btnKor;

    int num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //xml의 뷰를 찾아와서 참조변수에 대입
        iv= findViewById(R.id.iv);
        btnAus= findViewById(R.id.btn01);
        btnBel= findViewById(R.id.btn02);
        btnCan= findViewById(R.id.btn03);
        btnKor= findViewById(R.id.btn04);

        //버튼이 클릭되는 것을 듣는 리스너객체를 버튼에 설정
        btnAus.setOnClickListener(listener);
        btnBel.setOnClickListener(listener);
        btnCan.setOnClickListener(listener);
        btnKor.setOnClickListener(listener);

        //ImageView를 클릭하는 것을 듣는 리스너 객체 생성 및 설정
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageResource(R.drawable.flag_australia+num);
                num++;
                if(num>=13) num=0;
            }
        });


    }//onCreate method..

    //버튼이 클릭되는 것을 듣는 리스너 객체 - 멤버변수로.
    View.OnClickListener listener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //이 리스너가 감시하는 버튼이 클릭되면 자동실행
            //이 메소드의 파라미터로 전달된 v는
            //클릭을 한 버튼객체를 참조하고 있음!

            //v가 참조하는 버튼의 id를 얻어와서 구별
            int id= v.getId();
            switch (id){
                case R.id.btn01:
                    iv.setImageResource(R.drawable.flag_australia);
                    break;

                case R.id.btn02:
                    iv.setImageResource(R.drawable.flag_belgium);
                    break;

                case R.id.btn03:
                    iv.setImageResource(R.drawable.flag_canada);
                    break;

                case R.id.btn04:
                    iv.setImageResource(R.drawable.flag_korea);
                    break;
            }


        }
    };

}//MainActivity class..

