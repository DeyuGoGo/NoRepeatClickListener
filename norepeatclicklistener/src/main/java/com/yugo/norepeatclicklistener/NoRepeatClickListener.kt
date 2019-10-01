package com.yugo.norepeatclicklistener

import android.os.SystemClock
import android.util.Log
import android.view.View
import com.yugo.norepeatclicklistener.NoRepeatClickListenerConfig.DefaultInterval

class NoRepeatClickListener(
    private val onNoRepeatCLick: (View) -> Unit
) : View.OnClickListener {
    var Interval: Int = DefaultInterval
    private var lastTimeClicked: Long = 0
    override fun onClick(v: View) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < Interval) {
            return
        }
        Log.e("Deyu","Go")
        lastTimeClicked = SystemClock.elapsedRealtime()
        onNoRepeatCLick(v)
    }

}