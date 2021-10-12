package org.wit.houses.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.wit.houses.R
import org.wit.houses.databinding.ActivityHouseListBinding
import org.wit.houses.databinding.CardHouseBinding
import org.wit.houses.main.MainApp
import org.wit.houses.models.HouseModel

class HouseListActivity : AppCompatActivity() {

    lateinit var app: MainApp
    private lateinit var binding: ActivityHouseListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHouseListBinding.inflate(layoutInflater)
      //  setContentView(R.layout.activity_house_list)
        setContentView(binding.root)
        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)

        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = HouseAdapter(app.houses)

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> {
                val launcherIntent = Intent(this, HouseActivity::class.java)
                startActivityForResult(launcherIntent,0)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
class HouseAdapter constructor(private var houses: List<HouseModel>) :
        RecyclerView.Adapter<HouseAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardHouseBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }
    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val house = houses[holder.adapterPosition]
        holder.bind(house)
    }

    override fun getItemCount(): Int = houses.size

    class MainHolder(private val binding : CardHouseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(house: HouseModel) {
            binding.houseAddress.text = house.address
            binding.listPrice.text = house.listPrice
            binding.bedrooms.text = house.bedrooms
            binding.bathrooms.text = house.bathrooms
            binding.description.text = house.description
            binding.auctioneer.text = house.auctioneer
            binding.soldPrice.text = house.soldPrice
        }
    }
}