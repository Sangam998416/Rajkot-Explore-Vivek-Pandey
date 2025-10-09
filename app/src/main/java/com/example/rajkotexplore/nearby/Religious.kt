package com.example.rajkotexplore.nearby

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.R

data class ReligiousPlace(
    val imageRes: Int,
    val title: String,
    val location: String,
    val distance: String,
    val description: String
)

class ReligiousActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_religious)

        // Back button
        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // Sample data
        val places = listOf(
            ReligiousPlace(R.drawable.rel1, "Shree Swaminarayan Main Mandir", "Bhupendra Road, Rajkot", "0.75 km", "Swaminarayan temple in the heart of Rajkot city."),
            ReligiousPlace(R.drawable.rel2, "Jagnath Shri Mahavirswami", "Jagnath Plot, Rajkot", "0.86 km", "Quiet and revered, especially among Jain community."),
            ReligiousPlace(R.drawable.rel3, "Jay Naklankdham (Ramapir Temple)", "Kalavad Road, Rajkot", "12 km", "A large temple complex dedicated to Ramdevji with beautiful construction."),
            ReligiousPlace(R.drawable.rel4, "Ramcharit Manas Temple", "Ratanpar", "15 km", "This temple is devoted to Lord Ram, with carvings of parts of Ramayana."),
            ReligiousPlace(R.drawable.rel5, "Sacred Heart Cathedral (Prem Mandir)", "Kalawad Road", "5-6 km", "A Roman Catholic cathedral of the Syro-Malabar Rite.")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerReligious)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ReligiousAdapter(places)
    }
}
