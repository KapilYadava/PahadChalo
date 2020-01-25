package com.example.pahadchalo.ui.ride

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.pahadchalo.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import kotlinx.android.synthetic.main.fragment_ride.*

class ShareFragment : Fragment(), OnMapReadyCallback {

    private lateinit var shareViewModel: ShareViewModel
    private lateinit var googleMap: GoogleMap
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mapView.onCreate(savedInstanceState)
        mapView.onResume()
        mapView.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap?) {
        p0?.let {
            googleMap = it
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shareViewModel =
            ViewModelProviders.of(this).get(ShareViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_ride, container, false)

        shareViewModel.text.observe(this, Observer {

        })
        return root
    }


}