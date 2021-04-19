package com.mrhi2020.ex90kotlinrecyclerviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        //id가 btn인 Button에 클릭리스너 설정 [ import kotlinx.android.synthetic.main.activity_intro.* ]
        btn.setOnClickListener( object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent= Intent(this@IntroActivity, MainActivity::class.java)
                startActivity(intent)
            }
        })

    }

    //onclick속성에 지정된 콜백메소드
    fun clickExit(view: View) {
        finish()
    }
}