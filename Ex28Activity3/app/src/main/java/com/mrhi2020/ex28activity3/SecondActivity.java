package com.mrhi2020.ex28activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText etID, etPW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        etID= findViewById(R.id.et_id);
        etPW= findViewById(R.id.et_pw);
    }

    public void clickBtn(View view) {
        // 나에게 왔던 택배기사님에게 데이터들(id,pw)을 넣어서
        // 되돌려 보내기!!
        String id= etID.getText().toString();
        String pw= etPW.getText().toString();

        //나에게 온 택배기사님 소환
        Intent intent= getIntent();
        intent.putExtra("id", id);
        intent.putExtra("pw", pw);

        //결과를 주었다고 명시[이게 결과다!!!]
        setResult(RESULT_OK, intent);

        //이 액티비티를 종료
        finish();
    }
}