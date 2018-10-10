package com.kiryanov.royality.mvp.PlacesScreen

import android.animation.ValueAnimator
import android.databinding.DataBindingUtil
import android.graphics.Rect
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.royality.R
import com.kiryanov.royality.RecyclerViewAdapter
import com.kiryanov.royality.data.Category
import com.kiryanov.royality.databinding.FragmentBonusesBinding


class PlacesFragment : MvpAppCompatFragment(), PlacesView {

    private lateinit var adapter: RecyclerViewAdapter<Category, PlacesPresenter>

    @InjectPresenter
    lateinit var presenter: PlacesPresenter

    private lateinit var binding: FragmentBonusesBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_bonuses, container, false)

        initRV(binding.rv)

        binding.btnFullscreen.setOnClickListener{
            val minHeight = resources.getDimension(R.dimen.map_height).toInt()
            val height = if (binding.mapRoot.measuredHeight == minHeight) {
                binding.btnFullscreen.setImageResource(R.drawable.ic_fullscreen_exit)

                binding.rootLayout.measuredHeight
            } else {
                binding.btnFullscreen.setImageResource(R.drawable.ic_fullscreen)

                minHeight
            }

            val anim = ValueAnimator.ofInt(binding.mapRoot.measuredHeight, height)
            anim.addUpdateListener { valueAnimator ->
                val value = valueAnimator.animatedValue as Int
                val layoutParams = binding.mapRoot.layoutParams
                layoutParams.height = value
                binding.mapRoot.layoutParams = layoutParams

                val alpha = 1 - (value - minHeight) * 1.0 / (binding.rootLayout.measuredHeight - minHeight)
                binding.rootLayout.alpha = alpha.toFloat()
            }
            anim.duration = 700
            anim.start()
        }


        return binding.root
    }

    private fun initRV(rv: RecyclerView) {
        adapter = RecyclerViewAdapter(R.layout.item_bonuses_category, presenter)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
        )
        rv.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                val offset = 120

                if (parent.getChildAdapterPosition(view) == 0) {
                    outRect.left += offset
                }
                if (parent.getChildAdapterPosition(view) == adapter.itemCount - 1) {
                    outRect.right += offset
                }
            }
        })

        val list = object : ArrayList<Category>() {
            init {
                add(Category("Eda", R.drawable.ic_menu_compass))
                add(Category("asd", R.drawable.ic_menu_camera))
                add(Category("sad", R.drawable.ic_menu_manage))
                add(Category("dsa", R.drawable.ic_menu_mylocation))
                add(Category("asd", R.drawable.ic_menu_camera))
                add(Category("sad", R.drawable.ic_menu_manage))
                add(Category("dsa", R.drawable.ic_menu_share))
                add(Category("asd", R.drawable.ic_menu_camera))
                add(Category("sad", R.drawable.ic_menu_manage))
                add(Category("dsa", R.drawable.ic_menu_manage))
            }
        }

        adapter.addAll(list)
        adapter.notifyDataSetChanged()
    }

    override fun showMessage(msg: String) {
//        Snackbar.make(view!!, msg, Snackbar.LENGTH_LONG).show()
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }
}