
package com.example.ekspresiku

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myrecyclerview.R

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        supportActionBar?.title = "About"

        findViewById<Button>(R.id.btnShare).setOnClickListener {
            shareAboutMe()
        }
    }

    private fun shareAboutMe() {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        val shareBody = "Nama: Alfauzi\nEmail: zhaqianroufa@gmail.com"
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(shareIntent, "Share About Me"))
    }

}
