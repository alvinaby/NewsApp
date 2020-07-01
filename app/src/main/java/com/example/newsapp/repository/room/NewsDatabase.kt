package com.example.newsapp.repository.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newsapp.model.News

@Database(entities = [News::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao

    companion object {
        fun createDb(context: Context) =
            Room.databaseBuilder(context, NewsDatabase::class.java, "NewsDb").build()
    }
}