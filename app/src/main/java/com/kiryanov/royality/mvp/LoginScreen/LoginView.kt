package com.kiryanov.royality.mvp.LoginScreen

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(SkipStrategy::class)
interface LoginView : MvpView {

    fun loginSuccessful()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showMessage(msg: Int)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setLoadingProgressVisibility(visibility: Boolean)
}