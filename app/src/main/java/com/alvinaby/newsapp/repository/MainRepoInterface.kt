package com.alvinaby.newsapp.repository

import com.alvinaby.newsapp.model.News
import io.reactivex.Observable

interface MainRepoInterface {
    fun getNews(): Observable<List<News>>
}
