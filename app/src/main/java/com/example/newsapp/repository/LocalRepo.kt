package com.example.newsapp.repository

import com.example.newsapp.data.room.NewsDao
import com.example.newsapp.model.News
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LocalRepo(private val newsDao: NewsDao) : RepoInterface {
    override fun getNews(): Observable<List<News>> {
        return newsDao.getNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}