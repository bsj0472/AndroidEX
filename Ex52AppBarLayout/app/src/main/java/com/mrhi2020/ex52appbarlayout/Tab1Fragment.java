package com.mrhi2020.ex52appbarlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Tab1Fragment extends Fragment {

    Button btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn= view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SecondActivity 로 이동
                Intent intent= new Intent(getActivity(), SecondActivity.class);
                //getActivity().startActivity(intent);//액티비티의 startActivity()능력 이용하여 화면 전환
                //startActivity(intent);              //프레그먼트의 startActivity()능력 이용하여 화면 전환

                //두 방법의 차이는 startActivityForResult()를 할때 발생
                // 결과를 받는 onActivityResult()메소드를 작성하는 위치가 다름.
                // 액티비티능력을 쓸때는 액티비티에서...프레그먼트의 능력을 사용할때는 프레그먼트에서 작성함...단, 액티비티도 결과를 같이 받음..requestCode를 이용해서 구분처리함.
                //getActivity().startActivityForResult(intent, 10);
                startActivityForResult(intent, 20);
            }
        });
    }


    //액티비티의 결과받는 메소드
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(getActivity(), "결과 받았음.", Toast.LENGTH_SHORT).show();
    }

    //프레그먼트가 화면에 보여질때 발동하는 메소드
    @Override
    public void onResume() {
        super.onResume();
        //액티비티의 액션바의 서브타이틀 변경
        MainActivity ac= (MainActivity)getActivity();
        ac.getSupportActionBar().setSubtitle("TAB1");
    }
}
