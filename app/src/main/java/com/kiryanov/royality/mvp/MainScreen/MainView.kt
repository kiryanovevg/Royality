package com.kiryanov.royality.mvp.MainScreen

import android.support.v4.app.Fragment
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView {

    fun setFragment(fragment: Fragment, title: Int)

    @StateStrategyType(SkipStrategy::class)
    fun setFirstItemChecked()
}