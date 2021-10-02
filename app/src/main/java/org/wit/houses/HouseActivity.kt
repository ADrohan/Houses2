package org.wit.houses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.wit.houses.databinding.ActivityHouseBinding

import timber.log.Timber
import timber.log.Timber.i

class HouseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHouseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHouseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())

        i("House Activity started...")

        binding.btnAdd.setOnClickListener() {
            i("add Button Pressed")
        }


    }
}