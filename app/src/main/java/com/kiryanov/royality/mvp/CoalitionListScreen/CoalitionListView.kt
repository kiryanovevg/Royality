package com.kiryanov.royality.mvp.CoalitionListScreen

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.kiryanov.royality.data.Coalition

@StateStrategyType(AddToEndSingleStrategy::class)
interface CoalitionListView : MvpView {

    fun setLoadingProgressVisibility(visibility: Boolean)
    fun setErrorMessageVisibility(visibility: Boolean)
    fun setList(list: ArrayList<Coalition>)
    fun setRecyclerViewVisibility(visibility: Boolean)
    fun setErrorMessage(msg: Int)

    @StateStrategyType(SkipStrategy::class)
    fun showCoalitionInfo(item: Coalition)
}