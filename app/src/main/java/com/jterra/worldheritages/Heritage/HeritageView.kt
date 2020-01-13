package com.jterra.worldheritages.Heritage

import android.content.Context
import android.view.View

interface HeritageView {
    fun getRootView(): View

    interface onFinishParseAnimationListener {
        fun onCompleteReadAnimation()
        fun onCompleteGetInfoAnim()
        fun onCompleteAnimation()
    }

    fun updateText(info: String)

    fun setListener(listener: onFinishParseAnimationListener)

    fun animateCompleteParse(context: Context)
    fun animatePingPongComplete(context: Context, text: String, type: String)
}