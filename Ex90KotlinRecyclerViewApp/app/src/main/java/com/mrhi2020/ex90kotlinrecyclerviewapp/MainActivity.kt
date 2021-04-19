package com.mrhi2020.ex90kotlinrecyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //대량의 데이터 property[속성:멤버변수]
    var items= arrayListOf<Item>() //ArrayList<Item>와 동일하게 동작

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //대량의 데이터들 추가 [테스트목적]
        items.add( Item("sam","Hello. Kotlin", R.drawable.newyork) )
        items.add( Item("robin","Nice to meet you", R.drawable.paris) )
        items.add( Item("tom","Have a good day", R.drawable.sydney) )
        items.add( Item("lee","Do you have fun", R.drawable.newyork) )
        items.add( Item("sam","Hello. Kotlin", R.drawable.newyork) )
        items.add( Item("robin","Nice to meet you", R.drawable.paris) )
        items.add( Item("tom","Have a good day", R.drawable.sydney) )
        items.add( Item("lee","Do you have fun", R.drawable.newyork) )

        //리사이클러뷰안에 이미 아답터 프로퍼티(멤버변수)가 있어서 아답터객체를 대입해 주면 됨
        recycler.adapter= MyAdapter(this, items)

        //리사이클러뷰에 레이아웃매니저 붙이기
        recycler.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    //액티비티가 화면에 보여질 때 자동으로 발동하는 콜백 라이프사이클 메소드
    override fun onResume() {
        super.onResume()

        //리사이클러뷰를 갱신하려면 아답터에게 데이터변경을 공지!!!!
        //혹시 adapter가 null이면 에러가 나기에 그냥 문법적으로 실수할 여지가
        //없도록... 특이한 연산자 적용 !! (null이 아닐때 실행해!! - 코드안전성 문법)
        recycler.adapter!!.notifyDataSetChanged()
    }

    //옵션메뉴를 만드는 작업을 하는 콜백메소드
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //MenuInflater를 get하는 작업 필요없이
        //이미 이 액티비티의 멤버변수로 menuInflater객체가 있음
        menuInflater.inflate(R.menu.option, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //옵션메뉴아이템 선택하면 자동으로 발동하는 콜백메소드
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.aa-> Toast.makeText(this, "aa", Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }



}