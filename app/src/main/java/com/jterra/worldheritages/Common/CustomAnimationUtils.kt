package com.jterra.worldheritages.Common

import android.content.Context
import android.view.View
import android.view.animation.*
import com.jterra.worldheritages.R

object CustomAnimationUtils{

    fun startAnim(context: Context, view: View, animType: Int, listener: Animation.AnimationListener?) {
        val animation = AnimationUtils.loadAnimation(context, animType)
        animation.setAnimationListener(listener)
        view.startAnimation(animation)
    }

    fun startPingPongAnim(context: Context, view: View, listener: Animation.AnimationListener?) {
        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.interpolator = DecelerateInterpolator()
        fadeIn.duration = 1000

        val fadeOut = AlphaAnimation(0f, 1f)
        fadeOut.interpolator = AccelerateInterpolator()
        fadeOut.duration = 1000

        val animation = AnimationSet(false)
        animation.addAnimation(fadeIn)
        animation.addAnimation(fadeOut)
        animation.setAnimationListener(listener)
        view.startAnimation(animation)
    }
}
