package com.alvinaby.newsapp.repository.remote

import com.alvinaby.newsapp.model.News
import io.reactivex.Observable

interface RemoteRepoInterface {
    fun getNews(): Observable<List<News>>
}