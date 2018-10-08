package com.kiryanov.royality.mvp.LoginScreen

import android.support.v4.app.Fragment
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(SkipStrategy::class)
interface LoginView : MvpView {

    fun setFragment(fragment: Fragment)
    fun changeFragment(fragment: Fragment)
    fun login()
    fun registration()
}