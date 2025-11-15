package com.example.rajkotexplore.settings

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.rajkotexplore.R

class LogoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        supportActionBar?.hide()

        setupViews()
        setupClickListeners()
    }

    private fun setupViews() {
        // Set app version
        val versionText = findViewById<TextView>(R.id.txtVersion)
        try {
            val versionName = packageManager.getPackageInfo(packageName, 0).versionName
            versionText.text = "Version $versionName"
        } catch (e: Exception) {
            versionText.text = "Version 1.0.0"
        }

        // Load GIFs into buttons using Glide
        val btnInfo1 = findViewById<ImageButton>(R.id.btnInfo1)
        val btnInfo2 = findViewById<ImageButton>(R.id.btnInfo2)

        Glide.with(this)
            .asGif()
            .load(R.drawable.btnrkt)
            .into(btnInfo1)

        Glide.with(this)
            .asGif()
            .load(R.drawable.btnexp)
            .into(btnInfo2)
    }

    private fun setupClickListeners() {
        // Back button
        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Share app
        findViewById<LinearLayout>(R.id.btnShare).setOnClickListener {
            shareApp()
        }

        // Rate us
        findViewById<LinearLayout>(R.id.btnRate).setOnClickListener {
            rateApp()
        }

        // Feedback
        findViewById<LinearLayout>(R.id.btnFeedback).setOnClickListener {
            sendFeedback()
        }

        // Contact us
        findViewById<LinearLayout>(R.id.btnContact).setOnClickListener {
            contactUs()
        }

        // Privacy policy
        findViewById<LinearLayout>(R.id.btnPrivacy).setOnClickListener {
            openPrivacyPolicy()
        }

        // Info buttons - Navigate to AppInfoActivity
        findViewById<ImageButton>(R.id.btnInfo1).setOnClickListener {
            val intent = Intent(this, settingActivity::class.java)
            startActivity(intent)
        }

        findViewById<ImageButton>(R.id.btnInfo2).setOnClickListener {
            val intent = Intent(this, settingActivity::class.java)
            startActivity(intent)
        }
    }

    private fun shareApp() {
        val shareText = """
            🌟 Discover Rajkot Like Never Before! 🌟
            
            Check out Rajkot Explore - Your ultimate guide to exploring Rajkot!
            
            ✨ Discover events, universities, restaurants, and tourist attractions
            📍 Find nearby places and cultural spots
            🎓 Explore educational institutions
            🍽️ Best dining experiences
            
            Download the app and explore Rajkot like never before!
            
            https://play.google.com/store/apps/details?id=$packageName
        """.trimIndent()

        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, "Rajkot Explore App")
            putExtra(Intent.EXTRA_TEXT, shareText)
        }
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }

    private fun rateApp() {
        try {
            val uri = Uri.parse("market://details?id=$packageName")
            val goToMarket = Intent(Intent.ACTION_VIEW, uri)
            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
            startActivity(goToMarket)
        } catch (e: Exception) {
            // If Play Store is not installed, open in browser
            val uri = Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }
    }

    private fun sendFeedback() {
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:ceapps@marwadieducation.edu.in")
            putExtra(Intent.EXTRA_SUBJECT, "Rajkot Explore App Feedback")
            putExtra(Intent.EXTRA_TEXT, """
                App Version: ${getVersionName()}
                Device: ${android.os.Build.MANUFACTURER} ${android.os.Build.MODEL}
                Android Version: ${android.os.Build.VERSION.RELEASE}
                
                Feedback:
                
            """.trimIndent())
        }

        try {
            startActivity(Intent.createChooser(emailIntent, "Send Feedback"))
        } catch (e: Exception) {
            Toast.makeText(this, "No email app found", Toast.LENGTH_SHORT).show()
        }
    }

    private fun contactUs() {
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:ceapps@marwadieducation.edu.in")
            putExtra(Intent.EXTRA_SUBJECT, "Contact Request")
        }
        try {
            startActivity(emailIntent)
        } catch (e: Exception) {
            Toast.makeText(this, "No email app found", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openPrivacyPolicy() {
        val intent = Intent(this, PrivacyPolicyActivity::class.java)
        startActivity(intent)
    }

    private fun getVersionName(): String {
        return try {
            packageManager.getPackageInfo(packageName, 0).versionName ?: "1.0.0"
        } catch (e: Exception) {
            "1.0.0"
        }
    }
}