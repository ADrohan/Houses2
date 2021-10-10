package org.wit.houses.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import org.wit.houses.activities.databinding.ActivityHouseBinding
import org.wit.houses.main.MainApp
import org.wit.houses.models.HouseModel

import timber.log.Timber.i

class HouseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHouseBinding
    var house = HouseModel()
    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHouseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        app = application as MainApp
        i("House Activity started...")

        binding.btnAdd.setOnClickListener() {
            house.address= binding.houseAddress.text.toString()
            house.listPrice= binding.listPrice.text.toString()
            house.bedrooms= binding.bedrooms.text.toString()
            house.bathrooms=binding.bathrooms.text.toString()
            house.description=binding.description.text.toString()
            house.soldPrice= binding.soldPrice.text.toString()
            house.auctioneer= binding.auctioneer.text.toString()
            if (house.address.isNotEmpty()) {
                app.houses.add(house.copy())
                i("add Button Pressed $house.address")
                for (i in app.houses.indices)
                { i("Placemark[$i]:${this.app.houses[i]}") }
            } else {
                Snackbar
                    .make(it, "Please Enter aa address", Snackbar.LENGTH_LONG )
                    .show()
            }
        }
    }
}