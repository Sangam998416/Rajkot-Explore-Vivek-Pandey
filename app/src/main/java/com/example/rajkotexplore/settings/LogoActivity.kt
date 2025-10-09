package com.example.rajkotexplore.settings

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.rajkotexplore.R

class LogoActivity : AppCompatActivity() {

    private lateinit var shareApp: TextView
    private lateinit var rateUs: TextView
    private lateinit var feedback: TextView
    private lateinit var contactUs: TextView
    private lateinit var privacyPolicy: TextView
    private lateinit var versionText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)
        supportActionBar?.hide()

        // Find views
        shareApp = findViewById(R.id.txtShare)
        rateUs = findViewById(R.id.txtRate)
        feedback = findViewById(R.id.txtFeed)
        contactUs = findViewById(R.id.txtContact)
        privacyPolicy = findViewById(R.id.txtPolicy)
        versionText = findViewById(R.id.txtVersion)

        // App version
        versionText.text =
            "Version " + packageManager.getPackageInfo(packageName, 0).versionName

        // Toolbar buttons
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val btnInfo1: ImageButton = findViewById(R.id.btnInfo1)
        val btnInfo2: ImageButton = findViewById(R.id.btnInfo2)

        // Navigation back
        btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }

        // Share app
        shareApp.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Check out this awesome Rajkot Explore app: https://play.google.com/store/apps/details?id=com.example.rajkotexplore"
                )
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }

        // Rate us
        rateUs.setOnClickListener {
            val uri = Uri.parse("market://details?id=com.example.rajkotexplore")
            val goToMarket = Intent(Intent.ACTION_VIEW, uri)
            startActivity(goToMarket)
        }

        // Feedback
        feedback.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:user@example.com")
                putExtra(Intent.EXTRA_SUBJECT, "App Feedback")
            }
            startActivity(emailIntent)
        }

        // Contact Us
        contactUs.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:+1234567890")
            }
            startActivity(intent)
        }

        // Privacy Policy
        privacyPolicy.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://yourapp.com/privacy")
            )
            startActivity(intent)
        }

        // Gif click → navigate to AppInfoActivity
        btnInfo1.setOnClickListener {
            val intent = Intent(this, AppInfoActivity::class.java)
            startActivity(intent)
        }
        btnInfo2.setOnClickListener {
            val intent = Intent(this, AppInfoActivity::class.java)
            startActivity(intent)
        }

        // Load GIFs into buttons
        Glide.with(this)
            .asGif()
            .load(R.drawable.btnrkt) // must exist in drawable
            .into(btnInfo1)

        Glide.with(this)
            .asGif()
            .load(R.drawable.btnexp) // must exist in drawable
            .into(btnInfo2)
    }
}
