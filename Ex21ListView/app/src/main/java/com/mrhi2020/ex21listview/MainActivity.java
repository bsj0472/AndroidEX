package com.mrhi2020.ex21listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    //Adapter객체 참조변수
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.listview);

        //리스트뷰에 보여질 항목(item) View객체를
        //만들어낸느 작업을 수행하는 Adapter객체 생성
        adapter= ArrayAdapter.createFromResource(this, R.array.datas, R.layout.list_item);
        listView.setAdapter(adapter);




        //리스트뷰의 항목(Item)을 클릭하는 것을 듣는
        //리스너 객체 생성 및 설정
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //res폴더의 arrays.xml 안에 있는
                //배열을 참조하기..


                // res폴더(창고관리자) 관리자 소환
                Resources res= getResources();

                // res폴더 안에 있는 arrays.xml문서 안에 있는
                //datas라는 이름의 배열 객체 얻어오기
                String[] arr= res.getStringArray(R.array.datas);

                Toast.makeText(MainActivity.this, arr[position], Toast.LENGTH_SHORT).show();
            }
        });


        //아이템 롱~클릭 리스너
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();

                //이 리턴값이 false면 onClick()이 이어서 발동함
                return true;
            }
        });

    }
}