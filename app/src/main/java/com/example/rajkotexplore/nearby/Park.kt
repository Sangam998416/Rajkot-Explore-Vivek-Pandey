package com.example.rajkotexplore.nearby

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.R

data class ParkPlace(
    val imageRes: Int,
    val title: String,
    val location: String,
    val distance: String,
    val description: String
)

class ParkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_park)

        // Back button
        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // Sample data
        val places = listOf(
            ParkPlace(R.drawable.park1, "pradyuman park", "Lalpari Lake area, Rajkot", "5-6 km", "A large zoo-park spread over ~137 acres, with many animals."),
            ParkPlace(R.drawable.park2, "Iswariya Park", "Jamnagar Road, Rajkot", "8 km", "nice environment, good for relaxing with friends/family.."),
            ParkPlace(R.drawable.park3, "Jubilee Garden", "Lohana Para, Rajkot", "2-3 km", "A well-known open garden in the centre, good for strolls, greenery."),
            ParkPlace(R.drawable.park4, "Aji Park area", "Around Aji Dam, Rajkot", "7-10 km", "Scenic spot by the river/dam, gardens, peaceful surroundings."),
            ParkPlace(R.drawable.park5, "Municipal Park", "Chandra Park area, Rajkot", "4-6 km", "Nice neighborhood park, good for morning/evening walks, jogging, relaxation.")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerPark)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ParkAdapter(places)
    }
}
