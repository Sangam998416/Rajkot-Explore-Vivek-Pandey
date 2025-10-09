package com.example.rajkotexplore.nearby

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.R

data class PicnicPlace(
    val imagePicnic: Int,
    val title: String,
    val location: String,
    val distance: String,
    val description: String
)

class PicnicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picnic)

        // Back button
        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // Sample data
        val places = listOf(
            PicnicPlace(R.drawable.pic1, "Lal Pari Lake", "Rajkot", "5-6 km", "Swaminarayan temple in the heart of Rajkot city."),
            PicnicPlace(R.drawable.pic2, "Nyari Dam", "Rajkot", "13-14 km", "Quiet dam spot, good views, mild walking, relatively secluded."),
            PicnicPlace(R.drawable.pic3, "Analgadh Hill", "On Gondal Highway", "40 km", "Hill with scenic views, good place for photography, light trekking, enjoying landscapes.."),
            PicnicPlace(R.drawable.pic4, "Patanvav Osam Hill", "Patanvav, Saurashtra region", "110 km", "Hill station-like place, temples on hill, ruins, fresh air, nice for weekend picnic."),
            PicnicPlace(R.drawable.pic5, "Randarda Lake", "Near Pradhyuman Park", "10-12 km", "A natural shallow lake, good bird watching especially in winter.")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerPicnic)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PicnicAdapter(places)
    }
}
