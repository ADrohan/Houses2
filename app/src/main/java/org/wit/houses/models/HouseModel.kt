package org.wit.houses.models

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HouseModel(
    var id: Long = 0,
    var address: String = "",
    var listPrice: String = "",
    var bedrooms: String = "",
    var bathrooms: String = "",
    var description: String = "",
    var soldPrice: String = "",
    var auctioneer: String = "",
    var image: Uri = Uri.EMPTY,
    var lat : Double = 0.0,
    var lng: Double = 0.0,
    var zoom: Float = 0f
) : Parcelable

@Parcelize
data class Location(var lat: Double = 0.0,
                    var lng: Double = 0.0,
                    var zoom: Float = 0f) : Parcelable