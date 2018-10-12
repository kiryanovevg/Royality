package com.kiryanov.royality.mvp.CashBackScreen

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface CashBackView : MvpView {

    fun setCodeImage(resId: Int)
    fun showError()
}