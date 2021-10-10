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
    }
}