package com.example.pbl

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** Called when the user taps the Map button */
    fun openMap(view: View) {
        val intent = Intent(applicationContext, MapsActivity::class.java)
        startActivity(intent)
    }

    fun openList(view: View) {
        val intent = Intent(applicationContext, Facilities::class.java)
        startActivity(intent)
    }

    fun openSch(view: View) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.city.koshi.lg.jp/kiji00319932/3_19932_12070_up_7msohhel.pdf"))
        startActivity(intent)
    }
}
