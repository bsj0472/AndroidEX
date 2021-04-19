package com.mrhi2020.bnvtemplatejava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Tab3Fragment extends Fragment {

    ArrayList<Tab3RecyclerItem> items= new ArrayList<>();
    RecyclerView recyclerView;
    Tab3RecyclerAdapter recyclerAdapter;

    ArrayList<Tab3RecyclerItem> items2= new ArrayList<>();
    RecyclerView recyclerView2;
    Tab3RecyclerAdapter recyclerAdapter2;

    ArrayList<Tab3RecyclerItem> items3= new ArrayList<>();
    RecyclerView recyclerView3;
    Tab3RecyclerAdapter recyclerAdapter3;

    //프레그먼트가 처음 만들어질때..
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadData();//서버에서 데이터 불러오는 작업..
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //여기서 xml의 뷰들에 대한 find 참조.
        recyclerView= view.findViewById(R.id.recycler);
        recyclerAdapter= new Tab3RecyclerAdapter(getActivity(), items);
        recyclerView.setAdapter(recyclerAdapter);

        recyclerView2= view.findViewById(R.id.recycler2);
        recyclerAdapter2= new Tab3RecyclerAdapter(getActivity(), items2);
        recyclerView2.setAdapter(recyclerAdapter2);

        recyclerView3= view.findViewById(R.id.recycler3);
        recyclerAdapter3= new Tab3RecyclerAdapter(getActivity(), items3);
        recyclerView3.setAdapter(recyclerAdapter3);
    }

    //서버에서 데이터를 불러들이는 메소드
    void loadData(){
        items.add(  new Tab3RecyclerItem()  );
        items.add(  new Tab3RecyclerItem()  );
        items.add(  new Tab3RecyclerItem()  );
        items.add(  new Tab3RecyclerItem()  );
        items.add(  new Tab3RecyclerItem()  );
        items.add(  new Tab3RecyclerItem()  );
        items.add(  new Tab3RecyclerItem()  );

        items2.add( new Tab3RecyclerItem() );
        items2.add( new Tab3RecyclerItem() );
        items2.add( new Tab3RecyclerItem() );
        items2.add( new Tab3RecyclerItem() );
        items2.add( new Tab3RecyclerItem() );
        items2.add( new Tab3RecyclerItem() );
        items2.add( new Tab3RecyclerItem() );

        items3.add(new Tab3RecyclerItem());
        items3.add(new Tab3RecyclerItem());
        items3.add(new Tab3RecyclerItem());
        items3.add(new Tab3RecyclerItem());
        items3.add(new Tab3RecyclerItem());
    }
}
