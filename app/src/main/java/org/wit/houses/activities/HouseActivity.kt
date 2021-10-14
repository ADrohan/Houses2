package org.wit.houses.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import org.wit.houses.R
import org.wit.houses.databinding.ActivityHouseBinding
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

        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)

        app = application as MainApp
        i("House Activity started...")

        if (intent.hasExtra("house_edit")) {
            house = intent.extras?.getParcelable("house_edit")!!
            binding.houseAddress.setText(house.address)
            binding.listPrice.setText(house.listPrice)
            binding.bedrooms.setText(house.bedrooms)
            binding.bathrooms.setText(house.bathrooms)
            binding.description.setText(house.description)
            binding.soldPrice.setText(house.soldPrice)
            binding.auctioneer.setText(house.auctioneer)
            binding.btnAdd.setText(R.string.Update_house)
        }

        binding.btnAdd.setOnClickListener() {
            house.address= binding.houseAddress.text.toString()
            house.listPrice= binding.listPrice.text.toString()
            house.bedrooms= binding.bedrooms.text.toString()
            house.bathrooms=binding.bathrooms.text.toString()
            house.description=binding.description.text.toString()
            house.soldPrice= binding.soldPrice.text.toString()
            house.auctioneer= binding.auctioneer.text.toString()
            if (house.address.isNotEmpty()) {
                app.houses.create(house.copy())
                setResult(RESULT_OK)
                finish()
            }
            else {
                Snackbar
                    .make(it,R.string.enter_houseAddress, Snackbar.LENGTH_LONG )
                    .show()
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_house, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.item_cancel -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}