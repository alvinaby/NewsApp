package com.example.newsapp.repository

import com.example.newsapp.model.News
import io.reactivex.Observable

interface NewsRepoInterface {
    fun getNewsFromApi(): Observable<List<News>>
    fun getNewsFromDb(): Observable<List<News>>
}