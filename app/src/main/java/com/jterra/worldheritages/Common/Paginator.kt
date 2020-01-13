package com.jterra.worldheritages.Common

import com.jterra.worldheritages.Heritage.HeritageModel
import java.lang.Exception

class Paginator {

    val itemsPerPage = 20

    fun getTotalPages(heritagesListSize: Int) : Int {
        val remainingItems = heritagesListSize % itemsPerPage
        if (remainingItems > 0) {
            return heritagesListSize / itemsPerPage
        }

        return (heritagesListSize / itemsPerPage) - 1
    }

    fun getCurrentPageHeritagesList(currentPage: Int, heritageList: ArrayList<HeritageModel>?) : ArrayList<HeritageModel>? {
        val startItem = currentPage * itemsPerPage
        var lastItem = startItem + itemsPerPage

        if(lastItem >= Utils.heritages?.size!!) {
            lastItem = Utils.heritages?.size!!
        }

        var heritageListTemp = ArrayList<HeritageModel>()

        try {
            for (i in startItem until (lastItem)) {
                heritageListTemp.add(Utils.heritages!![i])
            }
            return heritageListTemp
        }catch (e : Exception) {
            return null
        }

    }
}
