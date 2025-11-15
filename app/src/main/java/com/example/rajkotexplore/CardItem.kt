package com.example.rajkotexplore

data class CardItem(
    val imageRes: Int? = null,
    val imageUrl: String? = null,
    val title: String,
    val description: String = "This is a beautiful place located in Rajkot. It offers amazing views and a great experience for visitors. Come and explore the rich culture and heritage of this wonderful destination.",
    val location: String = "Rajkot, Gujarat",
    val timing: String = "Open: 9:00 AM - 6:00 PM",
    val latitude: Double = 22.3039,  // Default Rajkot coordinates
    val longitude: Double = 70.8022
)