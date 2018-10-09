package com.kiryanov.royality.mvp.RegistrationScreen

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.ActionBar
import android.view.MenuItem
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.royality.R
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : MvpAppCompatActivity(), RegistrationView {

    @InjectPresenter
    lateinit var presenter: RegistrationPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        setSupportActionBar(toolbar)

        (supportActionBar as ActionBar).setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.activity_registration_title)

        sign_up.setOnClickListener {
            presenter.registration(
                    et_name.text.toString(),
                    et_surname.text.toString(),
                    et_email.text.toString(),
                    et_password.text.toString()
            )
        }
    }

    override fun registrationSuccessful() {
        setResult(Activity.RESULT_OK)
        finish()
    }

    override fun setLoadingProgressVisibility(visibility: Boolean) {
        loading.visibility = if (visibility) View.VISIBLE else View.GONE
        root.visibility = if (visibility) View.GONE else View.VISIBLE
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