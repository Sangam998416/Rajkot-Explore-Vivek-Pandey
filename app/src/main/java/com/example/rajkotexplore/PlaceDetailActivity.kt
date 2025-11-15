package com.example.rajkotexplore

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.rajkotexplore.more.MoreActivity
import com.example.rajkotexplore.nearby.UniversityActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class PlaceDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_detail)

        // Get data from intent
        val placeImage = intent.getIntExtra("PLACE_IMAGE", R.drawable.p1)
        val placeTitle = intent.getStringExtra("PLACE_TITLE") ?: "Place"
        val placeCategory = intent.getStringExtra("PLACE_CATEGORY") ?: "Category"
        val placeDescription = intent.getStringExtra("PLACE_DESCRIPTION") ?: "This is a beautiful place located in Rajkot."
        val placeLocation = intent.getStringExtra("PLACE_LOCATION") ?: "Rajkot, Gujarat"
        val placeTiming = intent.getStringExtra("PLACE_TIMING") ?: "Open: 9:00 AM - 6:00 PM"
        val latitude = intent.getDoubleExtra("PLACE_LATITUDE", 22.3039)
        val longitude = intent.getDoubleExtra("PLACE_LONGITUDE", 70.8022)

        // Set views
        val imgPlace = findViewById<ImageView>(R.id.imgPlace)
        val txtPlaceTitle = findViewById<TextView>(R.id.txtPlaceTitle)
        val txtPlaceCategory = findViewById<TextView>(R.id.txtPlaceCategory)
        val txtDescription = findViewById<TextView>(R.id.txtDescription)
        val txtLocation = findViewById<TextView>(R.id.txtLocation)
        val txtTiming = findViewById<TextView>(R.id.txtTiming)
        val imgBack = findViewById<ImageView>(R.id.imgBackDetail)
        val btnDirections = findViewById<CardView>(R.id.btnDirections)
        val btnShare = findViewById<CardView>(R.id.btnShare)

        // Set data to views
        imgPlace.setImageResource(placeImage)
        txtPlaceTitle.text = placeTitle
        txtPlaceCategory.text = placeCategory.uppercase()
        txtDescription.text = placeDescription
        txtLocation.text = placeLocation
        txtTiming.text = placeTiming

        // Back button
        imgBack.setOnClickListener {
            finish()
        }

        // Get Directions - Open Google Maps with ACCURATE SEARCH using place name
        btnDirections.setOnClickListener {
            openGoogleMapsAccurate(placeTitle, placeLocation, latitude, longitude)
        }

        // Share button
        btnShare.setOnClickListener {
            sharePlace(placeTitle, placeLocation)
        }

        // Bottom Navigation (if exists in layout)
        setupBottomNavigation()
    }

    /**
     * Opens Google Maps with accurate location using place name + address
     * This is MOST accurate as it combines place name with specific address
     */
    private fun openGoogleMapsAccurate(placeName: String, location: String, latitude: Double, longitude: Double) {
        try {
            // PRIMARY METHOD: Search by place name + address + Rajkot (most accurate)
            val searchQuery = if (location.isNotEmpty() && location != "Rajkot, Gujarat") {
                // Include both place name and address for maximum accuracy
                "$placeName, $location, Rajkot, Gujarat, India"
            } else {
                // Fallback if location is generic
                "$placeName, Rajkot, Gujarat, India"
            }

            val encodedQuery = Uri.encode(searchQuery)
            val gmmIntentUri = Uri.parse("https://www.google.com/maps/search/?api=1&query=$encodedQuery")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")

            if (mapIntent.resolveActivity(packageManager) != null) {
                startActivity(mapIntent)
            } else {
                // If Google Maps not installed, open in browser
                startActivity(Intent(Intent.ACTION_VIEW, gmmIntentUri))
            }
        } catch (e: Exception) {
            // Fallback: Try with coordinates if search fails
            openGoogleMapsWithCoordinates(latitude, longitude, placeName)
        }
    }

    /**
     * Fallback method using coordinates
     */
    private fun openGoogleMapsWithCoordinates(latitude: Double, longitude: Double, placeName: String) {
        try {
            val encodedPlaceName = Uri.encode(placeName)
            val gmmIntentUri = Uri.parse("geo:$latitude,$longitude?q=$latitude,$longitude($encodedPlaceName)")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")

            if (mapIntent.resolveActivity(packageManager) != null) {
                startActivity(mapIntent)
            } else {
                val browserIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com/maps/search/?api=1&query=$latitude,$longitude")
                )
                startActivity(browserIntent)
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Unable to open maps", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sharePlace(placeName: String, location: String) {
        // Create Google Maps search link using place name + address
        val searchQuery = if (location.isNotEmpty() && location != "Rajkot, Gujarat") {
            "$placeName, $location, Rajkot, Gujarat, India"
        } else {
            "$placeName, Rajkot, Gujarat, India"
        }
        val encodedQuery = Uri.encode(searchQuery)
        val mapsLink = "https://www.google.com/maps/search/?api=1&query=$encodedQuery"

        val shareText = """
            Check out this amazing place! 🌟
            
            📍 $placeName
            📌 $location
            
            🗺️ View on Maps: $mapsLink
            
            Shared via Rajkot Explore App
        """.trimIndent()

        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareText)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }

    private fun setupBottomNavigation() {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNav?.selectedItemId = R.id.nav_home
        bottomNav?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_category -> {
                    startActivity(Intent(this, CategoryEventActivity::class.java))
                    true
                }
                R.id.nav_university -> {
                    startActivity(Intent(this, UniversityActivity::class.java))
                    true
                }
                R.id.nav_more -> {
                    startActivity(Intent(this, MoreActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}