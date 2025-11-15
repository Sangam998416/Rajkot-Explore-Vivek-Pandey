package com.example.rajkotexplore.more

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.rajkotexplore.R
import com.google.android.material.card.MaterialCardView

class DeveloperActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developer)
        supportActionBar?.hide()

        setupBackButton()
        setupDeveloperCards()
    }

    private fun setupBackButton() {
        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setupDeveloperCards() {
        // Developer 1 - Vivek Pandey
        findViewById<MaterialCardView>(R.id.cardDev1).setOnClickListener {
            showDeveloperDialog(
                name = "Vivek Pandey",
                role = "Full Stack Developer",
                education = "B.Tech, Computer Engineering",
                skills = "\n• Android Development\n• Kotlin & Java\n• UI/UX Design\n• Database Management"
            )
        }

        // Developer 2 - Sushil Kumar
        findViewById<MaterialCardView>(R.id.cardDev2).setOnClickListener {
            showDeveloperDialog(
                name = "Sushil Kumar",
                role = "Android Developer",
                education = "B.Tech, Computer Engineering",
                skills = "\n• Android Development\n• Kotlin Programming\n• API Integration\n• Backend Development"
            )
        }

        // Guide
        findViewById<MaterialCardView>(R.id.cardGuide).setOnClickListener {
            showGuideDialog()
        }

        // Individual photo clicks for quick info
        findViewById<ImageView>(R.id.ivDev1Photo).setOnClickListener {
            Toast.makeText(this, "Vivek Pandey - Full Stack Developer", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.ivDev2Photo).setOnClickListener {
            Toast.makeText(this, "Sushil Kumar - Android Developer", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.ivGuidePhoto).setOnClickListener {
            Toast.makeText(this, "Mr. Jigar Dave - Assistant Professor", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showDeveloperDialog(
        name: String,
        role: String,
        education: String,
        skills: String
    ) {
        val message = """
            $role
            
            📚 Education:
            $education
            
            💡 Skills:
            $skills
        """.trimIndent()

        AlertDialog.Builder(this)
            .setTitle(name)
            .setMessage(message)
            .setPositiveButton("Close", null)
            .show()
    }

    private fun showGuideDialog() {
        val message = """
            Assistant Professor
            Faculty of Engineering & Technology
            Marwadi University, Rajkot
            
            🎓 Expertise:
            • Computer Engineering
            • Software Development
            • Project Guidance
            
            📚 Role:
            Our mentor and guide throughout the development of Rajkot Explore. His guidance and expertise have been invaluable to this project.
        """.trimIndent()

        AlertDialog.Builder(this)
            .setTitle("Mr. Jigar Dave")
            .setMessage(message)
            .setPositiveButton("Close", null)
            .show()
    }
}