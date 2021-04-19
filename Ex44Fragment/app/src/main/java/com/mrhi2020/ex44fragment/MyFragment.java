package com.mrhi2020.ex44fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {

    TextView tv;
    Button btn;
    Button btn2;


    //이 프레그먼트가 보여줄 화면을 만들어서 리턴해주는
    //라이프사이클 콜백메소드 [ 마치 Activity 의 onCreate()메소드 같은 역할]
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //이 프레그먼트가 보여줄 화면(View)를 xml로 작성하면
        // 더 쉽게 화면설계가 가능함!!
        // res/layout/fragment_my.xml 문서를 읽어와서
        //자바의 View 객체로 만들어주는(inflate : 부풀리다)
        //객체[LayoutInflater]에게 뷰 객체를 만들어 달라고 요청!!
        View view= inflater.inflate(R.layout.fragment_my, container, false);

        //만들어진 뷰(LinearLayout) 안에 있는 TextView, Button 참조하기
        tv= view.findViewById(R.id.tv);
        btn= view.findViewById(R.id.btn);

        //버튼 클릭리스너 설정
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("nice");
            }
        });

        btn2= view.findViewById(R.id.btn2);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //MainActivity의 TextView글씨 변경
//                MainActivity ac= (MainActivity)getActivity();
//                ac.tv.setText("Hello!!");
//            }
//        });


        return view;
    }
}
