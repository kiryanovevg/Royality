package com.kiryanov.royality.mvp.MainScreen

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.royality.R
import com.kiryanov.royality.mvp.BonusesScreen.BonusesFragment
import com.kiryanov.royality.mvp.LoginScreen.FirstStepScreen.FirstStepFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : MvpAppCompatActivity(),
        NavigationView.OnNavigationItemSelectedListener,
        MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this,
                drawer_layout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.main_container)

        when (item.itemId) {
            R.id.bonuses -> {
                if (currentFragment !is  BonusesFragment)
                    presenter.viewState.setFragment(BonusesFragment(), R.string.bonuses)
            }
            R.id.coupons -> {
                presenter.viewState.setFragment(FirstStepFragment(), R.string.bonuses)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun setFragment(fragment: Fragment, title: Int) {
        supportActionBar?.title = getString(title)
        supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, fragment)
                .commit()
    }

    override fun setFirstItemChecked() {
        nav_view.menu.getItem(0).isChecked = true
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
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