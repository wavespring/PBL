package com.example.pbl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.pbl.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLngBounds

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap


        // Add a marker in Sydney and move the camera
        val kosen = LatLng(32.876636, 130.748012)
        mMap.addMarker(MarkerOptions().position(kosen).title("熊本高専"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kosen, 13.0f))

        mMap.apply {
            setLatLngBoundsForCameraTarget(
                LatLngBounds(LatLng(32.846397, 130.717670), LatLng(32.928111, 130.854129))
            )
        }

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(32.89766790022332, 130.72482516043988))
                .title("弁天山公園")
                .snippet("公園")
        )
        /*mMap.run {
            val benten = addCircle(
                CircleOptions().center(LatLng(32.89766790022332, 130.72482516043988)).clickable(true)
            )

            val manga = addCircle(
                CircleOptions().center(LatLng(32.89139037375045, 130.74513975222413)).clickable(true)
            )

            setOnCircleClickListener { circle ->
                val toastText = when (circle.id) {
                    benten.id -> "弁天山公園"
                    manga.id -> "合志マンガミュージアム"
                    else -> "Unknown"
                }

                Toast.makeText(this@MapsActivity, "$toastText is tapped!!", Toast.LENGTH_SHORT).show()
            }
        }*/
    }
}