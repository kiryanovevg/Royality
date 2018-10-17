package com.kiryanov.royality.mvp.PlacesScreen

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import org.osmdroid.util.GeoPoint

@StateStrategyType(AddToEndSingleStrategy::class)
interface PlacesView : MvpView {

    @StateStrategyType(SkipStrategy::class)
    fun showMessage(msg: String)

    fun showShops(list: List<GeoPoint>)
}