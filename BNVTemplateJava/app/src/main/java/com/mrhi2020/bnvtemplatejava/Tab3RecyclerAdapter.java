package com.mrhi2020.bnvtemplatejava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Tab3RecyclerAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Tab3RecyclerItem> items;

    public Tab3RecyclerAdapter(Context context, ArrayList<Tab3RecyclerItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.tab3_recycler_item, parent, false);
        VH vh= new VH(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH)holder;
        //값 연결작업..
        Tab3RecyclerItem item= items.get(position);
        ///
        //

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

//        ImageView iv;
//        TextView tvTitle;
//        TextView tvMsg;
//        RatingBar ratingBar;

        public VH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
