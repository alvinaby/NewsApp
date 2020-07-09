package com.example.newsapp.repository.local

import com.example.newsapp.data.room.NewsDao
import com.example.newsapp.model.News
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LocalRepo(private val newsDao: NewsDao) : LocalRepoInterface {
    override fun getNews(): Observable<List<News>> {
        return newsDao.getNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}