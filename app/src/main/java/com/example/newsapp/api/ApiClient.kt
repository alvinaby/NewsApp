package com.example.newsapp.api

import com.example.newsapp.model.News
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiClient {
    @GET("kurio-test/mobile-engineer-android/magazine/articles")
    fun getNews(): Single<List<News>>

    companion object {
        fun create(): ApiClient {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://storage.googleapis.com/")
                .build()
            return retrofit.create(ApiClient::class.java)
        }
    }
}