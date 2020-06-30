package com.example.newsapp.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsapp.model.News

@Database(entities = [News::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}