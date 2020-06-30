package com.example.newsapp.repository

import android.content.Context
import androidx.room.Room
import com.example.newsapp.model.News
import com.example.newsapp.repository.room.NewsDao
import com.example.newsapp.repository.room.NewsDatabase
import io.reactivex.Observable

class LocalRepo : NewsRepoInterface{

//    fun roomBuilder(context: Context) {
//        val db = Room.databaseBuilder(context, NewsDatabase::class.java, "NewsDb").build()
//        val newsList =
//        db.newsDao().insertNews()
//    }

    override fun getNews(): Observable<List<News>> {
        TODO()
    }
}