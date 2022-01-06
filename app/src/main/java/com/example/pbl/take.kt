package com.example.pbl

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class take : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take)
    }
    fun onClickURL(view: View){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.city.koshi.lg.jp/kiji0033864/index.html"))
        startActivity(intent)
    }
}