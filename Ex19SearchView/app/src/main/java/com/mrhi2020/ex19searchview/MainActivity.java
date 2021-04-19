package com.mrhi2020.ex19searchview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);

        //SearchView 를 가진 MenuItem객체를 얻어와서
        //SearchView 참조를 해야 함.
        MenuItem item= menu.findItem(R.id.menu_search);
        searchView= (SearchView)item.getActionView();

        //힌트 설정하기
        searchView.setQueryHint("input word");

        //소프트키패드의 검색버튼(돋보기모양버튼)을 클릭하는 것을
        //듣는 리스너 추가..(검색차에 글씨변경을 듣는 리스너)
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            //검색버튼(돋보기모양버튼)을 클릭했을 때..
            @Override
            public boolean onQueryTextSubmit(String query) {

                Toast.makeText(MainActivity.this, ""+query, Toast.LENGTH_SHORT).show();

                return false;
            }

            //글씨가 변경될 때 마다 발동하는 메소드
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
}