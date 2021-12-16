package com.example.pbl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class Facilities : AppCompatActivity() {

        private val texts = arrayOf("弁天山公園", "合志マンガミュージアム", "合志市役所")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val listView = ListView(this)
        setContentView(listView)

        val arrayAdapter = ArrayAdapter(this,
                    android.R.layout.simple_list_item_1, texts)

        listView.adapter = arrayAdapter
    }
}