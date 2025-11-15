package com.example.rajkotexplore

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewAllActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all)

        // Get data from intent
        val sectionTitle = intent.getStringExtra("SECTION_TITLE") ?: "All Items"
        val sectionType = intent.getStringExtra("SECTION_TYPE") ?: ""

        // Set title
        val txtTitle = findViewById<TextView>(R.id.txtViewAllTitle)
        txtTitle.text = sectionTitle

        // Back button
        val imgBack = findViewById<ImageView>(R.id.imgBackViewAll)
        imgBack.setOnClickListener {
            finish()
        }

        // Get items based on section type
        val items = getSectionItems(sectionType)

        // Setup RecyclerView with Grid Layout
        val recyclerView = findViewById<RecyclerView>(R.id.rvViewAllItems)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columns
        recyclerView.adapter = CategoryGridAdapter(this, items, sectionType)
    }

    private fun getSectionItems(sectionType: String): List<CardItem> {
        return when (sectionType) {
            "events" -> listOf(
                CardItem(
                    imageRes = R.drawable.e1,
                    title = "Music Fest",
                    description = "An amazing music festival featuring local and international artists. Experience live performances, food stalls, and a vibrant atmosphere perfect for music lovers.",
                    location = "Race Course Ground, Rajkot",
                    timing = "Event: 5:00 PM - 11:00 PM",
                    latitude = 22.2912,
                    longitude = 70.7845
                ),
                CardItem(
                    imageRes = R.drawable.e2,
                    title = "Kite Festival",
                    description = "Celebrate the joyous occasion of Uttarayan with colorful kites filling the sky. Traditional Gujarati festival with food, music, and kite flying competitions.",
                    location = "Various Locations, Rajkot",
                    timing = "Event: January 14-15 (All Day)",
                    latitude = 22.3039,
                    longitude = 70.8022
                ),
                CardItem(
                    imageRes = R.drawable.e3,
                    title = "Garba Fest",
                    description = "Experience the vibrant Navratri celebrations with traditional Garba and Dandiya performances. Join thousands in this colorful festival of dance and devotion.",
                    location = "Jubilee Garden, Rajkot",
                    timing = "Event: 8:00 PM - 12:00 AM (During Navratri)",
                    latitude = 22.3015,
                    longitude = 70.8018
                ),
                CardItem(
                    imageRes = R.drawable.e4,
                    title = "Dubai Real Estate Event",
                    description = "Exclusive real estate expo showcasing premium properties in Dubai. Meet developers, explore investment opportunities, and get expert consultation.",
                    location = "Hotel Imperial Palace, Rajkot",
                    timing = "Event: 10:00 AM - 6:00 PM",
                    latitude = 22.2945,
                    longitude = 70.7892
                ),
                CardItem(
                    imageRes = R.drawable.e5,
                    title = "Sangeet Mai Zaroor Aana",
                    description = "A grand musical evening featuring renowned artists and traditional performances. Perfect for families and music enthusiasts.",
                    location = "Rajkot Convention Centre",
                    timing = "Event: 7:00 PM - 10:00 PM",
                    latitude = 22.2876,
                    longitude = 70.7701
                )
            )
            "nearby" -> listOf(
                CardItem(
                    imageRes = R.drawable.p1,
                    title = "Ranjit Vilas Palace",
                    description = "A stunning example of Rajput architecture built in the 19th century. This magnificent palace showcases intricate designs and now serves as a heritage hotel.",
                    location = "Gondal Road, Rajkot",
                    timing = "Open: 10:00 AM - 6:00 PM",
                    latitude = 22.2945,
                    longitude = 70.7589
                ),
                CardItem(
                    imageRes = R.drawable.p2,
                    title = "KHIRASARA PALACE",
                    description = "A beautiful heritage property showcasing royal architecture and rich history of the region. Experience the grandeur of Rajkot's royal past.",
                    location = "Khirasara, Near Rajkot",
                    timing = "Open: 9:00 AM - 7:00 PM",
                    latitude = 22.3123,
                    longitude = 70.6987
                ),
                CardItem(
                    imageRes = R.drawable.p3,
                    title = "Kaba Gandhi No Delo",
                    description = "The ancestral home of Mahatma Gandhi where he spent his childhood. This historic place showcases the life and times of the Father of the Nation.",
                    location = "Gheekanta Road, Rajkot",
                    timing = "Open: 9:00 AM - 12:00 PM, 3:00 PM - 6:00 PM",
                    latitude = 22.2987,
                    longitude = 70.7945
                ),
                CardItem(
                    imageRes = R.drawable.p4,
                    title = "Watson Museum",
                    description = "The oldest museum in Gujarat showcasing artifacts from the colonial period, precious sculptures, paintings, and historical documents.",
                    location = "Jubilee Garden, Rajkot",
                    timing = "Open: 9:00 AM - 1:00 PM, 2:30 PM - 5:45 PM (Closed Wednesday)",
                    latitude = 22.3012,
                    longitude = 70.8021
                ),
                CardItem(
                    imageRes = R.drawable.p5,
                    title = "Rotary Dolls Museum",
                    description = "A unique museum displaying dolls from around the world representing different cultures and traditions. Educational and entertaining for all ages.",
                    location = "Jubilee Garden, Rajkot",
                    timing = "Open: 9:00 AM - 6:00 PM (Closed Monday)",
                    latitude = 22.3010,
                    longitude = 70.8025
                )
            )
            "nature" -> listOf(
                CardItem(
                    imageRes = R.drawable.n1,
                    title = "Pradhyuman Zoological Park",
                    description = "A beautiful zoo spread over 161 acres featuring various animals, birds, and reptiles. Perfect place for families and wildlife enthusiasts with well-maintained enclosures.",
                    location = "Jalaram Plot, Rajkot",
                    timing = "Open: 9:00 AM - 6:00 PM (Closed Wednesday)",
                    latitude = 22.2734,
                    longitude = 70.7512
                ),
                CardItem(
                    imageRes = R.drawable.n2,
                    title = "Lalpari Lake",
                    description = "A serene lake surrounded by lush greenery. Ideal spot for boating, picnics, and spending quality time with family. Beautiful sunset views and peaceful atmosphere.",
                    location = "University Road, Rajkot",
                    timing = "Open: 5:00 AM - 9:00 PM",
                    latitude = 22.2876,
                    longitude = 70.7701
                ),
                CardItem(
                    imageRes = R.drawable.n3,
                    title = "Nyari Dam",
                    description = "A scenic spot perfect for picnics and nature walks. The dam offers beautiful views and a peaceful environment away from the city hustle.",
                    location = "Nyari Village, Rajkot",
                    timing = "Open: 6:00 AM - 7:00 PM",
                    latitude = 22.2587,
                    longitude = 70.8597
                ),
                CardItem(
                    imageRes = R.drawable.n4,
                    title = "Aji Dam",
                    description = "A popular tourist destination known for its scenic beauty and the Aji River. Great place for morning walks, photography, and bird watching.",
                    location = "Aji Dam Road, Rajkot",
                    timing = "Open: 24 Hours",
                    latitude = 22.3454,
                    longitude = 70.7865
                ),
                CardItem(
                    imageRes = R.drawable.n5,
                    title = "Atal Sarowar",
                    description = "A beautiful lake with well-maintained gardens and walking tracks. Offers boating facilities and is a popular spot for morning and evening walks.",
                    location = "Race Course Road, Rajkot",
                    timing = "Open: 6:00 AM - 8:00 PM",
                    latitude = 22.2912,
                    longitude = 70.7845
                )
            )
            "restaurants" -> listOf(
                CardItem(
                    imageRes = R.drawable.r1,
                    title = "Waves Restaurant",
                    description = "Offers a diverse menu with authentic Gujarati and Indian cuisines. Known for its excellent service, beautiful ambiance, and rooftop seating.",
                    location = "Kalawad Road, Rajkot",
                    timing = "Open: 11:00 AM - 11:00 PM",
                    latitude = 22.2856,
                    longitude = 70.7689
                ),
                CardItem(
                    imageRes = R.drawable.r2,
                    title = "The Grand Thakar",
                    description = "Famous for its traditional Gujarati thali and delicious vegetarian dishes. A must-visit for food lovers wanting authentic Gujarati cuisine.",
                    location = "Bhaktinagar Circle, Rajkot",
                    timing = "Open: 11:00 AM - 3:00 PM, 7:00 PM - 11:00 PM",
                    latitude = 22.2923,
                    longitude = 70.7812
                ),
                CardItem(
                    imageRes = R.drawable.r3,
                    title = "Saraza Restaurant",
                    description = "Specializes in North Indian and Chinese cuisine with a modern twist. Popular for family dining, celebrations, and special occasions.",
                    location = "Crystal Mall, Rajkot",
                    timing = "Open: 12:00 PM - 11:00 PM",
                    latitude = 22.2945,
                    longitude = 70.7892
                ),
                CardItem(
                    imageRes = R.drawable.r4,
                    title = "Lords Banquet Restaurant",
                    description = "Fine dining experience with multi-cuisine options and elegant ambiance. Perfect for celebrations, corporate events, and special gatherings.",
                    location = "Gondal Road, Rajkot",
                    timing = "Open: 12:00 PM - 11:30 PM",
                    latitude = 22.2789,
                    longitude = 70.7645
                ),
                CardItem(
                    imageRes = R.drawable.r5,
                    title = "Gordhan Thal",
                    description = "Renowned for unlimited Gujarati thali with authentic flavors and traditional recipes. A paradise for traditional food enthusiasts.",
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
                    description = "The oldest museum in Gujarat showcasing artifacts from the colonial period, precious sculptures, paintings, and historical documents from British era.",
                    location = "Jubilee Garden, Rajkot",
                    timing = "Open: 9:00 AM - 1:00 PM, 2:30 PM - 5:45 PM (Closed Wednesday)",
                    latitude = 22.3012,
                    longitude = 70.8021
                ),
                CardItem(
                    imageRes = R.drawable.h2,
                    title = "Ranjit Vilas Palace",
                    description = "A magnificent palace built in 19th century showcasing Rajput architecture. Marvel at the intricate designs and royal heritage of Rajkot.",
                    location = "Gondal Road, Rajkot",
                    timing = "Open: 10:00 AM - 6:00 PM",
                    latitude = 22.2945,
                    longitude = 70.7589
                ),
                CardItem(
                    imageRes = R.drawable.h3,
                    title = "Mahatma Gandhi Museum",
                    description = "Displays the life and philosophy of Mahatma Gandhi through photographs, letters, and personal belongings. A tribute to the Father of the Nation.",
                    location = "Gheekanta Road, Rajkot",
                    timing = "Open: 9:00 AM - 12:00 PM, 3:00 PM - 6:00 PM",
                    latitude = 22.2987,
                    longitude = 70.7945
                ),
                CardItem(
                    imageRes = R.drawable.h4,
                    title = "Jubilee Garden Library",
                    description = "Historic library located in beautiful Jubilee Garden. A peaceful place for reading and learning with stunning colonial architecture.",
                    location = "Jubilee Garden, Rajkot",
                    timing = "Open: 8:00 AM - 8:00 PM",
                    latitude = 22.3015,
                    longitude = 70.8018
                ),
                CardItem(
                    imageRes = R.drawable.h5,
                    title = "Jam Tower",
                    description = "An iconic landmark showcasing Indo-Saracenic architecture. Popular spot for photography and admiring the architectural beauty of old Rajkot.",
                    location = "Jawahar Road, Rajkot",
                    timing = "Open: 24 Hours (Exterior View)",
                    latitude = 22.2998,
                    longitude = 70.8012
                )
            )
            "university" -> listOf(
                CardItem(
                    imageRes = R.drawable.mu_fest,
                    title = "MU Fest, Marwadi University",
                    description = "Annual cultural festival featuring music, dance, competitions, tech events, and various cultural activities. Students from across Gujarat participate.",
                    location = "Marwadi University, Rajkot",
                    timing = "Event Dates Vary (Usually February-March)",
                    latitude = 22.2734,
                    longitude = 70.7587
                ),
                CardItem(
                    imageRes = R.drawable.mu_ganesh,
                    title = "Ganesh Utsav, Marwadi University",
                    description = "Grand celebration of Ganesh Chaturthi with traditional rituals, cultural programs, and devotional activities involving entire university community.",
                    location = "Marwadi University, Rajkot",
                    timing = "September (10 Days Celebration)",
                    latitude = 22.2734,
                    longitude = 70.7587
                ),
                CardItem(
                    imageRes = R.drawable.mu1,
                    title = "Krishna Janmashtami",
                    description = "Joyful celebration of Lord Krishna's birth with traditional dances, music, devotional songs, and midnight celebration following the rituals.",
                    location = "Marwadi University, Rajkot",
                    timing = "August (Date Varies - Full Day Event)",
                    latitude = 22.2734,
                    longitude = 70.7587
                ),
                CardItem(
                    imageRes = R.drawable.mu_garbha,
                    title = "Mu Garbha Night",
                    description = "Vibrant Navratri celebration featuring traditional Garba and Dandiya performances by students. Colorful attire, music, and traditional food.",
                    location = "Marwadi University, Rajkot",
                    timing = "October (During Navratri - 9:00 PM onwards)",
                    latitude = 22.2734,
                    longitude = 70.7587
                ),
                CardItem(
                    imageRes = R.drawable.mu_tech,
                    title = "Mu Non Technical Event",
                    description = "Exciting non-technical events including debates, quizzes, cultural performances, competitions, and talent shows showcasing student creativity.",
                    location = "Marwadi University, Rajkot",
                    timing = "Event Dates Vary Throughout Year",
                    latitude = 22.2734,
                    longitude = 70.7587
                )
            )
            else -> listOf()
        }
    }
}