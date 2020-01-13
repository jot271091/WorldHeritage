package com.jterra.worldheritages.Heritage

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


@JsonClass(generateAdapter = true)
data class HeritageModel(
    @Json(name = "id") val id: Int,
    @Json(name = "year") val year: Int,
    @Json(name = "target") val target: String? = "",
    @Json(name = "type") val type: String? = "",
    @Json(name = "name") val name: String? = "",
    @Json(name = "region") val region: String? = "",
    @Json(name = "regionLong") val regionLong: String? = "",
    @Json(name = "coordinates") val coordinates: String? = "",
    @Json(name = "lat") val latitude: Double? = 0.0,
    @Json(name = "lng") val longitude: Double? = 0.0,
    @Json(name = "page") val pageString: String? = "",
    @Json(name = "image") val imageString: String? = "",
    @Json(name = "imageAuthor") val imageAuthor: String? = "",
    @Json(name = "shortInfo") val shortInfo: String? = "",
    @Json(name = "longInfo") val longInfo: String? = ""
):Serializable {

    fun isLatLngValid() : Boolean{
        if(latitude != null && longitude != null) {
            if(latitude != 0.0 && longitude != 0.0) {
                return true
            }
        }
        return false
    }
}

