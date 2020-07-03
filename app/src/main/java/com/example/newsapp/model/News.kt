package com.example.newsapp.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NewsDb")
data class News(
    @PrimaryKey @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "thumbnail")
    val thumbnail: String,

    @ColumnInfo(name = "publishTime")
    val publishTime: String,

    @ColumnInfo(name = "url")
    val url: String,

    @Embedded(prefix = "publisher_")
    val publisher: Publisher
)
