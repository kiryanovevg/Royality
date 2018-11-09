package com.kiryanov.royality.mvp.MainScreen

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.arellomobile.mvp.MvpAppCompatActivity
import com.kiryanov.royality.R
import com.kiryanov.royality.adapters.ViewPagerAdapter
import com.kiryanov.royality.mvp.CashBackScreen.CashBackFragment
import com.kiryanov.royality.mvp.MainContentScreen.MainContentFragment
import kotlinx.android.synthetic.main.activity_main_new.*

class NewMainActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_new)

        initViewPager()
    }

    private fun initViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        main_view_pager.adapter = adapter

        adapter.addFragment(CashBackFragment(), getString(R.string.shops))
        adapter.addFragment(MainContentFragment(), getString(R.string.places))

        main_view_pager.setCurrentItem(1, false)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}