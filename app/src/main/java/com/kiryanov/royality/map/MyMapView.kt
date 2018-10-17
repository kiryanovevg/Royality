package com.kiryanov.royality.map

import android.content.Context
import android.util.AttributeSet
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

const val MIN_ZOOM_LEVEL = 6.0
const val LAT = 47.2
const val LNG = 39.7

class MyMapView(context: Context, attrs: AttributeSet) : MapView(context, attrs) {

    init {
        setBuiltInZoomControls(false)
        setMultiTouchControls(true)
//        minZoomLevel = MIN_ZOOM_LEVEL
//        controller.setZoom(MIN_ZOOM_LEVEL + 1)
//        controller.setCenter(GeoPoint(LAT, LNG))
    }
}