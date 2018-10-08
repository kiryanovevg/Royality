package com.kiryanov.royality.map

import android.content.Context
import android.util.AttributeSet
import org.osmdroid.views.MapView

class MyMapView(context: Context, attrs: AttributeSet) : MapView(context, attrs) {

    init {
        setBuiltInZoomControls(false)
        setMultiTouchControls(true)
    }
}