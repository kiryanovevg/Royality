package com.kiryanov.royality.mvp.LoginScreen.FirstStepScreen

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kiryanov.royality.R
import com.kiryanov.royality.mvp.LoginScreen.LoginActivity

class FirstStepFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login_first, container, false)

        view.findViewById<AppCompatButton>(R.id.sign_in).setOnClickListener {
            (activity as LoginActivity).presenter.viewState.registration()
        }

        view.findViewById<AppCompatButton>(R.id.btn_continue).setOnClickListener {
//            CurrentUser.getInstance().withoutLogin()
            (activity as LoginActivity).presenter.viewState.login()
        }

        return view
    }
}