package com.kiryanov.royality.mvp.PlacesScreen

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
import com.kiryanov.royality.adapters.RecyclerViewAdapter
import com.kiryanov.royality.data.Category
import com.kiryanov.royality.databinding.FragmentPlacesBinding


class PlacesFragment : MvpAppCompatFragment(), PlacesView {

    private lateinit var adapter: RecyclerViewAdapter<Category, PlacesPresenter>

    @InjectPresenter
    lateinit var presenter: PlacesPresenter

    private lateinit var binding: FragmentPlacesBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_places, container, false)

        initRV(binding.rv)

        binding.btnFullscreen.setOnClickListener{
            val visibility= if (binding.rv.visibility == View.VISIBLE) {
                binding.btnFullscreen.setImageResource(R.drawable.ic_fullscreen_exit)
                View. GONE
            } else {
                binding.btnFullscreen.setImageResource(R.drawable.ic_fullscreen)
                View.VISIBLE
            }

            binding.rv.visibility = visibility
            binding.buttonBar.visibility = visibility
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
                val offset = resources.getDimension(R.dimen.recycler_view_horizontal_offset).toInt()

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
                /*add(Category("Еда", R.drawable.ic_coffe_cup))
                add(Category("Авто", R.drawable.ic_car_repair))
                add(Category("Спорт", R.drawable.ic_sport))
                add(Category("Красота", R.drawable.ic_beauty))
                add(Category("Финансы", R.drawable.ic_finance))
                add(Category("Строительство", R.drawable.ic_build))
                add(Category("B2B", R.drawable.ic_network))
                add(Category("Образование", R.drawable.ic_education))
                add(Category("Досуг", R.drawable.ic_leisure))
                add(Category("Магазины", R.drawable.ic_shop))
                add(Category("Сфера услуг", R.drawable.ic_service))*/
                add(Category("Food", R.drawable.ic_coffe_cup))
                add(Category("Car", R.drawable.ic_car_repair))
                add(Category("Sport", R.drawable.ic_sport))
                add(Category("Beauty", R.drawable.ic_beauty))
                add(Category("Finance", R.drawable.ic_finance))
                add(Category("Building", R.drawable.ic_build))
                add(Category("B2B", R.drawable.ic_network))
                add(Category("Education", R.drawable.ic_education))
                add(Category("Leisure", R.drawable.ic_leisure))
                add(Category("Shops", R.drawable.ic_shop))
                add(Category("Service", R.drawable.ic_service))
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