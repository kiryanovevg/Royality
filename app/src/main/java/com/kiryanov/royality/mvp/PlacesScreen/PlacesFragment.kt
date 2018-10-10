package com.kiryanov.royality.mvp.PlacesScreen

import android.graphics.Rect
import android.os.Bundle
import android.support.design.widget.Snackbar
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

class PlacesFragment : MvpAppCompatFragment(), PlacesView {

    private lateinit var adapter: RecyclerViewAdapter<Category, PlacesPresenter>

    @InjectPresenter
    lateinit var presenter: PlacesPresenter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = layoutInflater.inflate(R.layout.fragment_bonuses, null)

        val rv = view.findViewById<RecyclerView>(R.id.rv)
        initRV(rv)


        return view
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
        Snackbar.make(view!!, msg, Snackbar.LENGTH_LONG).show()
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }
}