package com.example.newsapp.repository.remote

import com.example.newsapp.data.api.ApiService
import com.example.newsapp.data.room.NewsDao
import com.example.newsapp.model.News
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RemoteRepo : RemoteRepoInterface {
    private val apiClient = ApiService().retrofit()

    override fun getNews(): Observable<List<News>> {
        return apiClient.getNews()
    }
}