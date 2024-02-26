// ArticleDetailActivity.kt
package com.example.ekspresiku

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myrecyclerview.R


class ArticleDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)

        // Mendapatkan data hero yang dikirim dari MainActivity
        val articleData = intent.getParcelableExtra<Article>("ARTICLE_DATA")

        // Menampilkan data article pada layout
        articleData?.let {
            supportActionBar?.title = it.title
            findViewById<TextView>(R.id.tv_article_title_detail).text = it.title
            findViewById<TextView>(R.id.tv_article_description_detail).text = it.description

            // Load foto menggunakan Glide atau metode lainnya
            Glide.with(this)
                .load(it.photo)
                .into(findViewById<ImageView>(R.id.img_article_detail))
        }
    }
}
