package com.kiryanov.royality.mvp.RegistrationScreen

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface RegistrationView : MvpView {

    @StateStrategyType(SkipStrategy::class)
    fun showMessage(msg: Int)

    @StateStrategyType(SkipStrategy::class)
    fun registrationSuccessful()

    fun setLoadingProgressVisibility(visibility: Boolean)
}