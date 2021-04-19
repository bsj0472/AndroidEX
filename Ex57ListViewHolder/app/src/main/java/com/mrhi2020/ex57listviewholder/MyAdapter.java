package com.mrhi2020.ex57listviewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> items;

    public MyAdapter(Context context, ArrayList<String> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //재활용할 뷰[두번째 파라미터]가 없는가?
        if(convertView==null){
            //1. create view
            // listview_item.xml 모양으로 뷰 만들기
            LayoutInflater inflater= LayoutInflater.from(context);
            convertView= inflater.inflate(R.layout.listview_item, parent, false);

            //만들어진 뷰(convertView)안에 있는 뷰들의 참조변수를 tag로 저장하기
            //여러개의 참조변수들을 멤버로 가지는 별도의 객체 생성
            ViewHolder holder= new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        //뷰에 값을 연결 [2. binding view]
        //현재 보여질 번째(첫번째 파라미터 : position)의 요소 얻어오기
        String item= items.get(position);

        //만들어진 ItemView 안에있는 뷰들을 찾아서 참조하기
        // 이 findViewById()작업이 생각보다 상당히 무거움(속도가 느림)
        //TextView tv= convertView.findViewById(R.id.tv);

        //convertView에 저장되어있는 tag 객체 얻어오기
        ViewHolder holder= (ViewHolder)convertView.getTag();
        holder.tv.setText(item);


        return convertView;
    }//getView method..

    //항목 1개의 뷰(ItemView)안에있는 자식뷰들 참조변수를
    //멤버로 가지고 있는 클래스 설계
    class ViewHolder{
        TextView tv;
        //생성자메소드
        public ViewHolder(View itemView){
            //파리미터 itemView : 항목1개의 뷰객체[convertView]
            tv= itemView.findViewById(R.id.tv);
        }
    }

}//MyAdapter class..
