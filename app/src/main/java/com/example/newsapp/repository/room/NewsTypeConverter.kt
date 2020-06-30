package com.example.newsapp.repository.room

import androidx.room.TypeConverter
import com.example.newsapp.model.Publisher

class NewsTypeConverter {
    @TypeConverter
    fun publisherToString(publisher: Publisher): String = publisher.toString()
}