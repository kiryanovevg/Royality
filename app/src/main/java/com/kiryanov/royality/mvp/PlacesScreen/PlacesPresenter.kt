package com.kiryanov.royality.mvp.PlacesScreen

import com.arellomobile.mvp.InjectViewState
import com.kiryanov.royality.data.Category
import com.kiryanov.royality.mvp.BasePresenter

@InjectViewState
class PlacesPresenter : BasePresenter<PlacesView>() {

    fun onItemClick(item: Category) {
        viewState.showMessage(item.name)
    }
}