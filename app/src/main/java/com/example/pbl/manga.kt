package com.example.pbl

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class manga : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manga)
    }
    fun onClickURL(view: View){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://koshi-mm.com"))
        startActivity(intent)
    }
}