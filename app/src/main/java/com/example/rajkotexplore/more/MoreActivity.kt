package com.example.rajkotexplore.more

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.rajkotexplore.CategoryEventActivity
import com.example.rajkotexplore.MainActivity
import com.example.rajkotexplore.R
import com.example.rajkotexplore.nearby.UniversityActivity
import com.example.rajkotexplore.settings.LogoActivity
import com.example.rajkotexplore.settings.settingActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MoreActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView
    private lateinit var optionAbout: LinearLayout
    private lateinit var optionSettings: LinearLayout
    private lateinit var optionContact: LinearLayout
    private lateinit var optionFeedback: LinearLayout
    private lateinit var optionDeveloper: LinearLayout
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)

        // Initialize views
        btnBack = findViewById(R.id.btnBack)
        optionAbout = findViewById(R.id.optionAbout)
        optionSettings = findViewById(R.id.optionSettings)
        optionContact = findViewById(R.id.optionContact)
        optionFeedback = findViewById(R.id.optionFeedback)
        optionDeveloper = findViewById(R.id.optiondeveloper)
        bottomNavigation = findViewById(R.id.bottomNavigation)

        // Set bottom navigation selected item to More
        bottomNavigation.selectedItemId = R.id.nav_more

        // Setup Bottom Navigation
        setupBottomNavigation()

        // Back navigation
        btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // About
        optionAbout.setOnClickListener {
            val intent = Intent(this, settingActivity::class.java)
            startActivity(intent)
        }

        // Settings
        optionSettings.setOnClickListener {
            val intent = Intent(this, LogoActivity::class.java)
            startActivity(intent)
        }

        // Contact
        optionContact.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:ceapps@marwadieducation.edu.in")
            }
            startActivity(Intent.createChooser(intent, "Contact Us"))
        }

        // Feedback
        optionFeedback.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:ceapps@marwadieducation.edu.in?subject=Feedback for Rajkot Explore")
            }
            startActivity(Intent.createChooser(emailIntent, "Send Feedback"))
        }

        // Developer
        optionDeveloper.setOnClickListener {
            val intent = Intent(this, DeveloperActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupBottomNavigation() {
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_category -> {
                    startActivity(Intent(this, CategoryEventActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_university -> {
                    startActivity(Intent(this, UniversityActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_more -> {
                    // Already on More page
                    true
                }
                else -> false
            }
        }
    }
}