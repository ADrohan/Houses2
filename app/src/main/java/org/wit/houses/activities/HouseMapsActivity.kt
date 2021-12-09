package org.wit.houses.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.wit.houses.R
import org.wit.houses.databinding.ActivityHouseMapsBinding

class HouseMapsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHouseMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHouseMapsBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_house_maps)
        setSupportActionBar(binding.toolbar)
    }
}