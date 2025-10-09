package com.example.rajkotexplore.nearby

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.rajkotexplore.R

class NearbyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nearby)

        // Back button
        val backBtn: ImageView = findViewById(R.id.btnBack)
        backBtn.setOnClickListener { finish() }

        // Buttons with toast
        findViewById<Button>(R.id.btnTourist).setOnClickListener { val intent =
            Intent(this, TouristActivity::class.java)
            startActivity(intent) }
        findViewById<Button>(R.id.btnReligious).setOnClickListener {val intent =
            Intent(this, ReligiousActivity::class.java)
            startActivity(intent) }
        findViewById<Button>(R.id.btnPark).setOnClickListener { val intent =
            Intent(this, ParkActivity::class.java)
            startActivity(intent) }
        findViewById<Button>(R.id.btnPicnic).setOnClickListener { val intent =
            Intent(this, PicnicActivity::class.java)
            startActivity(intent)}
        findViewById<Button>(R.id.btnRestaurant).setOnClickListener { val intent =
            Intent(this, RestaurantActivity::class.java)
            startActivity(intent)}
        }
    }