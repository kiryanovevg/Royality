package com.kiryanov.royality.mvp.CashBackScreen

import com.arellomobile.mvp.InjectViewState
import com.kiryanov.royality.CurrentUser
import com.kiryanov.royality.R
import com.kiryanov.royality.mvp.BasePresenter

@InjectViewState
class CashBackPresenter : BasePresenter<CashBackView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        setCode()
    }

    private fun setCode() {
        var user = CurrentUser.getInstance().user
        if (user != null) {
            when (user.id) {
                1 -> viewState.setCodeImage(R.drawable.ic_qr_1)
                2 -> viewState.setCodeImage(R.drawable.ic_qr_2)
            }
        } else {
            viewState.showError()
        }
    }
}