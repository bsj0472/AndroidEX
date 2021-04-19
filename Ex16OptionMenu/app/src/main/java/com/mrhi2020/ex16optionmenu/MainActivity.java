package com.mrhi2020.ex16optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //액티비티가 실행되면 자동으로 호출되는 콜백메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //onCreate()메소드가 실행된 후
    //자동으로 OptionMenu 를 만드는 작업을 하는
    //이 콜백메소드가 발동
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // 액션바(제목줄)에 Menu 객체를 만들어 주는 작업
        // xml 언어로 메뉴항목들을 설계하고(option_main.xml)
        // 자바언어의 MenuItem 객체로 만들어서(부풀리다:inflate)
        // Menu에 항목을 추가하는 방법 사용
        //menu.add("aaa");

        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.option_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //OptionMenu 의 항목(MenuItem)을 선택하면
    //자동으로 발동하는 콜백 메소드
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id= item.getItemId();

        switch (id){
            case R.id.menu_search:
                Toast.makeText(this, "SEARCH", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_add:
                Toast.makeText(this,"ADD", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_help:
                Toast.makeText(this, "HELP", Toast.LENGTH_SHORT).show();
                break;
        }



        return super.onOptionsItemSelected(item);
    }
}