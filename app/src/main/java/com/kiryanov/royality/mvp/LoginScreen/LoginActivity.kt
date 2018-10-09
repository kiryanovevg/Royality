package com.kiryanov.royality.mvp.LoginScreen

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.ActionBar
import android.view.MenuItem
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.royality.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : MvpAppCompatActivity(), LoginView {

    @InjectPresenter
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(toolbar)

        (supportActionBar as ActionBar).setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.activity_login_title)

        sign_in.setOnClickListener {
            presenter.login(et_login.text.toString(), et_password.text.toString().hashCode())
        }
        sign_up.setOnClickListener {  }
    }

    override fun setLoadingProgressVisibility(visibility: Boolean) {
        loading.visibility = if (visibility) View.VISIBLE else View.GONE
        root.visibility = if (visibility) View.GONE else View.VISIBLE
    }

    override fun loginSuccessful() {
        setResult(Activity.RESULT_OK)
        finish()
    }

    override fun showMessage(msg: Int) {
        Snackbar.make(coordinator_layout, msg, Snackbar.LENGTH_LONG).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> finish()
        }

        return true
    }
}