package com.hog2020.activityex;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> arr= new ArrayList<>();
    ArrayAdapter adapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        adapter = new ArrayAdapter(this, R.layout.list_item, arr);

        lv.setAdapter(adapter);

    }

    public void clickbtn(View view) {
        Intent intent =new Intent(this,SecondActivity.class);
        startActivityForResult(intent,10);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:
            if(resultCode==RESULT_OK){
                String name =data.getStringExtra("name");
                String nic =data.getStringExtra("nic");
                String title = data.getStringExtra("title");
                String text =data.getStringExtra("text");

                String s= name+"\n"+nic+"\n"+title+"\n"+text;
                arr.add(s);

                Toast.makeText(this, ""+lv.hasFocus(), Toast.LENGTH_SHORT).show();
                //adapter.notifyDataSetChanged();

            }

        }
    }
}