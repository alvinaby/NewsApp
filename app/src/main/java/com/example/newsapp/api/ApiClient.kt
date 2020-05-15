package com.example.newsapp.api

import com.example.newsapp.model.NewsModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiClient {
    @GET("kurio-test/mobile-engineer-android/magazine/articles")
    fun getNews(): Single<List<NewsModel>>
}