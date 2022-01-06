package com.example.pbl

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.pbl.databinding.ActivityMapsBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

// val REQUEST_CODE_COORDINATES = 200
var nowLocate = LatLng(0.00, 0.00)

class MapsActivity : AppCompatActivity(), GoogleMap.OnInfoWindowClickListener, OnMapReadyCallback {

    // var isAccessLocationEnabled = false
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    companion object {
        private const val PERMISSION_REQUEST_CODE = 1234
    }

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestPermission()

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationClient.lastLocation
            .addOnSuccessListener {
                nowLocate = LatLng(it.latitude, it.longitude)
                // val tete = "${it.latitude} + ${it.longitude}"
                // Toast.makeText(applicationContext, tete, Toast.LENGTH_SHORT).show()
            }

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /* private fun requestPermission(){
        val permissionStatusOfLocation = ContextCompat.checkSelfPermission(this@MapsActivity, android.Manifest.permission.ACCESS_FINE_LOCATION)
        if (permissionStatusOfLocation == PackageManager.PERMISSION_GRANTED) getCoordinates() else permissionRequest()
    }

    private fun permissionRequest() {
        val isNeedDialogOfLocation: Boolean =
            ActivityCompat.shouldShowRequestPermissionRationale(
                this@MapsActivity,
                android.Manifest.permission.ACCESS_FINE_LOCATION)

        if (!isNeedDialogOfLocation) {
            //requestPermission()メソッドを実行する
            ActivityCompat.requestPermissions(
                this@MapsActivity,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_CODE_COORDINATES)
            return
        }

        AlertDialog.Builder(this@MapsActivity).apply {
            setTitle("位置情報取得には許可が必要になります。")
            setMessage("許可を得ないと位置情報を取得せずに終了することになります。ご注意下さい。")
            setPositiveButton("許可する"){dialog, which ->
                //requestPermission()メソッドの実行
                ActivityCompat.requestPermissions(
                    this@MapsActivity,
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                    REQUEST_CODE_COORDINATES)
            }
            setNegativeButton("許可しない"){dialog, which ->
                Toast.makeText(this@MapsActivity, "許可が得られなかったので中止しました。", Toast.LENGTH_SHORT).show()
                finish()
            }
        }.show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode != REQUEST_CODE_COORDINATES) return

        if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
            finish()
            return
        }
        getCoordinates()
    }


    fun getCoordinates(){
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationClient.lastLocation.addOnSuccessListener {
            Toast.makeText(this, "座標点を取得しました。", Toast.LENGTH_SHORT).show()
            val latitude: String = it.latitude.toString()
            val longitude: String = it.longitude.toString()
        }

    }*/


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.isZoomControlsEnabled = true
        if(nowLocate == LatLng(0.00, 0.00)){
            nowLocate = LatLng(32.876636, 130.748012)
            Toast.makeText(applicationContext, "位置情報が取得できていません。一度戻るボタンを押して再度開いてください。", Toast.LENGTH_LONG).show()
        }
        mMap.addMarker(
            MarkerOptions()
                .position(nowLocate).title("現在地")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                //.icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_locate))
        )
        // val kosen = LatLng(32.876636, 130.748012)
        //mMap.addMarker(MarkerOptions().position(kosen).title("熊本高専"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nowLocate, 16.0f))

        mMap.apply {
            setLatLngBoundsForCameraTarget(
                LatLngBounds(LatLng(32.82, 130.72), LatLng(32.92, 130.86))
            )
        }

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(32.89766790022332, 130.72482516043988))
                .title("弁天山公園")
                //.snippet("公園")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(32.89282222121129, 130.7326265882746))
                .title("合志市総合健康センター ユーパレス弁天")
                //.snippet("合志市総合健康センター")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(32.890706037312476, 130.74526442005148))
                .title("西合志図書館")
                //.snippet("図書館")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(32.892047625585505, 130.7327558484365))
                .title("クラッシーノ・マルシェ")
                //.snippet("スーパーマーケット")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(32.891141269672715, 130.74518604674898))
                .title("合志マンガミュージアム")
                //.snippet("博物館")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(32.88610626409156, 130.79130626416375))
                .title("合志市総合センター「ヴィーブル」")
                //.snippet("福祉・文化・体育の総合拠点")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(32.880861022305965, 130.785767929906))
                .title("合志物産館 志来菜彩")
                //.snippet("物産館")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(32.88919956391348, 130.75905627328592))
                .title("熊本県農業公園 カントリーパーク")
                //.snippet("公園")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(32.86616513577165, 130.76835693191995))
                .title("元気の森公園")
                //.snippet("公園")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(32.89916656814804, 130.79402843418774))
                .title("竹迫城跡公園")
                //.snippet("公園")
        )

        mMap.addMarker(
            MarkerOptions()
                .position(LatLng(32.875268085137876, 130.78232257769895))
                .title("飯高山公園")
                //.snippet("公園")
        )

        mMap.setOnInfoWindowClickListener(this)
    }

    override fun onInfoWindowClick(p0: Marker) {
        val place = p0.title
        when (place){
            "合志市総合健康センター ユーパレス弁天" -> {
                val intent = Intent(applicationContext, benten::class.java)
                startActivity(intent)
            }
            "西合志図書館" -> {
                val intent = Intent(applicationContext, tosyo::class.java)
                startActivity(intent)
            }
            "クラッシーノ・マルシェ" -> {
                val intent = Intent(applicationContext, marche::class.java)
                startActivity(intent)
            }
            "合志マンガミュージアム" -> {
                val intent = Intent(applicationContext, manga::class.java)
                startActivity(intent)
            }
            "合志市総合センター「ヴィーブル」" -> {
                val intent = Intent(applicationContext, vivre::class.java)
                startActivity(intent)
            }
            "合志物産館 志来菜彩" -> {
                val intent = Intent(applicationContext, sikisai::class.java)
                startActivity(intent)
            }
            "弁天山公園" -> {
                val intent = Intent(applicationContext, bentenyama::class.java)
                startActivity(intent)
            }
            "熊本県農業公園 カントリーパーク" -> {
                val intent = Intent(applicationContext, country::class.java)
                startActivity(intent)
            }
            "元気の森公園" -> {
                val intent = Intent(applicationContext, genki::class.java)
                startActivity(intent)
            }
            "飯高山公園" -> {
                val intent = Intent(applicationContext, iitaka::class.java)
                startActivity(intent)
            }
            "竹迫城跡公園" -> {
                val intent = Intent(applicationContext, take::class.java)
                startActivity(intent)
            }
        }
    }

    private fun requestPermission() {
        val permissionAccessCoarseLocationApproved =
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) ==
                    PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) ==
                    PackageManager.PERMISSION_GRANTED

        if (permissionAccessCoarseLocationApproved) {
            // 位置情報の権限OK
        } else {
            // 位置情報の権限が無いため、許可を求める
            ActivityCompat.requestPermissions(this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                PERMISSION_REQUEST_CODE
            )
        }
    }
}