package com.example.pbl

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class vivre : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vivre)
    }
    fun onClickURL(view: View){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.city.koshi.lg.jp/kiji00312804/index.html"))
        startActivity(intent)
    }
}