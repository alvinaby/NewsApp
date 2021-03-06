package com.alvinaby.newsapp.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alvinaby.newsapp.model.News
import io.reactivex.Observable

@Dao
interface NewsDao {
    @Query("SELECT * FROM newsEntity")
    fun getNews(): Observable<List<News>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(news: List<News>)
}