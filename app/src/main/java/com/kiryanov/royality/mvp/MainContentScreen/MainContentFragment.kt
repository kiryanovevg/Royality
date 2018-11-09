package com.kiryanov.royality.mvp.MainContentScreen

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.kiryanov.royality.R
import com.kiryanov.royality.databinding.MainContentBinding
import com.kiryanov.royality.mvp.MainScreen.NewMainActivity
import com.kiryanov.royality.mvp.PlacesScreen.PlacesFragment
import kotlinx.android.synthetic.main.activity_main_new.*

class MainContentFragment : MvpAppCompatFragment() {

    private lateinit var binding: MainContentBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
                inflater, R.layout.main_content,
                container, false
        )

        val activity= activity as NewMainActivity
        activity.setSupportActionBar(binding.toolbar)
        activity.supportActionBar?.title = getString(R.string.places)
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activity.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_account_balance)
        setHasOptionsMenu(true)


        fragmentManager!!.beginTransaction()
                .replace(R.id.main_container, PlacesFragment())
                .commit()

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                (activity as NewMainActivity).main_view_pager.setCurrentItem(0, true)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}