package com.example.newsapp.repository.remote

import com.example.newsapp.model.News
import io.reactivex.Observable

interface RemoteRepoInterface {
    fun getNews(): Observable<List<News>>
}