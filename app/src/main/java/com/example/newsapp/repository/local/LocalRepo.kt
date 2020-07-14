package com.example.newsapp.repository.local

import com.example.newsapp.data.room.NewsDao
import com.example.newsapp.model.News
import io.reactivex.Observable

class LocalRepo (private val newsDao: NewsDao) : LocalRepoInterface {
    override fun getNews(): Observable<List<News>> {
        return newsDao.getNews()
    }

    override fun insertNews(news: List<News>) {
        newsDao.insertNews(news)
    }
}
