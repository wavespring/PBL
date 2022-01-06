package com.example.pbl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.net.Uri


class benten : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_benten)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    fun onClickURL(view: View){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.city.koshi.lg.jp/kiji0039962/index.html"))
        startActivity(intent)
    }
}