package com.mrhi2020.ex25customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //대량의 데이터를 가진 ArrayList 객체 생성
    ArrayList<Member> members= new ArrayList<Member>();

    ListView listView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //대량의 데이터 추가
        members.add( new Member("전현무","대한민국", R.drawable.flag_korea) );
        members.add( new Member("기용패트리","캐나다", R.drawable.flag_canada) );
        members.add( new Member("타일러","미국", R.drawable.flag_usa) );
        members.add( new Member("알베르토","이탈리아", R.drawable.flag_italy) );
        members.add( new Member("장위안","중국", R.drawable.flag_china) );
        members.add( new Member("전현무","대한민국", R.drawable.flag_korea) );
        members.add( new Member("기용패트리","캐나다", R.drawable.flag_canada) );
        members.add( new Member("타일러","미국", R.drawable.flag_usa) );
        members.add( new Member("알베르토","이탈리아", R.drawable.flag_italy) );
        members.add( new Member("장위안","중국", R.drawable.flag_china) );

        listView= findViewById(R.id.listview);
        //데이터에 맞게 뷰들을 만들어내는 객체 생성
        adapter= new MyAdapter(members, this);
        listView.setAdapter(adapter);

        //리스트뷰의 아이템 클릭 리스너
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Member member= members.get(position);
                Toast.makeText(MainActivity.this, member.name, Toast.LENGTH_SHORT).show();

            }
        });


    }
}