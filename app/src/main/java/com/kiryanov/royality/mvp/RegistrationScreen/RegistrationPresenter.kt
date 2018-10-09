package com.kiryanov.royality.mvp.RegistrationScreen

import android.content.Context
import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.evgeniy.royality.App
import com.kiryanov.royality.R
import com.kiryanov.royality.data.Repository
import com.kiryanov.royality.mvp.BasePresenter
import javax.inject.Inject

@InjectViewState
class RegistrationPresenter : BasePresenter<RegistrationView>() {

    @Inject
    lateinit var repository: Repository

    @Inject
    lateinit var context: Context

    private var b = true

    init {
        App.component.inject(this)
    }

    fun registration(name: String, surname: String,
                     email: String, password: String) {

        if (name.isEmpty() || surname.isEmpty()
                || email.isEmpty() || password.isEmpty()) {
            viewState.showMessage(R.string.empty_fields)
            return
        }

        viewState.setLoadingProgressVisibility(true)
        Thread(Runnable {

            Thread.sleep(3000)

            Handler(context.mainLooper).post({
                if (b) {
                    b = false
                    viewState.showMessage(R.string.registration_failed)
                } else {
                    viewState.registrationSuccessful()
                }

                viewState.setLoadingProgressVisibility(false)
            })
        }).start()
    }
}