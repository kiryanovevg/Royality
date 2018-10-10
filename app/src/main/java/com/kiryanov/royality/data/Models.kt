package com.kiryanov.royality.data

data class User(val id: Int,
                val phone: String,
                val sex: String,
                val name: String,
                val surname: String,
                val patronymic: String,
                val city: String)

data class Category(val name: String, val resId: Int)