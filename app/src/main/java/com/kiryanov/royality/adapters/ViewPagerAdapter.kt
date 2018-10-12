package com.kiryanov.royality.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val list = ArrayList<Pair<Fragment, String>>()

    override fun getItem(position: Int): Fragment {
        return list[position].first
    }

    override fun getPageTitle(position: Int): CharSequence {
        return list[position].second
    }

    override fun getCount(): Int {
        return list.size
    }

    fun addFragment(fragment: Fragment, title: String) {
        list.add(Pair(fragment, title))
        notifyDataSetChanged()
    }
}