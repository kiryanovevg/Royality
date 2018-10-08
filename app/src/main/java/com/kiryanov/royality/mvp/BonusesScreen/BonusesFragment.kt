package com.kiryanov.royality.mvp.BonusesScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.royality.R

class BonusesFragment : MvpAppCompatFragment(), BonusesView {

    @InjectPresenter
    lateinit var presenter: BonusesPresenter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = layoutInflater.inflate(R.layout.fragment_bonuses, null)

        return view
    }
}