package com.kiryanov.royality.mvp.CoalitionScreen

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.MenuItem
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.royality.EXTRA_COALITION
import com.kiryanov.royality.R
import com.kiryanov.royality.data.Coalition
import com.kiryanov.royality.databinding.ActivityCoalitionBinding
import kotlinx.android.synthetic.main.app_bar_main.*

class CoalitionActivity : MvpAppCompatActivity(), CoalitionView {

    @InjectPresenter
    lateinit var presenter: CoalitionPresenter

    private lateinit var binding: ActivityCoalitionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coalition)
        setSupportActionBar(toolbar)
        (supportActionBar as ActionBar).setDisplayHomeAsUpEnabled(true)

        val shopItem = intent.getParcelableExtra<Coalition>(EXTRA_COALITION)
        binding.item = shopItem
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> onBackPressed()
        }

        return true
    }
}