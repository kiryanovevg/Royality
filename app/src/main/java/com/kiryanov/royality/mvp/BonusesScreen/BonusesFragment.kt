package com.kiryanov.royality.mvp.BonusesScreen

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.royality.R
import com.kiryanov.royality.mvp.MainScreen.MainActivity
import com.kiryanov.royality.mvp.PlacesScreen.PlacesFragment

class BonusesFragment : MvpAppCompatFragment(),
        BonusesView,
        BottomNavigationView.OnNavigationItemSelectedListener {

    @InjectPresenter
    lateinit var presenter: BonusesPresenter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_places, container, false)

        val navigationView = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        navigationView.setOnNavigationItemSelectedListener(this)


        return view
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val currentFragment = fragmentManager!!.findFragmentById(R.id.places_container)

        when (item.itemId) {
            R.id.places -> {
                if (currentFragment !is PlacesFragment)
                    presenter.setFragment(PlacesFragment(), R.string.places)
                return true
            }
            R.id.bonuses -> {
                return true
            }
            R.id.shopping -> {
                return true
            }
            R.id.cash_back -> {
                return true
            }
        }
        return false
    }

    override fun setFragment(fragment: Fragment) {
        fragmentManager!!.beginTransaction()
                .replace(R.id.places_container, fragment)
                .commit()
    }

    override fun setToolbarTitle(title: Int) {
        (activity as MainActivity).presenter.viewState.setToolbarTitle(title)
    }
}