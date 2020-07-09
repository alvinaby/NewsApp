package com.example.newsapp.repository.local

import android.content.Context
import com.example.newsapp.data.room.NewsDatabase
import com.example.newsapp.model.News
import io.reactivex.Observable

class LocalRepo(context: Context) : LocalRepoInterface {
    private val newsDao = NewsDatabase.createDb(context).newsDao()

    override fun getNews(): Observable<List<News>> {
        return newsDao.getNews()
    }

    override fun insertNews(news: List<News>) {
        newsDao.insertNews(news)
    }
}