package com.example.pbl

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class sikisai : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sikisai)
    }
    fun onClickURL1(view: View){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://kumamoto.guide/spots/detail/12008"))
        startActivity(intent)
    }
    fun onClickURL2(view: View){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://shikisaisai.net"))
        startActivity(intent)
    }
}