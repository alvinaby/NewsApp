package com.example.newsapp.data.room

import androidx.room.ColumnInfo

data class NewsLocalData (
    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "thumbnail")
    val thumbnail: String,

    @ColumnInfo(name = "url")
    val url: String,

    @ColumnInfo(name = "publisher_name")
    val publisherName: String
)