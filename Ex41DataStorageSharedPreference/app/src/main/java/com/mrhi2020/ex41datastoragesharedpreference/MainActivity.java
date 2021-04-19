package com.mrhi2020.ex41datastoragesharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAge;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName= findViewById(R.id.et_name);
        etAge= findViewById(R.id.et_age);
        tv= findViewById(R.id.tv);
    }

    public void clickSave(View view) {

        //저장할 데이터
        String name= etName.getText().toString();
        int age= 0;
        try{
            age= Integer.parseInt(etAge.getText().toString());
        }catch (Exception e){
            age=0;
        }

        //SharedPreference 로 저장하기
        // Data.xml 파일에 데이터를 저장하기
        //SharedPreference 객체 얻어오기
        SharedPreferences pref= getSharedPreferences("Data", MODE_PRIVATE);

        //저장 작업 시작..
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("name", name);
        editor.putInt("age", age);

        //이미지의 리소스 번호도 저장 가능함
        editor.putInt("imgId", R.drawable.moana01);

        //반드시 작성작업이 완료되었다고 명시해야만 함!!
        editor.commit();

    }

    public void clickLoad(View view) {

        SharedPreferences pref= getSharedPreferences("Data", MODE_PRIVATE);

        String name= pref.getString("name", "");
        int age= pref.getInt("age", 0);

        tv.setText(name+" : " + age);

        //이미지 리소스 ID 얻어오기
        int imgId= pref.getInt("imgId", R.drawable.moana05);

        ImageView iv= findViewById(R.id.iv);
        iv.setImageResource(imgId);
    }
}