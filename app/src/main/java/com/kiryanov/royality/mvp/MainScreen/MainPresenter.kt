package com.kiryanov.royality.mvp.MainScreen

import android.support.v4.app.Fragment
import com.arellomobile.mvp.InjectViewState
import com.kiryanov.royality.R
import com.kiryanov.royality.mvp.BasePresenter
import com.kiryanov.royality.mvp.BonusesScreen.BonusesFragment

@InjectViewState
class MainPresenter : BasePresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        setFragment(BonusesFragment(), R.string.places)
        viewState.setFirstItemChecked()
    }

    fun setFragment(fragment: Fragment, title: Int) {
        viewState.setFragment(fragment)
        viewState.setToolbarTitle(title)
    }
}