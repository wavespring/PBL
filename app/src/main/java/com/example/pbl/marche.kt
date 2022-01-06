package com.example.pbl

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class marche : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marche)
    }
    fun onClickURL1(view: View){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://kumamoto.guide/spots/detail/12005"))
        startActivity(intent)
    }
    fun onClickURL2(view: View){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.klassino-koshi.jp/benten/"))
        startActivity(intent)
    }
}