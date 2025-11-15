package com.example.rajkotexplore.settings

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rajkotexplore.R
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.card.MaterialCardView

class settingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appinfo)

        setupToolbar()
        setupClickListeners()
    }

    private fun setupToolbar() {
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setupClickListeners() {
        // Version Card - Show toast
        findViewById<MaterialCardView>(R.id.cardVersion).setOnClickListener {
            Toast.makeText(this, "Rajkot Explore v1.0.0", Toast.LENGTH_SHORT).show()
        }

        // Share App Card
        findViewById<MaterialCardView>(R.id.cardShare).setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, "Rajkot Explore App")
                putExtra(Intent.EXTRA_TEXT, """
                    Check out Rajkot Explore - Your ultimate guide to exploring Rajkot!
                    
                    ✨ Discover events, universities, restaurants, and tourist attractions
                    📍 Find nearby places and cultural spots
                    🎓 Explore educational institutions
                    🍽️ Best dining experiences
                    
                    Download the app and explore Rajkot like never before!
                """.trimIndent())
            }
            startActivity(Intent.createChooser(shareIntent, "Share App"))
        }
    }
}