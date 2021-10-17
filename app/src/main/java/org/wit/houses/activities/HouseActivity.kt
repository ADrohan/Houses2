package org.wit.houses.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import org.wit.houses.R
import org.wit.houses.databinding.ActivityHouseBinding
import org.wit.houses.helpers.showImagePicker
import org.wit.houses.main.MainApp
import org.wit.houses.models.HouseModel

import timber.log.Timber.i

class HouseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHouseBinding
    var house = HouseModel()
    lateinit var app: MainApp
    private lateinit var imageIntentLauncher : ActivityResultLauncher<Intent>

    //var edit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var edit = false

        binding = ActivityHouseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)

        app = application as MainApp
        i("House Activity started...")

        if (intent.hasExtra("house_edit")) {
            edit = true
            house = intent.extras?.getParcelable("house_edit")!!
            binding.houseAddress.setText(house.address)
            binding.listPrice.setText(house.listPrice)
            binding.bedrooms.setText(house.bedrooms)
            binding.bathrooms.setText(house.bathrooms)
            binding.description.setText(house.description)
            binding.soldPrice.setText(house.soldPrice)
            binding.auctioneer.setText(house.auctioneer)
            binding.btnAdd.setText(R.string.Update_house)
            Picasso.get()
                .load(house.image)
                .into(binding.houseImage)
            if (house.image != Uri.EMPTY) {
                binding.chooseImage.setText(R.string.change_houseImage)
            }
        }

        binding.btnAdd.setOnClickListener() {
            house.address= binding.houseAddress.text.toString()
            house.listPrice= binding.listPrice.text.toString()
            house.bedrooms= binding.bedrooms.text.toString()
            house.bathrooms=binding.bathrooms.text.toString()
            house.description=binding.description.text.toString()
            house.soldPrice= binding.soldPrice.text.toString()
            house.auctioneer= binding.auctioneer.text.toString()
            if (house.address.isEmpty() ){
                Snackbar
                    .make(it,R.string.enter_houseAddress, Snackbar.LENGTH_LONG )
                    .show()
            }
            else {
                if (edit) {
                    app.houses.update(house.copy())
                } else {
                    app.houses.create(house.copy())
                }
            }
            setResult(RESULT_OK)
            finish()
        }
        binding.chooseImage.setOnClickListener {
            showImagePicker(imageIntentLauncher)
        }
        registerImagePickerCallback()
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
    private fun registerImagePickerCallback() {
        imageIntentLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { result ->
                when(result.resultCode){
                    RESULT_OK -> {
                        if (result.data != null) {
                            i("Got Result ${result.data!!.data}")
                            house.image = result.data!!.data!!
                            Picasso.get()
                                .load(house.image)
                                .into(binding.houseImage)
                            binding.chooseImage.setText(R.string.change_houseImage)
                        } // end of if
                    }
                    RESULT_CANCELED -> { } else -> { }
                }
            }
    }

}