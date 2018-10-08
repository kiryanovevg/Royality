package com.kiryanov.royality.mvp.RegistrationScreen

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.MenuItem
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.royality.R
import kotlinx.android.synthetic.main.app_bar_main.*

class RegistrationActivity : MvpAppCompatActivity(), RegistrationView {

    @InjectPresenter
    lateinit var presenter: RegistrationPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        setSupportActionBar(toolbar)

        (supportActionBar as ActionBar).setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> finish()
        }

        return true
    }
}