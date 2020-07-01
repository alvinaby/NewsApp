package com.example.newsapp.repository.remote

import com.example.newsapp.model.News
import io.reactivex.Observable

interface RemoteNewsRepoInterface {
    fun getNews(): Observable<List<News>>
}