package com.example.newsapp.repository

import com.example.newsapp.data.api.ApiService
import com.example.newsapp.data.room.NewsDao
import com.example.newsapp.model.News
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RemoteRepo(private val newsDao: NewsDao) : RepoInterface {
    private val apiService = ApiService().retrofit()

    override fun getNews(): Observable<List<News>> {
        return apiService.getNews()
            .doOnNext { newsDao.insertNews(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}