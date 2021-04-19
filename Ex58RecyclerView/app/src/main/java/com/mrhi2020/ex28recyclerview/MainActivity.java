package com.mrhi2020.ex28recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> items= new ArrayList<>();
    RecyclerView recyclerView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //대량의 데이터 추가작업
        items.add( new Item("sam", "Hello android.")  );
        items.add( new Item("robin", "Nice to meet you.")  );
        items.add( new Item("kim", "Good boy.")  );
        items.add( new Item("park", "안녕하세요.\n처음 뵙겠습니다.")  );
        items.add( new Item("lee", "만나서 반가워요.\n잘 지내봅시다.")  );
        items.add( new Item("sam", "Hello android.")  );
        items.add( new Item("robin", "Nice to meet you.")  );
        items.add( new Item("kim", "Good boy.")  );
        items.add( new Item("park", "안녕하세요.\n처음 뵙겠습니다.")  );
        items.add( new Item("lee", "만나서 반가워요.\n잘 지내봅시다.")  );

        recyclerView= findViewById(R.id.recycler);
        adapter= new MyAdapter(this, items);
        recyclerView.setAdapter(adapter);

        //리사이클러뷰의 아이템을 클릭하는 것을 듣는 리스너는
        //존재하지 않음!!!
        //불편하지만 itemView 마다 클릭리스너를 설정해야 하기에
        //MyAdapter 에서 작업해야만 함.
    }
}