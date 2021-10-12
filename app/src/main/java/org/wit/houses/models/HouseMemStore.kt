package org.wit.houses.models

import timber.log.Timber.i


class HouseMemStore : HouseStore {

    val houses = ArrayList<HouseModel>()

    override fun findAll(): List<HouseModel> {
        return houses
    }

    override fun create(house: HouseModel) {
        houses.add(house)
        logAll()
    }

    fun logAll() {
        houses.forEach{ i("${it}") }
    }
}