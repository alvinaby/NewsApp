package com.example.newsapp.repository

import com.example.newsapp.data.room.NewsDao
import com.example.newsapp.model.News
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainRepo(private val newsDao: NewsDao) : RepoInterface {
    private val localRepo = LocalRepo(newsDao)
    private val remoteRepo = RemoteRepo(newsDao)

    override fun getNews(): Observable<List<News>> {
        return Observable.mergeDelayError(
            localRepo.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()),

            remoteRepo.getNews()
                .doOnNext { newsDao.insertNews(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        )
    }
}
