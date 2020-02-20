package com.deyu.norepeatclick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.deyu.norepeatclicklistener.NoRepeatClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val noRepeatClickListener =
            NoRepeatClickListener { Toast.makeText(this, "click", Toast.LENGTH_SHORT).show() }
        noRepeatClickListener.Interval = 5000 // 設置為五秒
        tv_hello.setOnClickListener(NoRepeatClickListener{Toast.makeText(this,"click hello",Toast.LENGTH_SHORT).show()})
//        or
        tv_hello2.setNoRepeatOnClickListener {Toast.makeText(this,"click hello2",Toast.LENGTH_SHORT).show()}
    }
    fun View.setNoRepeatOnClickListener(Click: (View) -> Unit) {
        NoRepeatClickListener { Click(it) }.let { setOnClickListener(it) }
    }
}

