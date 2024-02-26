package com.example.ekspresiku

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecyclerview.R

class MainActivity : AppCompatActivity() {
    private lateinit var rvArticles: RecyclerView
    private val list = ArrayList<Article>()
    private val splashTimeOut: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvArticles = findViewById(R.id.rv_articles)
        rvArticles.setHasFixedSize(true)
        list.addAll(listArticles)
//        delayedSplash()
        showRecyclerList()

    }
//    private fun delayedSplash() {
//        Handler().postDelayed({
//            // Pindah ke halaman utama setelah splash screen selesai
//            startActivity(Intent(this, MainActivity::class.java))
//            finish()
//        }, splashTimeOut)
//    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
//            R.id.action_list -> {
//                rvArticles.layoutManager = LinearLayoutManager(this)
//            }
//            R.id.action_grid -> {
//                rvArticles.layoutManager = GridLayoutManager(this, 2)
//            }
            R.id.about_page -> {
                openAboutPage()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openAboutPage() {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }

    private val listArticles: ArrayList<Article>
        get() {
            val dataArticle = resources.getStringArray(R.array.data_title)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
            val listArticle = ArrayList<Article>()
            for (i in dataArticle.indices) {
                val article = Article(dataArticle[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
                (listArticle)
                listArticle.add(article)
            }
            return listArticle
        }

    private fun showRecyclerList() {
        val layoutManager = LinearLayoutManager(this)
        rvArticles.layoutManager = layoutManager
        val listHeroAdapter = ListArticleAdapter(list)
        rvArticles.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListArticleAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Article) {
                showSelectedHero(data)
            }
        })
    }

    private fun showSelectedHero(hero: Article) {
        Toast.makeText(this, "Kamu memilih ${hero.title}", Toast.LENGTH_SHORT).show()
    }
}
