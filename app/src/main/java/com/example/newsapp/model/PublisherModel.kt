package com.example.newsapp.model

data class PublisherModel (
    val name: String,
    val url: String,
    val image: Image
){ inner class Image(val url: String) }