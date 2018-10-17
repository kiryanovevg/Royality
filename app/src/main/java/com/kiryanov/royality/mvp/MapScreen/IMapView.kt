package com.kiryanov.royality.mvp.MapScreen

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import org.osmdroid.util.BoundingBox

@StateStrategyType(AddToEndSingleStrategy::class)
interface IMapView : MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun zoomToBoundingBox(boundingBox: BoundingBox, animate: Boolean)
}