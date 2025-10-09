package com.example.rajkotexplore.settings

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.rajkotexplore.R

class AppInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appinfo)

        val txtAbout: TextView = findViewById(R.id.txtAboutDetails)
        // Back button
        val backBtn: ImageView = findViewById(R.id.btnBack)
        backBtn.setOnClickListener { finish() }
        // Set about text dynamically
        txtAbout.text = "✨ Rajkot Explore ✨\n\n" +
                "Personalized recommendations based on your interests. " +
                "💡 Easy-to-use interface for quick searching..\n\n" +
                "💡 Discover nearby places, events, and attractions.\n" +
                "💡 Save your favorite spots for future visits.\n"+
                "💡 Find popular attractions, landmarks, and cultural spots.\n"+
                "💡 Explore restaurants, cafes, and local street food."
    }
}