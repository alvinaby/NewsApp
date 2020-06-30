package com.example.newsapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "NewsDb")
data class News(
    @PrimaryKey @ColumnInfo(name = "id")
    var id: String = "",

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "thumbnail")
    var thumbnail: String? = null,

    @ColumnInfo(name = "publishTime")
    var publishTime: String? = null,

    @ColumnInfo(name = "url")
    var url: String? = null,

    @Ignore
    var publisher: Publisher? = null
)
