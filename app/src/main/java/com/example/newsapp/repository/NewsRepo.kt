package com.example.newsapp.repository

import com.example.newsapp.data.rest.ApiService
import com.example.newsapp.model.News
import com.example.newsapp.data.room.NewsDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsRepo(private val localData: NewsDao) : NewsRepoInterface {
    private val remoteData = ApiService().retrofit()

    override fun getNews(): Observable<List<News>> {
        return Observable.mergeDelayError(
            localData.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()),

            remoteData.getNews()
                .doOnNext { localData.insertNews(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        )
    }
}
