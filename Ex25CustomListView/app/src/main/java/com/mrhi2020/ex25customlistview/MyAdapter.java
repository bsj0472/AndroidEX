package com.mrhi2020.ex25customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter{

    ArrayList<Member> members;
    Context context;

    //생성자 메소드
    public MyAdapter(ArrayList<Member> members, Context context){
        this.members= members;
        this.context= context;
    }

    //이 아답터가 만들 총 뷰의 개수를 리턴(데이터의 개수)
    @Override
    public int getCount() {
        return members.size();
    }

    @Override
    public Object getItem(int position) {
        return members.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //1. 리스트뷰에 보여질 항목(Item) 하나의 View 객체를 생성
        // create View

        // 재활용할 View(두번째 파라미터 converView)가 없는가?
        if( convertView == null ){
            // xml로 View의 모양을 설계하고 이를 객체로 만들어서(부풀리다) 사용
            // listview_item.xml 문서를 읽어와서 View 객체로
            //만들어주는 객체(LayoutInflater) 사용
            LayoutInflater inflater= LayoutInflater.from(context);
            convertView= inflater.inflate(R.layout.listview_item, null);
        }

        //2. 만들어진 View객체 안에.. position 번째에 해당하는
        //데이터를 연결해주는(설정해주는) 작업.
        // bind view
        Member member= members.get(position);

        ImageView iv= convertView.findViewById(R.id.iv);
        TextView tvName= convertView.findViewById(R.id.tv_name);
        TextView tvNation= convertView.findViewById(R.id.tv_nation);

        iv.setImageResource(member.imgId);
        tvName.setText(member.name);
        tvNation.setText(member.nation);

        //3. 값이 설정된 View를 리턴
        return convertView;
    }
}


