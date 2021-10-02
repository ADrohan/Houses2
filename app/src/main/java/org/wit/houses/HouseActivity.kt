package org.wit.houses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import timber.log.Timber
import timber.log.Timber.i

class HouseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_house)

        Timber.plant(Timber.DebugTree())
        i("House Activity started...")
    }
}