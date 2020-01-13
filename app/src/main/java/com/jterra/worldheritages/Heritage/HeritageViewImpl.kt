package com.jterra.worldheritages.Heritage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import com.jterra.worldheritages.Common.CustomAnimationUtils
import com.jterra.worldheritages.R
import kotlinx.android.synthetic.main.activity_main.view.*

class HeritageViewImpl(layoutInflater: LayoutInflater) : HeritageView {
    private var rootView = layoutInflater.inflate(R.layout.activity_main, null)
    var finishParseAnimationListener: HeritageView.onFinishParseAnimationListener? = null

    init {
        getRootView().textInfo.text = "Loading File ..."
    }

    override fun getRootView(): View = rootView

    override fun setListener(listener: HeritageView.onFinishParseAnimationListener) {
        finishParseAnimationListener = listener
    }

    override fun updateText(info: String) {
        getRootView().textInfo.text = info
    }

    override fun animateCompleteParse(context: Context) {
        CustomAnimationUtils.startAnim(context, getRootView().check_image, R.anim.fade_in, object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                finishParseAnimationListener?.onCompleteAnimation()
            }

            override fun onAnimationStart(p0: Animation?) {
                getRootView().progressBar.visibility = View.GONE
                getRootView().check_image.visibility = View.VISIBLE
            }
        })
    }

    override fun animatePingPongComplete(context: Context, text: String, type: String) {
        CustomAnimationUtils.startPingPongAnim(context, getRootView().textInfo, object : Animation.AnimationListener{
            override fun onAnimationRepeat(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                getRootView().textInfo.text = text
                if(type == "read"){
                    finishParseAnimationListener?.onCompleteReadAnimation()
                }else if(type == "get"){
                    finishParseAnimationListener?.onCompleteGetInfoAnim()
                }
            }

            override fun onAnimationStart(p0: Animation?) {
            }

        })
    }
}



