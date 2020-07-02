package com.example.newsapp.data.api

import com.example.newsapp.model.News
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {
    @GET("kurio-test/mobile-engineer-android/magazine/articles")
    fun getNews(): Observable<List<News>>
}
