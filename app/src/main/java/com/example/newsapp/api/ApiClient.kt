package com.example.newsapp.api

import com.example.newsapp.model.News
import io.reactivex.Single
import retrofit2.http.GET

interface ApiClient {
    @GET("kurio-test/mobile-engineer-android/magazine/articles")
    fun getNews(): Single<List<News>>
}