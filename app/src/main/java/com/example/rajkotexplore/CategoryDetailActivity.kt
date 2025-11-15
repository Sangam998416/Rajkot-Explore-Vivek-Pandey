package com.example.rajkotexplore

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_detail)

        val categoryName = intent.getStringExtra("CATEGORY_NAME") ?: "Category"
        val categoryType = intent.getStringExtra("CATEGORY_TYPE") ?: ""

        // Set title
        val txtTitle = findViewById<TextView>(R.id.txtCategoryTitle)
        txtTitle.text = categoryName

        // Back button
        val imgBack = findViewById<ImageView>(R.id.imgBack)
        imgBack.setOnClickListener {
            finish()
        }

        // Get filtered items based on category
        val filteredItems = getFilteredItems(categoryType)

        // Setup RecyclerView with Grid Layout
        val recyclerView = findViewById<RecyclerView>(R.id.rvCategoryItems)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columns
        recyclerView.adapter = CategoryGridAdapter(this, filteredItems, categoryType)
    }

    private fun getFilteredItems(categoryType: String): List<CardItem> {
        return when (categoryType.lowercase()) {
            "mount", "mountain" -> listOf(
                CardItem(
                    imageRes = R.drawable.n1,
                    title = "Pradhyuman Zoological Park",
                    description = "Pradhyuman Zoological Park is a beautiful zoo spread over 161 acres featuring various animals, birds, and reptiles. It's a perfect place for families and wildlife enthusiasts.",
                    location = "Jalaram Plot, Rajkot",
                    timing = "Open: 9:00 AM - 6:00 PM (Closed on Wednesday)",
                    latitude = 22.2734,
                    longitude = 70.7512
                ),
                CardItem(
                    imageRes = R.drawable.n3,
                    title = "Nyari Dam",
                    description = "Nyari Dam is a scenic spot perfect for picnics and nature walks. The dam offers beautiful views and a peaceful environment away from the city.",
                    location = "Nyari Village, Rajkot",
                    timing = "Open: 6:00 AM - 7:00 PM",
                    latitude = 22.2587,
                    longitude = 70.8597
                ),
                CardItem(
                    imageRes = R.drawable.n4,
                    title = "Aji Dam",
                    description = "Aji Dam is a popular tourist destination known for its scenic beauty and the Aji River. It's a great place for morning walks and photography.",
                    location = "Aji Dam Road, Rajkot",
                    timing = "Open: 24 Hours",
                    latitude = 22.3454,
                    longitude = 70.7865
                )
            )
            "beach" -> listOf(
                CardItem(
                    imageRes = R.drawable.n2,
                    title = "Lalpari Lake",
                    description = "Lalpari Lake is a serene lake surrounded by lush greenery. It's an ideal spot for boating, picnics, and spending quality time with family.",
                    location = "University Road, Rajkot",
                    timing = "Open: 5:00 AM - 9:00 PM",
                    latitude = 22.2876,
                    longitude = 70.7701
                ),
                CardItem(
                    imageRes = R.drawable.n5,
                    title = "Atal Sarowar",
                    description = "Atal Sarowar is a beautiful lake with well-maintained gardens. It offers boating facilities and is a popular spot for morning and evening walks.",
                    location = "Race Course Road, Rajkot",
                    timing = "Open: 6:00 AM - 8:00 PM",
                    latitude = 22.2912,
                    longitude = 70.7845
                )
            )
            "crater" -> listOf(
                CardItem(
                    imageRes = R.drawable.p3,
                    title = "Kaba Gandhi No Delo",
                    description = "Kaba Gandhi No Delo is the ancestral home of Mahatma Gandhi. This historic place showcases the life and times of the Father of the Nation.",
                    location = "Gheekanta Road, Rajkot",
                    timing = "Open: 9:00 AM - 12:00 PM, 3:00 PM - 6:00 PM",
                    latitude = 22.2987,
                    longitude = 70.7945
                ),
                CardItem(
                    imageRes = R.drawable.p4,
                    title = "Watson Museum",
                    description = "Watson Museum is the oldest museum in Gujarat showcasing artifacts from the colonial period, sculptures, and paintings.",
                    location = "Jubilee Garden, Rajkot",
                    timing = "Open: 9:00 AM - 1:00 PM, 2:30 PM - 5:45 PM (Closed on Wednesday & Public Holidays)",
                    latitude = 22.3012,
                    longitude = 70.8021
                )
            )
            "waterfall" -> listOf(
                CardItem(
                    imageRes = R.drawable.n2,
                    title = "Lalpari Lake",
                    description = "Lalpari Lake is a serene lake surrounded by lush greenery. It's an ideal spot for boating, picnics, and spending quality time with family.",
                    location = "University Road, Rajkot",
                    timing = "Open: 5:00 AM - 9:00 PM",
                    latitude = 22.2876,
                    longitude = 70.7701
                ),
                CardItem(
                    imageRes = R.drawable.n3,
                    title = "Nyari Dam",
                    description = "Nyari Dam is a scenic spot perfect for picnics and nature walks. The dam offers beautiful views and a peaceful environment away from the city.",
                    location = "Nyari Village, Rajkot",
                    timing = "Open: 6:00 AM - 7:00 PM",
                    latitude = 22.2587,
                    longitude = 70.8597
                )
            )
            "restaurant" -> listOf(
                CardItem(
                    imageRes = R.drawable.r1,
                    title = "Waves Restaurant",
                    description = "Waves Restaurant offers a diverse menu with authentic Gujarati and Indian cuisines. Known for its excellent service and ambiance.",
                    location = "Kalawad Road, Rajkot",
                    timing = "Open: 11:00 AM - 11:00 PM",
                    latitude = 22.2856,
                    longitude = 70.7689
                ),
                CardItem(
                    imageRes = R.drawable.r2,
                    title = "The Grand Thakar",
                    description = "The Grand Thakar is famous for its traditional Gujarati thali and delicious vegetarian dishes. A must-visit for food lovers.",
                    location = "Bhaktinagar Circle, Rajkot",
                    timing = "Open: 11:00 AM - 3:00 PM, 7:00 PM - 11:00 PM",
                    latitude = 22.2923,
                    longitude = 70.7812
                ),
                CardItem(
                    imageRes = R.drawable.r3,
                    title = "Saraza Restaurant",
                    description = "Saraza Restaurant specializes in North Indian and Chinese cuisine. Popular for family dining and special occasions.",
                    location = "Crystal Mall, Rajkot",
                    timing = "Open: 12:00 PM - 11:00 PM",
                    latitude = 22.2945,
                    longitude = 70.7892
                ),
                CardItem(
                    imageRes = R.drawable.r4,
                    title = "Lords Banquet Restaurant",
                    description = "Lords Banquet offers fine dining with multi-cuisine options. Perfect for celebrations and corporate events.",
                    location = "Gondal Road, Rajkot",
                    timing = "Open: 12:00 PM - 11:30 PM",
                    latitude = 22.2789,
                    longitude = 70.7645
                ),
                CardItem(
                    imageRes = R.drawable.r5,
                    title = "Gordhan Thal",
                    description = "Gordhan Thal is renowned for unlimited Gujarati thali with authentic flavors. A paradise for traditional food enthusiasts.",
                    location = "Kalavad Road, Rajkot",
                    timing = "Open: 11:00 AM - 3:00 PM, 7:00 PM - 10:30 PM",
                    latitude = 22.2867,
                    longitude = 70.7701
                )
            )
            "heritage" -> listOf(
                CardItem(
                    imageRes = R.drawable.h1,
                    title = "Watson Museum",
                    description = "Watson Museum is the oldest museum in Gujarat showcasing artifacts from the colonial period, precious sculptures, and paintings.",
                    location = "Jubilee Garden, Rajkot",
                    timing = "Open: 9:00 AM - 1:00 PM, 2:30 PM - 5:45 PM (Closed on Wednesday)",
                    latitude = 22.3012,
                    longitude = 70.8021
                ),
                CardItem(
                    imageRes = R.drawable.h2,
                    title = "Ranjit Vilas Palace",
                    description = "Ranjit Vilas Palace is a stunning example of Rajput architecture built in the 19th century. Now serves as a heritage hotel.",
                    location = "Gondal Road, Rajkot",
                    timing = "Open: 10:00 AM - 6:00 PM",
                    latitude = 22.2945,
                    longitude = 70.7589
                ),
                CardItem(
                    imageRes = R.drawable.h3,
                    title = "Mahatma Gandhi Museum",
                    description = "Gandhi Museum displays the life and philosophy of Mahatma Gandhi through photographs, letters, and personal belongings.",
                    location = "Gheekanta Road, Rajkot",
                    timing = "Open: 9:00 AM - 12:00 PM, 3:00 PM - 6:00 PM",
                    latitude = 22.2987,
                    longitude = 70.7945
                ),
                CardItem(
                    imageRes = R.drawable.h4,
                    title = "Jubilee Garden Library",
                    description = "Historic library located in beautiful Jubilee Garden. A peaceful place for reading and learning with colonial architecture.",
                    location = "Jubilee Garden, Rajkot",
                    timing = "Open: 8:00 AM - 8:00 PM",
                    latitude = 22.3015,
                    longitude = 70.8018
                ),
                CardItem(
                    imageRes = R.drawable.h5,
                    title = "Jam Tower",
                    description = "Jam Tower is an iconic landmark showcasing Indo-Saracenic architecture. Popular spot for photography and city views.",
                    location = "Jawahar Road, Rajkot",
                    timing = "Open: 24 Hours",
                    latitude = 22.2998,
                    longitude = 70.8012
                )
            )
            "palace" -> listOf(
                CardItem(
                    imageRes = R.drawable.p1,
                    title = "Ranjit Vilas Palace",
                    description = "Ranjit Vilas Palace is a stunning example of Rajput architecture built in the 19th century. Now serves as a heritage hotel.",
                    location = "Gondal Road, Rajkot",
                    timing = "Open: 10:00 AM - 6:00 PM",
                    latitude = 22.2945,
                    longitude = 70.7589
                ),
                CardItem(
                    imageRes = R.drawable.p2,
                    title = "KHIRASARA PALACE",
                    description = "Khirasara Palace is a beautiful heritage property showcasing royal architecture and rich history of the region.",
                    location = "Khirasara, Near Rajkot",
                    timing = "Open: 9:00 AM - 7:00 PM",
                    latitude = 22.3123,
                    longitude = 70.6987
                )
            )
            "university" -> listOf(
                CardItem(
                    imageRes = R.drawable.mu_fest,
                    title = "MU Fest, Marwadi University",
                    description = "Annual cultural festival at Marwadi University featuring music, dance, competitions, and various cultural activities.",
                    location = "Marwadi University, Rajkot",
                    timing = "Event Dates Vary",
                    latitude = 22.2734,
                    longitude = 70.7587
                ),
                CardItem(
                    imageRes = R.drawable.mu_ganesh,
                    title = "Ganesh Utsav, Marwadi University",
                    description = "Grand celebration of Ganesh Chaturthi at Marwadi University with traditional rituals and cultural programs.",
                    location = "Marwadi University, Rajkot",
                    timing = "September (Dates Vary)",
                    latitude = 22.2734,
                    longitude = 70.7587
                ),
                CardItem(
                    imageRes = R.drawable.mu1,
                    title = "Krishna Janmashtami",
                    description = "Joyful celebration of Lord Krishna's birth with traditional dances, music, and devotional activities.",
                    location = "Marwadi University, Rajkot",
                    timing = "August (Dates Vary)",
                    latitude = 22.2734,
                    longitude = 70.7587
                ),
                CardItem(
                    imageRes = R.drawable.mu_garbha,
                    title = "Mu Garbha Night",
                    description = "Vibrant Navratri celebration featuring traditional Garba and Dandiya performances by students.",
                    location = "Marwadi University, Rajkot",
                    timing = "October (During Navratri)",
                    latitude = 22.2734,
                    longitude = 70.7587
                ),
                CardItem(
                    imageRes = R.drawable.mu_tech,
                    title = "Mu Non Technical Event",
                    description = "Exciting non-technical events including debates, quizzes, cultural performances, and various competitions.",
                    location = "Marwadi University, Rajkot",
                    timing = "Event Dates Vary",
                    latitude = 22.2734,
                    longitude = 70.7587
                )
            )
            else -> listOf()
        }
    }
}