package com.example.newsapp.repository

import android.content.Context
import com.example.newsapp.data.api.ApiService
import com.example.newsapp.model.News
import com.example.newsapp.data.room.NewsDatabase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsRepo(context: Context) : NewsRepoInterface {
    private val localData = NewsDatabase.createDb(context).newsDao()
    private val remoteData = ApiService().retrofit()

    override fun getNewsRemote(): Observable<List<News>> {
        return remoteData.getNews()
            .doOnNext { localData.insertNews(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getNewsLocal(): Observable<List<News>> {
        return localData.getNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
