package org.wit.houses.main

import android.app.Application
import org.wit.houses.models.HouseModel
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    val houses = ArrayList<HouseModel>()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("Houses started")
        houses.add(HouseModel("3 Bridge St., Waterford", "80000","2", "2", "description", "95000", "DMG" ))
        houses.add(HouseModel("4 Bridge St., Waterford", "79000","2", "2", "description", "94000", "DMG" ))
    }
}
