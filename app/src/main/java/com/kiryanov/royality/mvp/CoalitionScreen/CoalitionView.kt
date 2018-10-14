package com.kiryanov.royality.mvp.CoalitionScreen

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.kiryanov.royality.data.Shop

@StateStrategyType(AddToEndSingleStrategy::class)
interface CoalitionView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showShopInfo(item: Shop)
}