package com.example.rajkotexplore.nearby

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.R

data class TouristPlace(
    val imageRes: Int,
    val title: String,
    val location: String,
    val distance: String,
    val description: String
)

class TouristActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tourist)

        // Back button
        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // Sample data
        val places = listOf(
            TouristPlace(R.drawable.p1, "Ranjeet Bilash Palace", "Rajkot", "5 km from station", "A historic palace with beautiful architecture."),
            TouristPlace(R.drawable.p2, "Khirasara Palace", "Rajkot", "5 km from station", "A famous heritage site."),
            TouristPlace(R.drawable.p3, "Kaba Gandhi No Delo", "Rajkot", "3 km", "Iconic landmark by the sea."),
            TouristPlace(R.drawable.p4, "Watson Museum", "Rajkot", "4 km", "Historic mosque and monument."),
            TouristPlace(R.drawable.p5, "Mahatma Gandhi Museum", "Lohana Para, Rajkot", "1.8 km", "Converted into a museum with 39 galleries, light & sound show.")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recycleTourist)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TouristAdapter(places)
    }
}
