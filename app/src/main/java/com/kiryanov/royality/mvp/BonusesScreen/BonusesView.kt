package com.kiryanov.royality.mvp.BonusesScreen

import android.support.v4.app.Fragment
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface BonusesView : MvpView {

    fun setToolbarTitle(title: Int)

    @StateStrategyType(SkipStrategy::class)
    fun setFragment(fragment: Fragment)
}