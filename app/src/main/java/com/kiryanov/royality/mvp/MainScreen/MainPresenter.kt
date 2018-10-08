package com.kiryanov.royality.mvp.MainScreen

import com.arellomobile.mvp.InjectViewState
import com.kiryanov.royality.R
import com.kiryanov.royality.mvp.BasePresenter
import com.kiryanov.royality.mvp.BonusesScreen.BonusesFragment

@InjectViewState
class MainPresenter : BasePresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.setFragment(BonusesFragment(), R.string.bonuses)
        viewState.setFirstItemChecked()
    }
}