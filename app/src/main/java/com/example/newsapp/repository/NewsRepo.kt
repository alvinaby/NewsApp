package com.example.newsapp.repository

import com.example.newsapp.api.ApiService
import com.example.newsapp.model.News
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsRepo : NewsRepoInterface {
    private val apiClient = ApiService().retrofit()

    override fun getNews(): Observable<List<News>> {
        return apiClient.getNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}