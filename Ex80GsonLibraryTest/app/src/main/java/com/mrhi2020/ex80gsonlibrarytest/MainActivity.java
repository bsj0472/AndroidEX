package com.mrhi2020.ex80gsonlibrarytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= findViewById(R.id.tv);
    }

    public void clickBtn(View view) {
        //기본으로 있는  JSONObject 클래스로 파싱하기
        String jsonStr="{'name':'sam', 'age':20}";

        //name, age를 멤버로 가진 Person 객체를 만들어 파싱한 값을 대입
        try {
            JSONObject jsonObject= new JSONObject(jsonStr);
            String name= jsonObject.getString("name");
            int age= jsonObject.getInt("age");

            Person person= new Person(name, age);
            tv.setText(person.name +" , " + person.age);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void clickBtn2(View view) {
        //Gson 라이브러리로 파싱하기
        String jsonStr="{'name':'robin', 'age':25}";

        //Gson은 json 문자열을 곧바로 사용자정의 클래스[Person]으로 분석해줌
        Gson gson= new Gson();
        Person person= gson.fromJson(jsonStr, Person.class);
        tv.setText(person.name +" , " + person.age);
    }

    public void clickBtn3(View view) {
        //객체 ->> json 문자열로 변환
        Person person= new Person("hong", 30);

        Gson gson= new Gson();
        String jsonStr= gson.toJson(person);//Person -> json string
        tv.setText(jsonStr);
    }

    public void clickBtn4(View view) {
        //네크워크에 있는 json문자열 파싱하기 -일단, 퍼미션
        new Thread(){
            @Override
            public void run() {
                String serverUrl="http://mrhi2021.dothome.co.kr/test.json";

                try {
                    URL url= new URL(serverUrl);
                    InputStream is= url.openStream();
                    InputStreamReader isr= new InputStreamReader(is);
                    //여기서 BufferedReader나 반복문으로 문서 끝까지 읽어오는 코드 필요

                    //Gson은 그 작업을 자동으로 해줌
                    Gson gson= new Gson();
                    final Person person= gson.fromJson(isr, Person.class);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText(person.name +" , " +person.age);
                        }
                    });
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void clickBtn5(View view) {
        //JsonArray -->> Person[] 로 변환
        String jsonStr="[{'name':'sam','age':20},{'name':'robin','age':25}]";

        Gson gson= new Gson();
        Person[] people= gson.fromJson(jsonStr, Person[].class);

        StringBuffer buffer= new StringBuffer();
        for (Person p : people){
            buffer.append(p.name+":"+p.age+"\n");
        }

        tv.setText(buffer.toString());
    }
}