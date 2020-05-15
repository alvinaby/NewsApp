package com.example.newsapp.model

data class NewsModel(
    val id: String,
    val title: String,
    val thumbnail: String,
    val publish_time: String,
    val url: String,
    val publisher: PublisherModel
)