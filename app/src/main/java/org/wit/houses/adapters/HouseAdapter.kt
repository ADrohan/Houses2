package org.wit.houses.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.wit.houses.databinding.CardHouseBinding
import org.wit.houses.models.HouseModel

interface HouseListener {
    fun onHouseClick(house: HouseModel)
}

class HouseAdapter constructor(private var houses: List<HouseModel>,
                                private  val listener: HouseListener) :
    RecyclerView.Adapter<HouseAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardHouseBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }
    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val house = houses[holder.adapterPosition]
        holder.bind(house, listener)
    }

    override fun getItemCount(): Int = houses.size

    class MainHolder(private val binding : CardHouseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(house: HouseModel, listener: HouseListener) {
            binding.houseAddress.text = house.address
            binding.listPrice.text = house.listPrice
            binding.bedrooms.text = house.bedrooms
            binding.bathrooms.text = house.bathrooms
            binding.description.text = house.description
            binding.auctioneer.text = house.auctioneer
            binding.soldPrice.text = house.soldPrice
            Picasso.get().load(house.image).resize(300,300).into(binding.imageIcon)

            binding.root.setOnClickListener { listener.onHouseClick(house)}
        }
    }
}