package com.example.rajkotexplore

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EventDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_adapter_detail)

        // Get data from intent
        val title = intent.getStringExtra("EVENT_TITLE") ?: ""
        val organizer = intent.getStringExtra("EVENT_ORGANIZER") ?: ""
        val category = intent.getStringExtra("EVENT_CATEGORY") ?: ""
        val date = intent.getStringExtra("EVENT_DATE") ?: ""
        val time = intent.getStringExtra("EVENT_TIME") ?: ""
        val venue = intent.getStringExtra("EVENT_VENUE") ?: ""
        val price = intent.getStringExtra("EVENT_PRICE") ?: ""
        val description = intent.getStringExtra("EVENT_DESCRIPTION") ?: ""
        val imageRes = intent.getIntExtra("EVENT_IMAGE", 0)
        val latitude = intent.getDoubleExtra("EVENT_LATITUDE", 22.2734)
        val longitude = intent.getDoubleExtra("EVENT_LONGITUDE", 70.7587)

        // Initialize views
        val imgBack = findViewById<ImageView>(R.id.imgBack)
        val imgEvent = findViewById<ImageView>(R.id.imgEvent)
        val txtTitle = findViewById<TextView>(R.id.txtEventTitle)
        val txtOrganizer = findViewById<TextView>(R.id.txtOrganizer)
        val txtCategory = findViewById<TextView>(R.id.txtCategory)
        val txtDate = findViewById<TextView>(R.id.txtDate)
        val txtTime = findViewById<TextView>(R.id.txtTime)
        val txtVenue = findViewById<TextView>(R.id.txtVenue)
        val txtPrice = findViewById<TextView>(R.id.txtPrice)
        val txtDescription = findViewById<TextView>(R.id.txtDescription)
        val btnGetDirections = findViewById<Button>(R.id.btnGetDirections)

        // Set data to views
        imgEvent.setImageResource(imageRes)
        txtTitle.text = title
        txtOrganizer.text = "Organized by: $organizer"
        txtCategory.text = "Category: $category"
        txtDate.text = date
        txtTime.text = time
        txtVenue.text = venue
        txtPrice.text = price
        txtDescription.text = description

        // Back button
        imgBack.setOnClickListener {
            finish()
        }

        // Get directions button
        btnGetDirections.setOnClickListener {
            openGoogleMaps(latitude, longitude, venue)
        }
    }

    private fun openGoogleMaps(latitude: Double, longitude: Double, venue: String) {
        val uri = Uri.parse("geo:$latitude,$longitude?q=$latitude,$longitude($venue)")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.setPackage("com.google.android.apps.maps")

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            // If Google Maps is not installed, open in browser
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://maps.google.com/?q=$latitude,$longitude")
            )
            startActivity(browserIntent)
        }
    }
}