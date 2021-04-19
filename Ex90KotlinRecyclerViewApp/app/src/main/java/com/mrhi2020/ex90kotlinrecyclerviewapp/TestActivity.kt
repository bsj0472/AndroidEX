package com.mrhi2020.ex90kotlinrecyclerviewapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TestActivity : AppCompatActivity() {

    var tv: TextView? = null
    var btn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val obj= Sample()//자바클래스도 코틀린인양 사용가능

        tv = findViewById(R.id.tv)
        btn = findViewById(R.id.btn)
        btn!!.setOnClickListener(View.OnClickListener {
            Toast.makeText(
                this@TestActivity,
                "asdf",
                Toast.LENGTH_SHORT
            ).show()
        })
    }
}