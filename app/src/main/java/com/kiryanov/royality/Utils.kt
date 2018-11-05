package com.kiryanov.royality

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.VectorDrawable
import android.support.v4.content.ContextCompat

fun getIcon(context: Context): Bitmap {
    val drawable = ContextCompat.getDrawable(context, R.drawable.ic_location_red)
    val vectorDrawable = drawable as VectorDrawable?
    val scaleSize = 2f

    return getScaledBitmapFromVectorDrawable(vectorDrawable!!, scaleSize)
}

fun getScaledBitmapFromVectorDrawable(vectorDrawable: VectorDrawable,
                                              scaleSize: Float): Bitmap {

    val scaledWidth = (vectorDrawable.intrinsicWidth * scaleSize).toInt()
    val scaledHeight = (vectorDrawable.intrinsicHeight * scaleSize).toInt()

    val bitmap = Bitmap.createBitmap(
            scaledWidth,
            scaledHeight,
            Bitmap.Config.ARGB_8888
    )
    val canvas = Canvas(bitmap)
    vectorDrawable.setBounds(0, 0, canvas.width, canvas.height)
    vectorDrawable.draw(canvas)

    return bitmap
}