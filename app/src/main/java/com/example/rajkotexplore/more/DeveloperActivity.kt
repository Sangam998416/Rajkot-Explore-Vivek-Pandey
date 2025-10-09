package com.example.rajkotexplore.more

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rajkotexplore.R

class DeveloperActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developer)

        // Optional: click on developer photo to show a toast
        findViewById<ImageView>(R.id.ivDev1Photo).setOnClickListener {
            Toast.makeText(this, "Vivek Pandey ", Toast.LENGTH_SHORT).show()
        }
        findViewById<ImageView>(R.id.ivDev2Photo).setOnClickListener {
            Toast.makeText(this, "Sushil Kumar ", Toast.LENGTH_SHORT).show()
        }
        findViewById<ImageView>(R.id.ivGuidePhoto).setOnClickListener {
            Toast.makeText(this, "Mr. Jigar Dave", Toast.LENGTH_SHORT).show()
        }
    }
}