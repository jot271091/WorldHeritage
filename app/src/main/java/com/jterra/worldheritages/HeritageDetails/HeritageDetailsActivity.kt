package com.jterra.worldheritages.HeritageDetails

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.jterra.worldheritages.BaseActivity
import com.jterra.worldheritages.Common.Paginator
import com.jterra.worldheritages.Common.Utils
import com.jterra.worldheritages.Heritage.HeritageModel
import com.jterra.worldheritages.HeritageDetails.Adapter.HeritageListAdapter
import com.jterra.worldheritages.HeritageMap.HeritageMapActivity
import kotlinx.android.synthetic.main.activity_heritage_details.view.*

class HeritageDetailsActivity: BaseActivity(), HeritageDetailsView.PageChangedListener {
    private lateinit var heritageDetailsView: HeritageDetailsView
    private var currentPage = 0
    private var totalPages = 0
    val paginator = Paginator()
    private var heritages = ArrayList<HeritageModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        heritageDetailsView = HeritageDetailsViewImpl(layoutInflater)
        setContentView(heritageDetailsView.getRootView())
        heritageDetailsView.setListener(this)
        totalPages = paginator.getTotalPages(Utils.heritages?.size!!)
        populateListView()


    }

    private fun populateListView() {
        heritageDetailsView.getRootView().heritages_list.adapter =
            HeritageListAdapter(this, paginator.getCurrentPageHeritagesList(currentPage, heritages))
    }

    override fun onNextPagePressed() {
        currentPage += 1
        populateListView()
        updatePageNumber()
        toggleButton()
    }

    override fun onBackPagePressed() {
        currentPage -= 1
        populateListView()
        updatePageNumber()
        toggleButton()
    }

    private fun updatePageNumber() {
        heritageDetailsView.updatePageText(currentPage + 1)
    }

    fun toggleButton() {
        //single page
        if(totalPages <= 1) {
            heritageDetailsView.updateButtonStatus(heritageDetailsView.getRootView().back_page_btn, false)
            heritageDetailsView.updateButtonStatus(heritageDetailsView.getRootView().next_page_btn, false)
        } else if (currentPage == totalPages) {
            heritageDetailsView.updateButtonStatus(heritageDetailsView.getRootView().back_page_btn, true)
            heritageDetailsView.updateButtonStatus(heritageDetailsView.getRootView().next_page_btn, false)
        } else if(currentPage == 0){
            heritageDetailsView.updateButtonStatus(heritageDetailsView.getRootView().back_page_btn, false)
            heritageDetailsView.updateButtonStatus(heritageDetailsView.getRootView().next_page_btn, true)
        } else {
            heritageDetailsView.updateButtonStatus(heritageDetailsView.getRootView().back_page_btn, true)
            heritageDetailsView.updateButtonStatus(heritageDetailsView.getRootView().next_page_btn, true)
        }
    }
}