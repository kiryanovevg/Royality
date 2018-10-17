package com.kiryanov.royality.data

import android.os.Parcel
import android.os.Parcelable

data class User(val id: Int,
                val phone: String,
                val sex: String,
                val name: String,
                val surname: String,
                val patronymic: String,
                val city: String)

data class Category(val name: String, val resId: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(resId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Category> {
        override fun createFromParcel(parcel: Parcel): Category {
            return Category(parcel)
        }

        override fun newArray(size: Int): Array<Category?> {
            return arrayOfNulls(size)
        }
    }
}

data class Coalition(val name: String,
                     val description: String,
                     val shops: List<Shop>,
                     val icon: Int,
                     val image: Int,
                     var bill: Int,
                     val loyalty: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.createTypedArrayList(Shop),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeTypedList(shops)
        parcel.writeInt(icon)
        parcel.writeInt(image)
        parcel.writeInt(bill)
        parcel.writeString(loyalty)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Coalition> {
        override fun createFromParcel(parcel: Parcel): Coalition {
            return Coalition(parcel)
        }

        override fun newArray(size: Int): Array<Coalition?> {
            return arrayOfNulls(size)
        }
    }
}

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
                val image: Int,
                var bill: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(Coordinate::class.java.classLoader),
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(Category::class.java.classLoader),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(city)
        parcel.writeString(address)
        parcel.writeString(number)
        parcel.writeParcelable(coordinate, flags)
        parcel.writeString(description)
        parcel.writeString(loyalty)
        parcel.writeParcelable(category, flags)
        parcel.writeString(type)
        parcel.writeInt(rating)
        parcel.writeInt(icon)
        parcel.writeInt(image)
        parcel.writeInt(bill)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Shop> {
        override fun createFromParcel(parcel: Parcel): Shop {
            return Shop(parcel)
        }

        override fun newArray(size: Int): Array<Shop?> {
            return arrayOfNulls(size)
        }
    }
}

data class Coordinate(val lat: Double, val lng: Double) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readDouble(),
            parcel.readDouble())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(lat)
        parcel.writeDouble(lng)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Coordinate> {
        override fun createFromParcel(parcel: Parcel): Coordinate {
            return Coordinate(parcel)
        }

        override fun newArray(size: Int): Array<Coordinate?> {
            return arrayOfNulls(size)
        }
    }
}

data class CordaUser(val corId: Int,
                     val bill: Int)

data class Coupon(val name: String,
                  val category: String,
                  val text: String,
                  val qr: Int,
                  val image: Int)