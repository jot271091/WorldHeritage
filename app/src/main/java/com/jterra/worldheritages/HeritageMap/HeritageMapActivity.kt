package com.jterra.worldheritages.HeritageMap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.jterra.worldheritages.Heritage.HeritageModel
import com.jterra.worldheritages.R

class HeritageMapActivity : AppCompatActivity(), OnMapReadyCallback {

    private var googleMap: GoogleMap? = null
    private var heritageModel: HeritageModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heritage_map)
        heritageModel = intent.extras!!["model"] as HeritageModel?

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap

        val place = LatLng(heritageModel?.latitude!!, heritageModel?.longitude!!)
        googleMap.addMarker(MarkerOptions().position(place).title(heritageModel?.name))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(place, 6f))
    }

}