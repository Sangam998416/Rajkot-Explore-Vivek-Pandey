package com.example.rajkotexplore

data class CardItem(
    val imageRes: Int? = null,
    val imageUrl: String? = null, // URL for image
    val title: String,
    val videoUrl: String? = null // URL for video
)
