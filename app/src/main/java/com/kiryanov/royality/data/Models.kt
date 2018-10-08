package com.kiryanov.royality.data

data class User(val corId: Int,
                val corName: String,
                val phone: String,
                val city: String,
                var cor_bill_1: String,
                var cor_bill_2: String)