package com.kiryanov.royality.mvp.CouponsScreen

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.kiryanov.royality.data.Coupon

@StateStrategyType(AddToEndSingleStrategy::class)
interface CouponsView : MvpView {

    fun setLoadingProgressVisibility(visibility: Boolean)
    fun setErrorMessageVisibility(visibility: Boolean)
    fun setList(list: ArrayList<Coupon>)
    fun setRecyclerViewVisibility(visibility: Boolean)
    fun setErrorMessage(msg: Int)

    @StateStrategyType(SkipStrategy::class)
    fun showCouponInfo(item: Coupon)
}