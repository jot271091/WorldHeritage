package com.jterra.worldheritages.HeritageDetails.Adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.jterra.worldheritages.Common.Utils
import com.jterra.worldheritages.Heritage.HeritageModel
import com.jterra.worldheritages.HeritageMap.HeritageMapActivity
import com.jterra.worldheritages.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.heritage_list_item.view.*

class HeritageListAdapter(private val context: Activity, private val heritageList: ArrayList<HeritageModel>?)
    : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return heritageList?.size!!
    }

    override fun getItem(position: Int): HeritageModel? {
        return heritageList?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val heritageModel = heritageList?.get(position)!!
        val rowView = inflater.inflate(R.layout.heritage_list_item, parent, false)

        rowView.heritage_name.text = heritageModel?.name!!
        Picasso.get().load(heritageModel.imageString)
            .placeholder(context.resources.getDrawable(android.R.drawable.ic_menu_gallery)) //TODO update method
            .error(context.resources.getDrawable(R.drawable.notfound))
            .into(rowView.heritage_image)
        rowView.heritage_short_info.text = heritageModel?.shortInfo!!
        rowView.tag = position
        rowView.setOnClickListener{
            if(heritageModel.isLatLngValid()){
                val intent = Intent(context, HeritageMapActivity::class.java).apply {
                    putExtra("model", heritageModel)
                }
                context.startActivity(intent)
            } else {
                Utils.showErrorAlertDialog(context, "Wrong Coordinates"
                    ,"There seems to have a problem with the coordinates from this heritage. Please try again."
                    ,"Ok",null,null,null)
            }

        }

        return rowView
    }


}