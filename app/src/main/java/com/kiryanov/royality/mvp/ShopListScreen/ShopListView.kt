package com.kiryanov.royality.mvp.ShopListScreen

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.kiryanov.royality.data.Shop

@StateStrategyType(AddToEndSingleStrategy::class)
interface ShopListView : MvpView {

    fun setLoadingProgressVisibility(visibility: Boolean)
    fun setErrorMessageVisibility(visibility: Boolean)
    fun setList(list: ArrayList<Shop>)
    fun setRecyclerViewVisibility(visibility: Boolean)
    fun setErrorMessage(msg: Int)
}