package com.example.newsapp.model

data class News(
    val id: String,
    val title: String,
    val thumbnail: String,
    val publishTime: String,
    val url: String,
    val publisher: Publisher
)
