package com.mrhi2020.ex57listviewholder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items= new ArrayList<>();
    ListView listView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //대량의 데이터추가
        items.add( new String("aaa")  );
        items.add( new String("bbb")  );
        items.add( new String("ccc")  );
        items.add( new String("ddd")  );
        items.add( new String("aaa")  );
        items.add( new String("bbb")  );
        items.add( new String("ccc")  );
        items.add( new String("ddd")  );
        items.add( new String("aaa")  );
        items.add( new String("bbb")  );
        items.add( new String("ccc")  );
        items.add( new String("ddd")  );

        listView= findViewById(R.id.listview);
        adapter= new MyAdapter(this, items);
        listView.setAdapter(adapter);

        //리스트뷰의 아이템을 클릭하는 것을 듣는 리스너
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //클릭한 항목 요소 얻어오기
                String item= items.get(position);
                Snackbar.make(listView, item, Snackbar.LENGTH_SHORT).show();

            }
        });
    }
}