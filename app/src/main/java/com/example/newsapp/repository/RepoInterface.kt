package com.example.newsapp.repository

import com.example.newsapp.model.News
import io.reactivex.Observable

interface RepoInterface {
    fun getNews(): Observable<List<News>>
}
