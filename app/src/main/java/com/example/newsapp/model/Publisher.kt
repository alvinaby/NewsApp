package com.example.newsapp.model

import androidx.room.Embedded

data class Publisher (
    val name: String,
    val url: String,
    @Embedded(prefix = "image_")
    val image: Image
)
