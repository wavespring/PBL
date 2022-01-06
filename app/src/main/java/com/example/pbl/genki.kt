package com.example.pbl

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class genki : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genki)
    }
    fun onClickURL(view: View){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.city.koshi.lg.jp/kiji0033877/index.html"))
        startActivity(intent)
    }
}