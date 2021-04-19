package com.mrhi2020.ex90kotlinrecyclerviewapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recycler_item.view.*

//코틀린에서 Adapter를 상속받을 때 반드시 <>제네릭 표시 해야 함
class MyAdapter constructor(val context:Context, val items:ArrayList<Item>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var inflater= LayoutInflater.from(context)
        var itemView= inflater.inflate(R.layout.recycler_item, parent, false)
        var holder= VH(itemView)
        return holder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //첫번째 파라미터 : holder를 VH로 형변환
        //VH vh= (VH)holder;
        val vh:VH= holder as VH //코틀린에서 클래스들의 형변환 연산자 as

        val item= items.get(position)
        vh.itemView.tvTitle.setText(item.title)
        vh.itemView.tvMsg.text= item.msg

        Glide.with(context).load(item.img).into(vh.itemView.iv)
    }

    //아이템 1개의 뷰를 저장하는 ViewHolder클래스 - inner class
    inner class VH constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        //이렇게 find하는 작업 필요없음. why? xml의 id가 바로 변수명으로 사용
        //var iv:ImageView= itemView.findViewById(R.id.iv)
        init {
            itemView.setOnClickListener( object : View.OnClickListener{
                override fun onClick(v: View?) {
                    //클릭한 itemView의 위치
                    val item= items.get(layoutPosition)

                    val intent= Intent(context, ItemActivity::class.java)
                    intent.putExtra("title", item.title)
                    intent.putExtra("msg", item.msg)
                    intent.putExtra("img", item.img)

                    context.startActivity(intent)
                }
            })
        }
    }

}