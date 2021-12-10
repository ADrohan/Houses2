package org.wit.houses.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.wit.houses.databinding.ActivityHouseMapsBinding
import org.wit.houses.databinding.ContentHouseMapsBinding
import org.wit.houses.main.MainApp

class HouseMapsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHouseMapsBinding
    private lateinit var contentBinding: ContentHouseMapsBinding
    lateinit var map: GoogleMap
    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        app = application as MainApp
        binding = ActivityHouseMapsBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_house_maps)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        contentBinding = ContentHouseMapsBinding.bind(binding.root)
        contentBinding.mapView.onCreate(savedInstanceState)
        contentBinding.mapView.getMapAsync {
            map = it
            configureMap()

        }
    }

    fun configureMap() {
        map.uiSettings.setZoomControlsEnabled(true)
        app.houses.findAll().forEach {
            val loc = LatLng(it.lat, it.lng)
            val options = MarkerOptions().title(it.address).position(loc)
            map.addMarker(options).tag = it.id
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, it.zoom))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        contentBinding.mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        contentBinding.mapView.onLowMemory()
    }

    override fun onPause() {
        super.onPause()
        contentBinding.mapView.onPause()
    }

    override fun onResume() {
        super.onResume()
        contentBinding.mapView.onResume()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        contentBinding.mapView.onSaveInstanceState(outState)
    }
}

