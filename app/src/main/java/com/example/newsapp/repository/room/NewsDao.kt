package com.example.newsapp.repository.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsapp.model.News

@Dao
interface NewsDao {
    @Query("SELECT * FROM NewsEntity")
    fun getNews(): List<NewsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(news: List<NewsEntity>)
}