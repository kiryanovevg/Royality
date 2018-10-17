package com.kiryanov.royality.mvp.MapScreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.kiryanov.royality.EXTRA_COORDINATE
import com.kiryanov.royality.EXTRA_LIST
import com.kiryanov.royality.EXTRA_TYPE
import com.kiryanov.royality.R
import com.kiryanov.royality.data.Coordinate
import kotlinx.android.synthetic.main.activity_map.*
import org.osmdroid.util.BoundingBox
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.Marker

class MapActivity : MvpAppCompatActivity(), IMapView {

    @InjectPresenter
    lateinit var presenter: MapPresenter

    companion object {
        fun getIntent(context: Context, coordinate: Coordinate): Intent {
            val intent = Intent(context, MapActivity::class.java)
            intent.putExtra(EXTRA_TYPE, EXTRA_COORDINATE)
            intent.putExtra(EXTRA_COORDINATE, coordinate)

            return intent
        }

        fun getIntent(context: Context, list: ArrayList<Coordinate>): Intent {
            val intent = Intent(context, MapActivity::class.java)
            intent.putExtra(EXTRA_TYPE, EXTRA_LIST)
            intent.putParcelableArrayListExtra(EXTRA_LIST, list)

            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val list = ArrayList<Coordinate>()

        if (intent.getStringExtra(EXTRA_TYPE) == EXTRA_COORDINATE) {
            list.add(intent.getParcelableExtra(EXTRA_COORDINATE))
        } else {
            list.addAll(intent.getParcelableArrayListExtra(EXTRA_LIST))
        }

        var north = list[0].lat
        var south = list[0].lat
        var east = list[0].lng
        var west = list[0].lng

        if (list.size == 1) {
            map_view.controller.setCenter(GeoPoint(list[0].lat, list[0].lng))
            map_view.controller.setZoom(10.0)
        } else {

        }

        list.forEach {
            val marker = Marker(map_view)
            marker.setOnMarkerClickListener({ _, _ -> true })
            marker.position = GeoPoint(
                    it.lat, it.lng
            )
            map_view.overlays.add(marker)

            val lat = it.lat
            val lng = it.lng

            if (lat > north) north = lat
            if (south > lat) south = lat
            if (lng > east) east = lng
            if (west > lng) west = lng
        }

        presenter.zoomToBoundingBox(BoundingBox(north, east, south, west), true)
    }

    override fun zoomToBoundingBox(boundingBox: BoundingBox, animate: Boolean) {
        map_view.zoomToBoundingBox(boundingBox, true)
    }
}