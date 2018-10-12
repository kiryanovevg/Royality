package com.kiryanov.royality.mvp.LoginScreen

import android.content.Context
import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.evgeniy.royality.App
import com.kiryanov.royality.CurrentUser
import com.kiryanov.royality.R
import com.kiryanov.royality.data.MockData
import com.kiryanov.royality.data.Repository
import com.kiryanov.royality.mvp.BasePresenter
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
                var json: String? = MockData.getUser(login, passwordHash)

                if (json != null) {
                    CurrentUser.getInstance().login(json)
                    viewState.loginSuccessful()
                } else {
                    viewState.showMessage(R.string.login_failed)
                }

                viewState.setLoadingProgressVisibility(false)
            })
        }).start()
    }
}