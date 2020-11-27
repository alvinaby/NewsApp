package com.alvinaby.newsapp.repository.local

import com.alvinaby.newsapp.data.room.NewsDao
import com.alvinaby.newsapp.model.News
import io.reactivex.Observable
import javax.inject.Inject

class LocalRepo @Inject constructor (
    private val newsDao: NewsDao
) : LocalRepoInterface {

    override fun getNews(): Observable<List<News>> {
        return newsDao.getNews()
    }

    override fun insertNews(news: List<News>) {
        newsDao.insertNews(news)
    }

}
