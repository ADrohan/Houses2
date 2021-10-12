package org.wit.houses.models

interface HouseStore {
    fun findAll(): List<HouseModel>
    fun create(house: HouseModel)
}