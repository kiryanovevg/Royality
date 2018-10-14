package com.kiryanov.royality.mvp.CoalitionScreen

import com.arellomobile.mvp.InjectViewState
import com.kiryanov.royality.data.Shop
import com.kiryanov.royality.mvp.BasePresenter

@InjectViewState
class CoalitionPresenter : BasePresenter<CoalitionView>() {

    fun onItemClick(item: Shop) {
        viewState.showShopInfo(item)
    }
}