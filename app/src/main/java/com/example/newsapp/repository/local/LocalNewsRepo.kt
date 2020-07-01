package com.example.newsapp.repository.local

import com.example.newsapp.model.News
import com.example.newsapp.room.NewsDao
import io.reactivex.Observable

class LocalNewsRepo(private val newsDao: NewsDao) : LocalNewsRepoInterface {
    override fun getNews(): Observable<List<News>> {
        return newsDao.getNews()
    }

    override fun insertNews(news: List<News>) {
        newsDao.insertNews(news)
    }
}
