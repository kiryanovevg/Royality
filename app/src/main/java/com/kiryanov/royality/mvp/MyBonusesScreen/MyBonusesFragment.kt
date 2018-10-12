package com.kiryanov.royality.mvp.MyBonusesScreen

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.royality.R
import com.kiryanov.royality.adapters.ViewPagerAdapter
import com.kiryanov.royality.mvp.ShopListScreen.ShopListFragment

class MyBonusesFragment : MvpAppCompatFragment(), MyBonusesView {

    private lateinit var adapter: ViewPagerAdapter

    @InjectPresenter
    lateinit var presenter: MyBonusesPresenter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_my_bonuses, container, false)

        val viewPager = view.findViewById<ViewPager>(R.id.view_pager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        adapter = ViewPagerAdapter(childFragmentManager)

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        adapter.addFragment(ShopListFragment(), getString(R.string.shops))
        adapter.addFragment(ShopListFragment(), getString(R.string.coalitions))

        return view
    }
}