package com.example.liga.ui.home.homeMatches

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import com.example.liga.domain.utils.Constants

open class SwipeHome(context: Context) : OnTouchListener {

    private val swipeDetection: GestureDetector

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        return p1?.let { swipeDetection.onTouchEvent(it) } == true
    }

    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onFling(
            e1: MotionEvent,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            try {
                val diffY = e2.y - e1.y
                val diffX = e2.x - e1.x
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > Constants.SWIPE_DIST
                    ) {
                        if (diffX > 0) {
                            onSwipeRight()
                        } else {
                            onSwipeLeft()
                        }
                    }
                }

            } catch (exception: Exception) {
                exception.printStackTrace()
            }
            return false
        }
    }

    init {
        swipeDetection = GestureDetector(context, GestureListener())
    }

    open fun onSwipeRight() {}
    open fun onSwipeLeft() {}
}