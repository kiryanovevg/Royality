package com.kiryanov.royality.data

data class User(val id: Int,
                val phone: String,
                val sex: String,
                val name: String,
                val surname: String,
                val patronymic: String,
                val city: String)

data class Category(val name: String, val resId: Int)

data class Shop(val name: String,
                val city: String,
                val address: String,
                val number: String,
                val coordinate: Coordinate,
                val description: String,
                val loyalty: String,
                val category: Category,
                val type: String,
                val rating: Int,
                val icon: Int,
                var bill: Int)

data class Coordinate(val lat: Double, val lng: Double)

data class CordaUser(val corId: Int,
                     val bill: Int)