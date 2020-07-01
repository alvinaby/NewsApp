package com.example.newsapp.repository

import com.example.newsapp.model.News
import com.example.newsapp.repository.room.NewsDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LocalNewsRepo : LocalNewsRepoInterface{
    private lateinit var newsDao: NewsDao

    override fun insertNewsDb(news: List<News>) {
        newsDao.insertNews(news)
    }

    override fun getNewsDb(): Observable<List<News>> {
        return newsDao.getNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}