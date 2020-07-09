package com.example.newsapp.repository.remote

import com.example.newsapp.data.api.ApiService
import com.example.newsapp.model.News
import io.reactivex.Observable

class RemoteRepo : RemoteRepoInterface {
    private val apiClient = ApiService().retrofit()

    override fun getNews(): Observable<List<News>> {
        return apiClient.getNews()
    }
}