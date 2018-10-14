package com.kiryanov.royality.mvp.CoalitionScreen

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.royality.EXTRA_COALITION
import com.kiryanov.royality.EXTRA_SHOP
import com.kiryanov.royality.R
import com.kiryanov.royality.adapters.RecyclerViewAdapter
import com.kiryanov.royality.data.Coalition
import com.kiryanov.royality.data.Shop
import com.kiryanov.royality.databinding.ActivityCoalitionBinding
import com.kiryanov.royality.mvp.ShopScreen.ShopActivity
import kotlinx.android.synthetic.main.app_bar_main.*

class CoalitionActivity : MvpAppCompatActivity(), CoalitionView {

    private lateinit var adapter: RecyclerViewAdapter<Shop, CoalitionPresenter>

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

        adapter = RecyclerViewAdapter(R.layout.item_coalition_shop, presenter)
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(this)

        adapter.addAll(shopItem.shops)
    }

    override fun showShopInfo(item: Shop) {
        val intent = Intent(this, ShopActivity::class.java)
        intent.putExtra(EXTRA_SHOP, item)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> onBackPressed()
        }

        return true
    }
}