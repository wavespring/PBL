package com.example.pbl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class benten : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_benten)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}