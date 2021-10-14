package org.wit.houses.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HouseModel(
    var address: String = "",
    var listPrice: String = "",
    var bedrooms: String = "",
    var bathrooms: String = "",
    var description: String = "",
    var soldPrice: String = "",
    var auctioneer: String = "",
) : Parcelable