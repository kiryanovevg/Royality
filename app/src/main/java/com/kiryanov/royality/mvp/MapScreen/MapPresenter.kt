package com.kiryanov.royality.mvp.MapScreen

import com.arellomobile.mvp.InjectViewState
import com.kiryanov.royality.mvp.BasePresenter
import org.osmdroid.util.BoundingBox

@InjectViewState
class MapPresenter : BasePresenter<IMapView>() {


    fun zoomToBoundingBox(boundingBox: BoundingBox, animate: Boolean) {
        viewState.zoomToBoundingBox(boundingBox, animate)
    }
}