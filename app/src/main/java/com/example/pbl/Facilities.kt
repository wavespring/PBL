package com.example.pbl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class Facilities : AppCompatActivity() {

        private val texts = arrayOf(
            "合志総合健康センター ユーパレス弁天",
            "クラッシーノ・マルシェ",
            "合志マンガミュージアム",
            "総合センターヴィーブル",
            "合志物産館 志来菜彩",
            "弁天山公園",
            "熊本県農業公園 カントリーパーク",
            "元気の森公園",
            "妙泉寺公園",
            "飯高山公園",
            "蛇ノ尾公園"
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val listView = ListView(this)
        setContentView(listView)

        val arrayAdapter = ArrayAdapter(this,
                    android.R.layout.simple_list_item_1, texts)

        listView.adapter = arrayAdapter

        listView.setOnItemClickListener {_, view, _, _ ->
            // listViewのクリックされた行のテキストを取得
            val item = (view.findViewById<TextView>(android.R.id.text1)).text

            /*if(item == "合志総合健康センター ユーパレス弁天"){
                val intent = Intent(applicationContext, benten::class.java)
                startActivity(intent)
            }*/
            when (item) {
                "合志総合健康センター ユーパレス弁天" -> {
                    val intent = Intent(applicationContext, benten::class.java)
                    startActivity(intent)
                }
                "クラッシーノ・マルシェ" -> {
                    val intent = Intent(applicationContext, marche::class.java)
                    startActivity(intent)
                }
                "合志マンガミュージアム" -> {
                    val intent = Intent(applicationContext, manga::class.java)
                    startActivity(intent)
                }
                "総合センターヴィーブル" -> {
                    val intent = Intent(applicationContext, vivre::class.java)
                    startActivity(intent)
                }
                "合志物産館 志来菜彩" -> {
                    val intent = Intent(applicationContext, sikisai::class.java)
                    startActivity(intent)
                }
                "弁天山公園" -> {
                    val intent = Intent(applicationContext, bentenyama::class.java)
                    startActivity(intent)
                }
                "熊本県農業公園 カントリーパーク" -> {
                    val intent = Intent(applicationContext, country::class.java)
                    startActivity(intent)
                }
                "元気の森公園" -> {
                    val intent = Intent(applicationContext, genki::class.java)
                    startActivity(intent)
                }
                else -> {
                    val tete = "詳細情報が存在しません。"
                    Toast.makeText(applicationContext, tete, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}