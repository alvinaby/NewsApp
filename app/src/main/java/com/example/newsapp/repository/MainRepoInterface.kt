package com.example.newsapp.repository

import com.example.newsapp.model.News
import io.reactivex.Observable

interface MainRepoInterface {
    fun getNews(): Observable<List<News>>
}
