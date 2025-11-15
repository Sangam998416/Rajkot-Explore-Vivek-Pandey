package com.example.rajkotexplore.category

import com.example.rajkotexplore.R

// Data class with coordinates
data class CategoryEvent(
    val id: Int,
    val image: Int,
    val title: String,
    val date: String,
    val venue: String,
    val time: String,
    val description: String,
    val price: String = "Free Entry",
    val organizer: String = "",
    val category: String,
    val latitude: Double = 22.2734,
    val longitude: Double = 70.7587
)

// Object to hold all event category data
object CategoryDataProvider {

    fun getGarbhaEvents(): List<CategoryEvent> {
        return listOf(
            CategoryEvent(
                1,
                R.drawable.c1,
                "Sahiyar Club Navratri",
                "24-09 to 01-10-2025",
                "Sahiyar Club, Rajkot",
                "08:00 PM to 12:00 AM",
                "Experience the vibrant celebration of Navratri with traditional Garba and Dandiya nights. Featuring live orchestra, celebrity performances, and authentic Gujarati cultural programs.",
                "₹500 per person",
                "Sahiyar Club",
                "Garbha",
                22.2800,
                70.7600
            ),
            CategoryEvent(
                2,
                R.drawable.c2,
                "Bamboo Beats Mahotsav",
                "27-09 to 02-10-2025",
                "Race Course Ground, Rajkot",
                "07:00 PM to 11:00 PM",
                "A fusion of traditional Garba with modern beats. One of the largest Navratri celebrations in Saurashtra with DJ nights and live performances.",
                "₹800 per person",
                "Bamboo Events",
                "Garbha",
                22.2960,
                70.7982
            ),
            CategoryEvent(
                3,
                R.drawable.c3,
                "Abtak SURBHI Rasotsav",
                "27-09 to 30-09-2025",
                "BRTS Ground, Rajkot",
                "08:45 PM onwards",
                "Premium Navratri celebration organized by Abtak Channel with celebrity performances and grand stage setups.",
                "₹1000 per person",
                "Abtak News",
                "Garbha",
                22.2950,
                70.8020
            ),
            CategoryEvent(
                4,
                R.drawable.c4,
                "Sanatan Navratri Utsav",
                "22-09 to 02-10-2025",
                "Sanatan Mandir Complex, Rajkot",
                "08:00 PM to 12:00 AM",
                "Traditional and authentic Navratri celebration with focus on cultural values and classical Garba.",
                "Free Entry",
                "Sanatan Dharma Trust",
                "Garbha",
                22.2850,
                70.7700
            )
        )
    }

    fun getExhibitionEvents(): List<CategoryEvent> {
        return listOf(
            CategoryEvent(
                5,
                R.drawable.ex1,
                "Engiexpo Rajkot 2025",
                "24-Oct-2025 to 27-Oct-2025",
                "Race Course Ground, Rajkot",
                "10:00 AM to 08:00 PM",
                "Engineering and technology exhibition showcasing latest innovations, machinery, and industrial solutions. Network with industry leaders and explore cutting-edge technology.",
                "₹100 per person",
                "Engiexpo India",
                "Exhibition",
                22.2960,
                70.7982
            ),
            CategoryEvent(
                6,
                R.drawable.ex2,
                "Swayamvar Rajkot",
                "03-Jan-2026 to 05-Jan-2026",
                "Shyamdham Convention, Rajkot",
                "11:00 AM to 09:00 PM",
                "A remarkable matrimonial exhibition bringing together families for traditional matchmaking. Features horoscope matching, family meetings, and cultural programs.",
                "Free Entry",
                "Swayamvar Events",
                "Exhibition",
                22.2900,
                70.7650
            ),
            CategoryEvent(
                7,
                R.drawable.auto_expor,
                "Auto Expo Rajkot",
                "15-Dec-2025 to 18-Dec-2025",
                "Rajkot Exhibition Ground",
                "10:00 AM to 08:00 PM",
                "Automobile exhibition featuring latest car models, bikes, and automotive accessories. Test drives available.",
                "₹50 per person",
                "Auto Expo India",
                "Exhibition",
                22.3000,
                70.8100
            )
        )
    }

