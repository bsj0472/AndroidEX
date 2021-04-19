package com.mrhi2020.ex46fragmentpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Page3Fragment extends Fragment {

    ArrayList<String> datas= new ArrayList<>();
    ListView listView;
    ArrayAdapter adapter;

    //프레그먼트가 생성될때 1번 호출되는 메소드
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //데이터 추가 작업
        datas.add(new String("aaa"));
        datas.add(new String("bbb"));
        datas.add(new String("ccc"));
    }

    //프레그먼트 객체가 생성될 때 호출되는 것이 아니라!!!
    //프레그먼트가 화면에 노출되어야 할때 발동함..
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_page3, container, false);

        //대량의 데이터 추가 - 화면에 보일때 마다 실행되어 중복데이터가 추가됨
//        datas.add(new String("aaa"));
//        datas.add(new String("bbb"));
//        datas.add(new String("ccc"));

        return view;
    }

    //onCreateView()메소드가 실행 된 후
    //만들어진 뷰(리턴된 뷰)의 자식뷰들을 참조하는 작업을 위한 콜백메소드
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //만들어진 뷰(view)안에 있는 ListView 참조하기
        listView= view.findViewById(R.id.listview);
        adapter= new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);
    }
}
