package com.mrhi2020.ex08framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout tab1;
    RelativeLayout tab2;
    RelativeLayout tab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab1= findViewById(R.id.tab1);
        tab2= findViewById(R.id.tab2);
        tab3= findViewById(R.id.tab3);
    }

    public void clickBtn(View v){

        tab1.setVisibility(View.GONE);
        tab2.setVisibility(View.GONE);
        tab3.setVisibility(View.GONE);

        int id= v.getId();
        switch (id){
            case R.id.btn01:
                tab1.setVisibility(View.VISIBLE);
                break;

            case R.id.btn02:
                tab2.setVisibility(View.VISIBLE);
                break;

            case R.id.btn03:
                tab3.setVisibility(View.VISIBLE);
                break;
        }

    }
}