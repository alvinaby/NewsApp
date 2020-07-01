package com.example.newsapp.repository.remote

import com.example.newsapp.api.ApiService
import com.example.newsapp.model.News
import io.reactivex.Observable

class RemoteNewsRepo : RemoteNewsRepoInterface {
    private val apiClient = ApiService().retrofit()

    override fun getNews(): Observable<List<News>> {
        return apiClient.getNews()
    }
}
