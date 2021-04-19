package com.mrhi2020.ex28activity3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= findViewById(R.id.tv);
    }

    public void clickBtn(View view) {
        //결과(Data)를 받기 위해 SecondActivity 실행하기
        Intent intent= new Intent(this, SecondActivity.class);
        startActivityForResult(intent, 10);
    }

    //startActivityForResult() 로 실행한 Activity 가
    //종료되면 다시 이 액티비티(MainActivity)가 보이게 될 때
    //자동으로 실행되는 콜백 메소드
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:
                //결과가 OK냐? - 결과코드(resultCode)
                if(resultCode==RESULT_OK){
                    //이 메소드의 3번째 파라미터 : Intent data -  돌아온 택배기사님
                    String id= data.getStringExtra("id");
                    String pw= data.getStringExtra("pw");

                    tv.setText(id+"\n"+pw);
                }else{
                    tv.setText("결과가 잘못되었음.");
                }
                break;
        }
    }
}