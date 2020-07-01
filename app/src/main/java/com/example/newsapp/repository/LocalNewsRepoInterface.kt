package com.example.newsapp.repository

import com.example.newsapp.model.News
import io.reactivex.Observable

interface LocalNewsRepoInterface {
    fun insertNewsDb(news: List<News>)
    fun getNewsDb(): Observable<List<News>>
}