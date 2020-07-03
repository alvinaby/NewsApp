package com.example.newsapp.repository

import android.content.Context
import com.example.newsapp.data.api.ApiService
import com.example.newsapp.model.News
import com.example.newsapp.data.room.NewsDao
import com.example.newsapp.data.room.NewsLocalData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsRepo(private val localData: NewsDao) : NewsRepoInterface {
    private val remoteData = ApiService().retrofit()

    override fun getNewsRemote(): Observable<List<News>> {
        return remoteData.getNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

//        Observable.mergeDelayError( , )
    }

    override fun getNewsLocal(): Observable<List<NewsLocalData>> {
        return localData.getNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
