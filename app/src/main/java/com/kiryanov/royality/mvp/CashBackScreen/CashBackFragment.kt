package com.kiryanov.royality.mvp.CashBackScreen

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.royality.R
import com.kiryanov.royality.databinding.FragmentCashBackBinding

class CashBackFragment : MvpAppCompatFragment(), CashBackView {

    @InjectPresenter
    lateinit var presenter: CashBackPresenter

    private lateinit var binding: FragmentCashBackBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cash_back, container, false)

        return binding.root
    }

    override fun setCodeImage(resId: Int) {
        binding.imageView.setImageResource(resId)
    }

    override fun showError() {
        binding.tvError.visibility = View.VISIBLE
    }
}