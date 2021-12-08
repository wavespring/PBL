package com.example.pbl

import android.content.Intent
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
        val intent = Intent(applicationContext, MapActivity::class.java)
        startActivity(intent)
    }
}