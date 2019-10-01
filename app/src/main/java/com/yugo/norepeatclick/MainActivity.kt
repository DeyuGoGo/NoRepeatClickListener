package com.yugo.norepeatclick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.yugo.norepeatclicklistener.NoRepeatClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        tv_hello.setOnClickListener(NoRepeatClickListener{Toast.makeText(this,"click",Toast.LENGTH_SHORT).show()})
//        or
        tv_hello.setNoRepeatOnClickListener {Toast.makeText(this,"click",Toast.LENGTH_SHORT).show()}
    }
    fun View.setNoRepeatOnClickListener(Click: (View) -> Unit) {
        val noRepeatClickListener = NoRepeatClickListener {
            Click(it)
        }
        setOnClickListener(noRepeatClickListener)
    }
}

