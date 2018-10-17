package com.kiryanov.royality.mvp.CouponsScreen

import com.arellomobile.mvp.InjectViewState
import com.evgeniy.royality.App
import com.kiryanov.royality.R
import com.kiryanov.royality.data.Coupon
import com.kiryanov.royality.data.Repository
import com.kiryanov.royality.mvp.BasePresenter
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

@InjectViewState
class CouponsPresenter : BasePresenter<CouponsView>() {

    @Inject
    lateinit var repository: Repository

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        App.component.inject(this)

        loading()
    }

    fun onItemClick(item: Coupon) {
        viewState.showCouponInfo(item)
    }

    fun loading() {
        repository.loadCouponList()
                .subscribe(object : Observer<Coupon> {
                    val list = ArrayList<Coupon>()

                    override fun onSubscribe(d: Disposable) {
                        unsubscribeOnDestroy(d)
                        viewState.setErrorMessageVisibility(false)
                        viewState.setLoadingProgressVisibility(true)
                        viewState.setRecyclerViewVisibility(false)
                    }

                    override fun onNext(shop: Coupon) {
                        list.add(shop)
                    }

                    override fun onError(e: Throwable) {
                        viewState.setErrorMessage(R.string.loading_error)
                        viewState.setErrorMessageVisibility(true)
                        viewState.setLoadingProgressVisibility(false)
                    }

                    override fun onComplete() {
                        if (list.isEmpty()) {
                            viewState.setErrorMessage(R.string.empty_list)
                            viewState.setErrorMessageVisibility(true)
                        } else {
                            viewState.setList(list)
                            viewState.setRecyclerViewVisibility(true)
                        }
                        viewState.setLoadingProgressVisibility(false)
                    }
                })
    }
}