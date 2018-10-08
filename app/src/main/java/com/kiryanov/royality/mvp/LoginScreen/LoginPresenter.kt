package com.kiryanov.royality.mvp.LoginScreen

import com.arellomobile.mvp.InjectViewState
import com.kiryanov.royality.mvp.BasePresenter
import com.kiryanov.royality.mvp.LoginScreen.FirstStepScreen.FirstStepFragment

@InjectViewState
class LoginPresenter : BasePresenter<LoginView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.setFragment(FirstStepFragment())
    }
}