package com.jterra.worldheritages.HeritageDetails

import android.content.Context
import android.view.View
import android.widget.Button

interface HeritageDetailsView{
    fun getRootView(): View

    interface PageChangedListener {
        fun onBackPagePressed()
        fun onNextPagePressed()
    }

    fun setListener(listener: PageChangedListener)

    fun updatePageText(page: Int)

    fun updateButtonStatus(button: Button, status: Boolean)
}