    fun getFairsEvents(): List<CategoryEvent> {
        return listOf(
            CategoryEvent(
                8,
                R.drawable.f1,
                "Royal Mela Rajkot",
                "14-08-2025 to 18-08-2025",
                "Race Course Ground, Rajkot",
                "04:00 PM to 11:00 PM",
                "An annual fair featuring thrilling rides, attractions, food stalls, and entertainment for all age groups. Includes Giant Wheel, Columbus, and various game zones.",
                "₹50 entry",
                "Royal Entertainment",
                "Fair",
                22.2960,
                70.7982
            ),
            CategoryEvent(
                9,
                R.drawable.f2,
                "Janmashtami Lok Mela",
                "16-08-2025 to 20-08-2025",
                "Racecourse Road, Rajkot",
                "05:00 PM to 11:00 PM",
                "The most famous fair celebrating Janmashtami with traditional handicrafts, cultural performances, and delicious street food from across Gujarat.",
                "Free Entry",
                "Rajkot Municipal Corporation",
                "Fair",
                22.2965,
                70.7990
            ),
            CategoryEvent(
                10,
                R.drawable.diwali_mela,
                "Diwali Shopping Mela",
                "20-Oct-2025 to 25-Oct-2025",
                "Crystal Mall Grounds, Rajkot",
                "11:00 AM to 10:00 PM",
                "Grand shopping festival with stalls selling traditional wear, jewelry, handicrafts, and Diwali decorations.",
                "Free Entry",
                "Retailers Association",
                "Fair",
                22.2850,
                70.7800
            )
        )
    }

    fun getCulturalEvents(): List<CategoryEvent> {
        return listOf(
            CategoryEvent(
                11,
                R.drawable.cul1,
                "International Kite Festival",
                "14-Jan-2026",
                "Riverside Ground, Rajkot",
                "06:00 AM onwards",
                "The flourishing city of Rajkot celebrates Uttarayan with international kite flyers. Watch spectacular kites from different countries and enjoy traditional Gujarati food.",
                "Free Entry",
                "Gujarat Tourism",
                "Cultural",
                22.2900,
                70.7900
            ),
            CategoryEvent(
                12,
                R.drawable.cul2,
                "Navratri Festival",
                "22-Sep-2025 to 30-Sep-2025",
                "Various Locations, Rajkot",
                "Evening to Night",
                "One festival that truly stands out and has gained popularity across Gujarat. Traditional nine-night celebration with Garba and Dandiya.",
                "Varies by venue",
                "Cultural Committee",
                "Cultural",
                22.2734,
                70.7587
            ),
            CategoryEvent(
                13,
                R.drawable.rann_utsav,
                "Rann Utsav Cultural Program",
                "15-Nov-2025",
                "Race Course Ground, Rajkot",
                "07:00 PM to 10:00 PM",
                "Experience the culture of Kutch with folk dances, music, and traditional crafts. A glimpse into Gujarat's rich heritage.",
                "₹200 per person",
                "Gujarat Tourism",
                "Cultural",
                22.2960,
                70.7982
            )
        )
    }

    fun getReligiousEvents(): List<CategoryEvent> {
        return listOf(
            CategoryEvent(
                14,
                R.drawable.rel1,
                "Maha Shivaratri Celebration",
                "26-Feb-2026",
                "Ramdev Peer Temple, Rajkot",
                "All Night (06:00 PM to 06:00 AM)",
                "Grand celebration of Maha Shivaratri with abhishek, bhajans, and spiritual discourses. Special darshan arrangements throughout the night.",
                "Free Entry",
                "Temple Trust",
                "Religious",
                22.2700,
                70.7500
            ),
            CategoryEvent(
                15,
                R.drawable.rel2,
                "Ram Navami Mahotsav",
                "06-Apr-2026",
                "ISKCON Temple, Rajkot",
                "05:00 AM to 10:00 PM",
                "Celebrate the birth of Lord Rama with special puja, Ramayana recitation, and prasad distribution. Cultural programs throughout the day.",
                "Free Entry",
                "ISKCON Rajkot",
                "Religious",
                22.2800,
                70.7750
            ),
            CategoryEvent(
                16,
                R.drawable.rel3,
                "Ganesh Chaturthi Celebration",
                "07-Sep-2025 to 17-Sep-2025",
                "Various Mandals, Rajkot",
                "Morning to Night",
                "Ten-day celebration of Lord Ganesha with elaborate pandals, cultural programs, and grand processions on Anant Chaturdashi.",
                "Free Entry",
                "Ganesh Mandal Federation",
                "Religious",
                22.2734,
                70.7587
            ),
            CategoryEvent(
                17,
                R.drawable.rel4,
                "Diwali Maha Lakshmi Puja",
                "01-Nov-2025",
                "Swaminarayan Temple, Rajkot",
                "Evening",
                "Special Lakshmi Puja on Diwali with traditional rituals, aarti, and lighting of diyas. Distribution of prasad and sweets.",
                "Free Entry",
                "Swaminarayan Gadi",
                "Religious",
                22.2750,
                70.7680
            )
        )
    }

    fun getEventsByCategory(category: String): List<CategoryEvent> {
        return when(category.lowercase()) {
            "garbha" -> getGarbhaEvents()
            "exhibition" -> getExhibitionEvents()
            "fairs" -> getFairsEvents()
            "cultural" -> getCulturalEvents()
            "religious" -> getReligiousEvents()
            else -> emptyList()
        }
    }
}