package com.example.newsapp.repository.local

import com.example.newsapp.model.News
import io.reactivex.Observable

interface LocalNewsRepoInterface {
    fun getNews(): Observable<List<News>>
    fun insertNews(news: List<News>)
}
