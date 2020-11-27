package com.alvinaby.newsapp.repository.local

import com.alvinaby.newsapp.model.News
import io.reactivex.Observable

interface LocalRepoInterface {
    fun getNews(): Observable<List<News>>
    fun insertNews(news: List<News>)
}