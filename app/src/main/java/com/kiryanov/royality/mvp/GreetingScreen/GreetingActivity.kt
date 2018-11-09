package com.kiryanov.royality.mvp.GreetingScreen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.royality.CurrentUser
import com.kiryanov.royality.R
import com.kiryanov.royality.REQUEST_LOGIN
import com.kiryanov.royality.mvp.LoginScreen.LoginActivity
import com.kiryanov.royality.mvp.MainScreen.MainActivity
import com.kiryanov.royality.mvp.MainScreen.NewMainActivity
import kotlinx.android.synthetic.main.activity_greeting.*

class GreetingActivity : MvpAppCompatActivity(), GreetingView {

    @InjectPresenter
    lateinit var presenter: GreetingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting)

        sign_in.setOnClickListener { login() }
        btn_continue.setOnClickListener { loginWithoutUser() }
    }

    private fun login() {
        startActivityForResult(
                Intent(this, LoginActivity::class.java),
                REQUEST_LOGIN
        )
    }

    private fun loginWithoutUser() {
        CurrentUser.getInstance().withoutLogin()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_LOGIN) {
            if (resultCode == Activity.RESULT_OK) {
                startActivity(Intent(this, NewMainActivity::class.java))
                finish()
            }
        }
    }
}