package com.example.newsapp.repository

import com.example.newsapp.model.News
import io.reactivex.Observable

interface NewsRepoInterface {
    fun getNewsRemote(): Observable<List<News>>
    fun getNewsLocal(): Observable<List<News>>
}
