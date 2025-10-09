package com.example.rajkotexplore.nearby

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.R

data class RestaurantPlace(
    val imageRestaurant: Int,
    val title: String,
    val location: String,
    val distance: String,
    val description: String
)

class RestaurantActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        // Back button
        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // Sample data
        val places = listOf(
            RestaurantPlace(R.drawable.r1, "Waves Restaurant", "Deluxe Cinema Chowk, Rajkot", "1.6 km", "Very popular for Gujarati thali and multicuisine options. A go-to place for local flavors."),
            RestaurantPlace(R.drawable.r2, "The Grand Thakar", "Jubilee Chowk, Rajkot", "1.1 km", "Known for Indian, Asian, and fusion dishes. Good ambience."),
            RestaurantPlace(R.drawable.rest3, "Sargam Food", "near Inox Cinema, Rajkot", "1.3 km", "Good for fast food / snacks / casual meals.."),
            RestaurantPlace(R.drawable.r4, "Lords Banquet Restaurant", "Kasturba Road, Rajkot", "1.1 km", "A banquet / restaurant setup, good for groups and events."),
            RestaurantPlace(R.drawable.rest5, "Amrut Restaurant", "near Railway Station", "very close", "good local food, often used for train catering.")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerRestaurant)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RestaurantAdapter(places)
    }
}
