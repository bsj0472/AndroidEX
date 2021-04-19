package com.mrhi2020.ex90kotlinrecyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        //넘어온 Intent 객체가 이미 이 액티비티의 property로 존재함
        val title= intent.getStringExtra("title")
        val msg= intent.getStringExtra("msg")
        val img= intent.getIntExtra("img", R.drawable.koala)

        //제목줄에 title 표시
        supportActionBar!!.title= title

        //xml의 id를 멤버변수인양
        tv.text= msg
        Glide.with(this).load(img).into(iv)

        //업버튼 보이기
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    //업 버튼 클릭하였을때 '뒤로가기' 물리버튼을 누른 것과 같은 효과를 가지도록
    // onBackPressed()라는 콜백메소드를 강제로 호출

    //업 버튼도 옵션메뉴의 일종임
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            android.R.id.home -> onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

}