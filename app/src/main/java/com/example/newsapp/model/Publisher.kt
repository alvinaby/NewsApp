package com.example.newsapp.model

data class PublisherModel (
    val name: String,
    val url: String,
    val image: Image
)
data class Image (val publisherImage: String)