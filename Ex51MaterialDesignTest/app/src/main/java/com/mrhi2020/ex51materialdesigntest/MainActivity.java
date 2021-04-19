package com.mrhi2020.ex51materialdesigntest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout inputLayout;

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv= findViewById(R.id.iv);
        //이미지뷰에 이미지를 설정해주는 Library [ android팀에서 인수한 외부라이브러리 ]
        // Glide
        //Glide.with(this).load(R.drawable.moana01).into(iv);
        //네트워크 이미지도 아주 쉽게 처리가능함.
        //일단 네트워크 사용 퍼미션을 필요.
        //String imgUrl="https://img4.yna.co.kr/photo/yna/YH/2010/02/01/PYH2010020102450000400_P2.jpg";
        //Glide.with(this).load(imgUrl).into(iv);
        //gif 이미지도 적용 가능함
        Glide.with(this).load(R.drawable.winter).into(iv);





        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //제목줄에 업버튼 아이콘 보이기
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //제목글씨 보이지 않도록.
        actionBar.setDisplayShowTitleEnabled(false);

        inputLayout= findViewById(R.id.tf);
        inputLayout.setDefaultHintTextColor(ColorStateList.valueOf(0xFF0000FF));
        inputLayout.setHelperTextColor(ColorStateList.valueOf(0xFF0000FF));

        inputLayout.setPasswordVisibilityToggleEnabled(true);
        inputLayout.setCounterEnabled(true);
        inputLayout.setCounterMaxLength(20);

        EditText et= inputLayout.getEditText();
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if( s.toString().contains("#")  ){
                    inputLayout.setError("특수문자 사용금지");
                }else{
                    inputLayout.setError(null);
                }

                //if(s.length()==0) inputLayout.clearFocus();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("aaa");
        return super.onCreateOptionsMenu(menu);
    }
}