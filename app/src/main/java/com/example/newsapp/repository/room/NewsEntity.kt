package com.example.newsapp.repository.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newsapp.model.Publisher

@Entity
data class NewsEntity (
    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "thumbnail")
    val thumbnail: String,

    @ColumnInfo(name = "url")
    val url: String,

    @ColumnInfo(name = "publisher_name")
    val publisherName: String
)