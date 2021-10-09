package org.wit.houses.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import org.wit.houses.activities.databinding.ActivityHouseBinding
import org.wit.houses.models.HouseModel

import timber.log.Timber
import timber.log.Timber.i

class HouseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHouseBinding
    var house = HouseModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHouseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())
        i("House Activity started...")

        binding.btnAdd.setOnClickListener() {
            house.address= binding.houseAddress.text.toString()
            if (house.address.isNotEmpty()) {

                i("add Button Pressed $house.address")
            } else {
                Snackbar
                    .make(it, "Please Enter aa address", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}