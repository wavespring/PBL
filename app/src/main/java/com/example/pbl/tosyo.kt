package com.example.pbl

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class tosyo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tosyo)
    }
    fun onClickURL(view: View){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.koshi-lib.jp/shisetsu/nishigoshi/"))
        startActivity(intent)
    }
}