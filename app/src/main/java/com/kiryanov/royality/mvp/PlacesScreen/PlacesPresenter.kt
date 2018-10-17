package com.kiryanov.royality.mvp.PlacesScreen

import com.arellomobile.mvp.InjectViewState
import com.kiryanov.royality.data.Category
import com.kiryanov.royality.data.MockData
import com.kiryanov.royality.mvp.BasePresenter
import org.osmdroid.util.GeoPoint

@InjectViewState
class PlacesPresenter : BasePresenter<PlacesView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        setShops()
    }

    private fun setShops() {
        viewState.showShops(object : ArrayList<GeoPoint>() { init {
            MockData.getShopList().forEach {
                add(GeoPoint(
                        it.coordinate.lat,
                        it.coordinate.lng
                ))
            }
        }})
    }

    fun onItemClick(item: Category) {
        viewState.showMessage(item.name)
    }
}