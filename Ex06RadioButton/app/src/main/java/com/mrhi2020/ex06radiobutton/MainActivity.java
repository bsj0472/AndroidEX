package com.mrhi2020.ex06radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    TextView tv;

    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg= findViewById(R.id.rg);
        tv= findViewById(R.id.tv);
        ratingBar= findViewById(R.id.rating);

        //RadioButton 의 선택이 바뀌는 것을 듣는 리스너를
        //RadioGroup 에 설정하기!!
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb= findViewById(checkedId);
                tv.setText(rb.getText().toString());
            }
        });


        //레이팅바를 점수 변경을 듣는 리스너 생성 및 설정
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tv.setText( rating+"점" );
            }
        });

    }

    public void clickBtn(View v){

        //선택된 RadioButton의 글씨를 얻어오기

        //RadioGroup에게 선택된 RadioButton의 id를 얻어올 수 있음.
        int id= rg.getCheckedRadioButtonId();

        //id를 이용하여 선택된 RadioButton객체를 참조하기
        RadioButton rb= findViewById(id);
        tv.setText(rb.getText().toString());

    }
}