package com.kiryanov.royality.mvp.ShopScreen

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.MenuItem
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.royality.EXTRA_SHOP
import com.kiryanov.royality.R
import com.kiryanov.royality.data.Shop
import com.kiryanov.royality.databinding.ActivityShopBinding
import kotlinx.android.synthetic.main.app_bar_main.*

class ShopActivity : MvpAppCompatActivity(), ShopView {

    @InjectPresenter
    lateinit var presenter: ShopPresenter

    private lateinit var binding: ActivityShopBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shop)
        setSupportActionBar(toolbar)
        (supportActionBar as ActionBar).setDisplayHomeAsUpEnabled(true)

        val shopItem = intent.getParcelableExtra<Shop>(EXTRA_SHOP)
        binding.item = shopItem
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
         android.R.id.home -> onBackPressed()
        }

        return true
    }
}