package com.kiryanov.royality.mvp.CoalitionListScreen

import android.content.Intent
import android.databinding.DataBindingUtil
import android.graphics.Rect
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.royality.EXTRA_COALITION
import com.kiryanov.royality.R
import com.kiryanov.royality.adapters.RecyclerViewAdapter
import com.kiryanov.royality.data.Coalition
import com.kiryanov.royality.databinding.RecyclerLayoutBinding
import com.kiryanov.royality.mvp.CoalitionScreen.CoalitionActivity

class CoalitionListFragment : MvpAppCompatFragment(), CoalitionListView, SwipeRefreshLayout.OnRefreshListener {

    private lateinit var adapter: RecyclerViewAdapter<Coalition, CoalitionListPresenter>

    @InjectPresenter
    lateinit var presenter: CoalitionListPresenter

    private lateinit var binding: RecyclerLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.recycler_layout, container, false)

        adapter = RecyclerViewAdapter(R.layout.item_coalition, presenter)
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(context)

        binding.refresh.setOnRefreshListener(this)
        binding.refresh.setColorSchemeColors(
                ContextCompat.getColor(context!!, R.color.colorAccent)
        )

        binding.rv.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                val offset = resources.getDimension(R.dimen.recycler_view_vertical_offset).toInt()

                if (parent.getChildAdapterPosition(view) == 0) {
                    outRect.top += offset
                }
            }
        })

        return binding.root
    }

    override fun showCoalitionInfo(item: Coalition) {
        val intent = Intent(context, CoalitionActivity::class.java)
        intent.putExtra(EXTRA_COALITION, item)
        startActivity(intent)
    }

    override fun onRefresh() {
        presenter.loading()
    }

    override fun setList(list: ArrayList<Coalition>) {
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