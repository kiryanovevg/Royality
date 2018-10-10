package com.kiryanov.royality.mvp.PlacesScreen

import android.support.v4.app.Fragment
import com.arellomobile.mvp.InjectViewState
import com.kiryanov.royality.mvp.BasePresenter
import com.kiryanov.royality.mvp.BonusesScreen.BonusesFragment

@InjectViewState
class PlacesPresenter : BasePresenter<PlacesView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.setFragment(BonusesFragment())
    }

    fun setFragment(fragment: Fragment, title: Int) {
        viewState.setFragment(fragment)
        viewState.setToolbarTitle(title)
    }
}