package com.mrhi2020.ex23spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner= findViewById(R.id.spinner);
        adapter= ArrayAdapter.createFromResource(this, R.array.datas, R.layout.spinner_selected);
        spinner.setAdapter(adapter);

        //드롭다운 되는 아이템들의 View 모양(Layout)을 별도로 지정가능
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        //스피너의 드롭다운된 아이템 하나를 선택하는 것을
        //듣는 리스너 객체 생성 및 추가
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}