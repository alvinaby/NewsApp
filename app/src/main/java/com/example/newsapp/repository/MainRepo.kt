package com.example.newsapp.repository

import com.example.newsapp.model.News
import com.example.newsapp.repository.local.LocalNewsRepo
import com.example.newsapp.repository.remote.RemoteNewsRepo
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainRepo(
    private val localNewsRepo: LocalNewsRepo,
    private val remoteNewsRepo: RemoteNewsRepo
) : MainRepoInterface {

    override fun getNews(): Observable<List<News>> {
        return Observable.mergeDelayError(
            remoteNewsRepo.getNews()
                .doOnNext { localNewsRepo.insertNews(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()),

            localNewsRepo.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        )
    }
}
