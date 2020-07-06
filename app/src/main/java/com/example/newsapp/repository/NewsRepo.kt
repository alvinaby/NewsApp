package com.example.newsapp.repository

import com.example.newsapp.data.api.ApiService
import com.example.newsapp.model.News
import com.example.newsapp.data.room.NewsDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsRepo(private val localData: NewsDao) : NewsRepoInterface {
    private val remoteData = ApiService().retrofit()

    override fun getNewsFromApi(): Observable<List<News>> {
        return remoteData.getNews()
            .doOnNext { localData.insertNews(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

//        Observable.mergeDelayError(
//            localData.getNews()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread()),
//
//
//        )
    }

    override fun getNewsFromDb(): Observable<List<News>> {
        return localData.getNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
