package com.jterra.worldheritages.Common

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.View
import com.jterra.worldheritages.Heritage.HeritageModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.io.EOFException
import java.io.File
import java.io.IOException
import java.util.logging.Logger

object Utils {

    var heritages: ArrayList<HeritageModel>? = null

    fun getJsonStringFromFile(context: Context, fileName: String) : String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use {
                it.readText()
            }
        } catch (ioException : IOException) {
            ioException.printStackTrace()
            return null
        }

        return jsonString
    }

    fun showErrorAlertDialog(context: Context, title: String, message: String,
                               firstButtonText: String, firstButtonListener: DialogInterface.OnClickListener?,
                               secondButtonText: String?, secondButtonListener: DialogInterface.OnClickListener?) {
        val alertDialog = createErrorAlertDialog(context,
            title,
            message,
            firstButtonText, firstButtonListener,
            secondButtonText, secondButtonListener)
        alertDialog.show()

    }

    fun createErrorAlertDialog(context: Context, title: String, message: String,
                               firstButtonText: String, firstButtonListener: DialogInterface.OnClickListener?,
                               secondButtonText: String?, secondButtonListener: DialogInterface.OnClickListener?) : AlertDialog.Builder {
        val alertDialogBuilder = AlertDialog.Builder(context)

        alertDialogBuilder.setTitle(title)
        alertDialogBuilder.setMessage(message)

        alertDialogBuilder.setPositiveButton(firstButtonText, firstButtonListener)
        alertDialogBuilder.setNegativeButton(secondButtonText, secondButtonListener)

        return alertDialogBuilder
    }

    fun parseStringToModel(jsonString: String?): ArrayList<HeritageModel>? {
        if(jsonString.isNullOrEmpty()){
            return null
        }
        try {
            val moshiBuilder = Moshi.Builder().build()
            val listType = Types.newParameterizedType(List::class.java, HeritageModel::class.java)
            val adapter: JsonAdapter<ArrayList<HeritageModel>> = moshiBuilder.adapter(listType)

            return adapter.fromJson(jsonString)
        } catch (jsonDataException: JsonDataException) {
            jsonDataException.printStackTrace()

            return null
        } catch (eofException : EOFException) {
            eofException.printStackTrace()

            return null
        }
    }


}