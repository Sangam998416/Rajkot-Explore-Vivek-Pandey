package com.example.rajkotexplore.nearby

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rajkotexplore.R

class UniversityActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var universityAdapter: UniversityAdapter
    private lateinit var universityList: List<UniversityItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_university)

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        recyclerView = findViewById(R.id.recyclerUniversity)

        // Back navigation
        btnBack.setOnClickListener {
            onBackPressed()
        }

        // Dummy data for universities
        universityList = listOf(
            UniversityItem(
                R.drawable.mu_u1,
                "Marwadi University",
                "Known for its innovation, infrastructure, and quality education in Rajkot."
            ),
            UniversityItem(
                R.drawable.atmiya_u2,
                "Atmiya University",
                "Focuses on value-based education and research in science and technology."
            ),
            UniversityItem(
                R.drawable.darshan,
                "Darshan University",
                "Offers strong engineering and management programs with modern facilities."
            ),
            UniversityItem(
                R.drawable.rkuniver,
                "RK University",
                "A multidisciplinary campus emphasizing practical learning and global exposure."
            ),
            UniversityItem(
                R.drawable.saurastraun,
                "Saurashtra University",
                "One of the oldest universities, promoting regional culture and academics."
            )
        )

        // Setup RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        universityAdapter = UniversityAdapter(universityList)
        recyclerView.adapter = universityAdapter
    }
}
