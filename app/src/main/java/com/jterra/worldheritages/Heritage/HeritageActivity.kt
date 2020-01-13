package com.jterra.worldheritages.Heritage

import android.content.Intent
import android.os.Bundle
import com.jterra.worldheritages.BaseActivity
import com.jterra.worldheritages.Common.Utils
import com.jterra.worldheritages.HeritageDetails.HeritageDetailsActivity

class HeritageActivity: BaseActivity(), HeritageView.onFinishParseAnimationListener {
    private lateinit var heritageView: HeritageView

    private var jsonString: String? = ""
    private var listHeritagesModel : ArrayList<HeritageModel>? = null
    private val fileName = "real.planet.world-heritage.json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        heritageView = HeritageViewImpl(this.layoutInflater)
        setContentView(heritageView.getRootView())
        heritageView.setListener(this)

        readJsonFile()
    }

    private fun readJsonFile() {
        jsonString = Utils.getJsonStringFromFile(this, fileName)
        if(isReadFileSuccessfull()) {
            heritageView.animatePingPongComplete(this, "Getting info ...", "read")
        }
    }

    private fun parseJsonFile() {
        listHeritagesModel = Utils.parseStringToModel(jsonString)
        if (listHeritagesModel.isNullOrEmpty()) {
            Utils.showErrorAlertDialog(this, "Json Parse Failed",
                "Error during parsing file.",
                "Ok", null,
                null, null)
        } else {
            heritageView.animatePingPongComplete(this, "Loading completed.", "get")
        }
    }

    private fun completeParse() {
        heritageView.animateCompleteParse(this)
    }

    private fun isReadFileSuccessfull() : Boolean{
        if(jsonString == null) {
            //melhorar isso
            Utils.showErrorAlertDialog(this,
                "File not found",
                "The file you requested couldn't be found. Please try again with other name.",
                "Ok", null,
                null, null)
            return false
        }
        return true
    }

    override fun onCompleteReadAnimation() {
        parseJsonFile()
    }

    override fun onCompleteGetInfoAnim() {
        completeParse()
    }

    override fun onCompleteAnimation() {
        Utils.heritages = listHeritagesModel
        val intent = Intent(this, HeritageDetailsActivity::class.java)
        startActivity(intent)
    }
}