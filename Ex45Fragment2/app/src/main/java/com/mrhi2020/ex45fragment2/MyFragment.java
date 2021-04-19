package com.mrhi2020.ex45fragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_my, container, false);

        //혹시 setArgument 로 전달된 값이 있다면..
        Bundle bundle= getArguments();
        String name= bundle.getString("name");
        int age= bundle.getInt("age", 0);

        Toast.makeText(getActivity(), name+":"+age, Toast.LENGTH_SHORT).show();

        return view;
    }
}
