package org.wit.houses.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.wit.houses.R
import org.wit.houses.main.MainApp

class HouseListActivity : AppCompatActivity() {

    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_house_list)
        app = application as MainApp
    }
}