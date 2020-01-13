package com.jterra.worldheritages.HeritageDetails

import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import com.jterra.worldheritages.R
import kotlinx.android.synthetic.main.activity_heritage_details.view.*

class HeritageDetailsViewImpl(layoutInflater: LayoutInflater) : HeritageDetailsView {
    private var rootView = layoutInflater.inflate(R.layout.activity_heritage_details, null)
    var pageChangedListener : HeritageDetailsView.PageChangedListener? = null

    override fun getRootView(): View = rootView

    init {
        getRootView().page_number_textview.text = "Page 1"
        getRootView().back_page_btn.isEnabled = false

        getRootView().back_page_btn.setOnClickListener {
            pageChangedListener?.onBackPagePressed()
        }

        getRootView().next_page_btn.setOnClickListener {
            pageChangedListener?.onNextPagePressed()
        }
    }

    override fun setListener(listener: HeritageDetailsView.PageChangedListener) {
        pageChangedListener = listener
    }

    override fun updatePageText(page: Int) {
        getRootView().page_number_textview.text = "Page $page"
    }

    override fun updateButtonStatus(button: Button, status: Boolean) {
        button.isEnabled = status
    }

}