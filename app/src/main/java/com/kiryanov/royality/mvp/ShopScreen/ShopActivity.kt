package com.kiryanov.royality.mvp.ShopScreen

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.MenuItem
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.royality.R
import kotlinx.android.synthetic.main.app_bar_main.*

class ShopActivity : MvpAppCompatActivity(), ShopView {

    @InjectPresenter
    lateinit var presenter: ShopPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
        setSupportActionBar(toolbar)
        (supportActionBar as ActionBar).setDisplayHomeAsUpEnabled(true)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
         android.R.id.home -> onBackPressed()
        }

        return true
    }
}