package com.kiryanov.royality.mvp.BonusesScreen

import com.arellomobile.mvp.InjectViewState
import com.kiryanov.royality.data.Category
import com.kiryanov.royality.mvp.BasePresenter

@InjectViewState
class BonusesPresenter : BasePresenter<BonusesView>() {

    fun onItemClick(item: Category) {
        viewState.showMessage(item.name)
    }
}