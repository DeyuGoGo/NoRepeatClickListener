package com.deyu.norepeatclicklistener

import android.os.SystemClock
import android.util.Log
import android.view.View
import com.deyu.norepeatclicklistener.NoRepeatClickListenerConfig.DefaultInterval

class NoRepeatClickListener(
    private val onNoRepeatCLick: (View) -> Unit
) : View.OnClickListener {
    var Interval: Long = DefaultInterval
    private var lastTimeClicked: Long = 0
    override fun onClick(v: View) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < Interval) {
            return
        }
        lastTimeClicked = SystemClock.elapsedRealtime()
        onNoRepeatCLick(v)
    }

}