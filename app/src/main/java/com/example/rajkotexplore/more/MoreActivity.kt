package com.example.rajkotexplore.more

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.rajkotexplore.settings.AppInfoActivity
import com.example.rajkotexplore.settings.LogoActivity
import com.example.rajkotexplore.R

class MoreActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView
    private lateinit var optionAbout: LinearLayout
    private lateinit var optionSettings: LinearLayout
    private lateinit var optionContact: LinearLayout
    private lateinit var optionFeedback: LinearLayout
    private lateinit var optionDeveloper: LinearLayout

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

        // Back navigation
        btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }

        // About
        optionAbout.setOnClickListener {
            val intent = Intent(this, AppInfoActivity::class.java)
            startActivity(intent)
        }

        // Settings
        optionSettings.setOnClickListener {
            val intent = Intent(this, LogoActivity::class.java)
            startActivity(intent)
        }

        // Contact
        optionContact.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:+123456789")
            }
            startActivity(intent)
        }

        // Feedback
        optionFeedback.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:user@example.com")
            }
            startActivity(Intent.createChooser(emailIntent, "Send Feedback"))
        }

        // Developer
        optionDeveloper.setOnClickListener {
            val intent = Intent(this, DeveloperActivity::class.java)
            startActivity(intent)
        }
    }
}
