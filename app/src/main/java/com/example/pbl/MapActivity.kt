package com.example.pbl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
    }

    fun onBackButtonClick(view : View){
        finish()
    }
}