package com.kiryanov.royality.mvp.LoginScreen

import android.content.Context
import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.evgeniy.royality.App
import com.kiryanov.royality.CurrentUser
import com.kiryanov.royality.R
import com.kiryanov.royality.data.Repository
import com.kiryanov.royality.mvp.BasePresenter
import com.kiryanov.royality.user_response
import javax.inject.Inject

@InjectViewState
class LoginPresenter : BasePresenter<LoginView>() {

    @Inject
    lateinit var repository: Repository

    @Inject
    lateinit var context: Context

    init {
        App.component.inject(this)
    }

    fun login(login: String, passwordHash: Int) {
        if (login.isEmpty() || passwordHash == 0) {
            viewState.showMessage(R.string.empty_fields)
            return
        }

        viewState.setLoadingProgressVisibility(true)
        Thread(Runnable {

            Thread.sleep(3000)

            Handler(context.mainLooper).post({
                if (login == "1" && passwordHash == "1".hashCode()) {
                    CurrentUser.getInstance().login(user_response)
                    viewState.loginSuccessful()
                } else {
                    viewState.showMessage(R.string.login_failed)
                }

                viewState.setLoadingProgressVisibility(false)
            })
        }).start()
    }
}