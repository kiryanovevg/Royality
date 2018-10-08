package com.kiryanov.royality.mvp.LoginScreen

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.royality.R
import com.kiryanov.royality.mvp.MainScreen.MainActivity
import com.kiryanov.royality.mvp.RegistrationScreen.RegistrationActivity

class LoginActivity : MvpAppCompatActivity(), LoginView {

    @InjectPresenter
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.login_container, fragment)
                .commit()
    }

    override fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.login_container, fragment)
                .addToBackStack(null)
                .commit()
    }

    override fun login() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun registration() {
        startActivity(Intent(this, RegistrationActivity::class.java))
    }
}