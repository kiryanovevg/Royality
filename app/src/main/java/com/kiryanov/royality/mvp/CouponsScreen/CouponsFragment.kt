package com.kiryanov.royality.mvp.CouponsScreen

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AlertDialog
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.royality.R
import com.kiryanov.royality.adapters.RecyclerViewAdapter
import com.kiryanov.royality.data.Coupon
import com.kiryanov.royality.databinding.RecyclerLayoutBinding

class CouponsFragment : MvpAppCompatFragment(), CouponsView, SwipeRefreshLayout.OnRefreshListener {

    private lateinit var adapter: RecyclerViewAdapter<Coupon, CouponsPresenter>

    @InjectPresenter
    lateinit var presenter: CouponsPresenter

    private lateinit var binding: RecyclerLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.recycler_layout, container, false)

        adapter = RecyclerViewAdapter(R.layout.item_coupon, presenter)
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(context)

        binding.refresh.setOnRefreshListener(this)
        binding.refresh.setColorSchemeColors(
                ContextCompat.getColor(context!!, R.color.colorAccent)
        )

        /*binding.rv.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                val offset = resources.getDimension(R.dimen.recycler_view_vertical_offset).toInt()

                if (parent.getChildAdapterPosition(view) == 0) {
                    outRect.top += offset
                }
            }
        })*/

        binding.rv.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))

        return binding.root
    }

    override fun showCouponInfo(item: Coupon) {
        val view = ImageView(context)
        view.setImageResource(item.qr)

        val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        )

        val density =  resources.displayMetrics.density.toInt()
        layoutParams.topMargin = density * 12
        layoutParams.bottomMargin = density * 12

        view.layoutParams = layoutParams


//        val view = LayoutInflater.from(context).inflate(R.layout.fragment_cash_back, null)
//        view.findViewById<ImageView>(R.id.image_view).setImageResource(item.qr)

        AlertDialog.Builder(context!!)
                .setTitle(R.string.coupons)
                .setView(view)
                .setPositiveButton("Ok", null)
                .create()
                .show()
    }

    override fun onRefresh() {
        presenter.loading()
    }

    override fun setList(list: ArrayList<Coupon>) {
        adapter.addAllWithClear(list)
    }

    override fun setErrorMessage(msg: Int) {
        binding.tvError.text = getString(msg)
    }

    override fun setLoadingProgressVisibility(visibility: Boolean) {
        binding.refresh.isRefreshing = visibility
    }

    override fun setErrorMessageVisibility(visibility: Boolean) {
        binding.tvError.visibility = if (visibility) View.VISIBLE else View.GONE
    }

    override fun setRecyclerViewVisibility(visibility: Boolean) {
        binding.rv.visibility = if (visibility) View.VISIBLE else View.GONE
    }
}