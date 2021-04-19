package com.mrhi2020.ex78httprequestdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.AlertDialog;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class BoardActivity extends AppCompatActivity {

    ArrayList<Item> items= new ArrayList<>();
    RecyclerView recyclerView;
    BoardAdapter adapter;

    SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        recyclerView= findViewById(R.id.recycler);
        adapter= new BoardAdapter(this, items);
        recyclerView.setAdapter(adapter);

        refreshLayout= findViewById(R.id.layout_refresh);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
                refreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //리사이클러뷰가 보여줄 데이터를 서버의 DB에서 읽어오기
        loadData();
    }

    //서버에서 데이터를 읽어오는 기능메소드
    void loadData(){
        //우선 리사이클러뷰가 잘 동작하는지 테스트하기위해.. 가짜데이터 추가해보기
        //items.add( new Item(1, "aaa", "aaaaaa", "2021")  );

        //기존 데이터를 모두 삭제
        items.clear();
        adapter.notifyDataSetChanged();

        //서버에서 DB값을 echo시켜주는 php문서를 실행
        new Thread(){
            @Override
            public void run() {
                String serverUrl="http://mrhi2021.dothome.co.kr/Android/loadDB.php";
//                String serverUrl="http://mrhi2021.dothome.co.kr/Android/loadDBtoJson.php";

                try {
                    URL url= new URL(serverUrl);
                    HttpURLConnection connection= (HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setDoInput(true);
                    connection.setUseCaches(false);

                    InputStream is= connection.getInputStream();
                    InputStreamReader isr= new InputStreamReader(is);
                    BufferedReader reader= new BufferedReader(isr);

                    final StringBuffer buffer= new StringBuffer();
                    String line= reader.readLine();
                    while (line!=null){
                        buffer.append(line+"\n");
                        line= reader.readLine();
                    }

//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            new AlertDialog.Builder(BoardActivity.this).setMessage(buffer.toString()).create().show();
//                        }
//                    });

                    //Android Java에 이미 JSON문자열을 분석해주는 클래스들이 존재함
                    //XmlParser보다 훨씬 간단하게 코딩이 가능함 - 내일 JSON분석 수업 실시시

                   //서버에서 echo된 문자열데이터에서 '@'문자를 기준으로 문자열들을 분리
                    String[] rows=buffer.toString().split("@"); //분리된 문자열들을 배열로 리턴

                    for(String row : rows){
                        //한줄 데이터안에서 각 컬룸(칸)값들을 분리
                        String[] datas= row.split("&");
                        if(datas.length!=4) continue;

                        int no= Integer.parseInt(datas[0]);
                        String name= datas[1];
                        String msg= datas[2];
                        String date= datas[3];

                        //리사이클러뷰에 직접 값들을 넣는 것이 아니라.
                        //리사이클러뷰가 보여주는 값들을 가진 ArrayList에
                        //항목을 추가하고 화면 갱신

                        //리사이클러뷰 갱신
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Item item= new Item(no, name, msg, date);
                                items.add(0, item);
                                adapter.notifyItemInserted(0);
                            }
                        });

                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}