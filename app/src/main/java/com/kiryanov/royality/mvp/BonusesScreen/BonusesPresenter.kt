package com.kiryanov.royality.mvp.BonusesScreen

import android.support.v4.app.Fragment
import com.arellomobile.mvp.InjectViewState
import com.kiryanov.royality.mvp.BasePresenter
import com.kiryanov.royality.mvp.PlacesScreen.PlacesFragment

@InjectViewState
class BonusesPresenter : BasePresenter<BonusesView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.setFragment(PlacesFragment())
    }

    fun setFragment(fragment: Fragment, title: Int) {
        viewState.setFragment(fragment)
        viewState.setToolbarTitle(title)
    }
}