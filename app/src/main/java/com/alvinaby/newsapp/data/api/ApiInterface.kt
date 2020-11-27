package com.alvinaby.newsapp.data.api

import com.alvinaby.newsapp.model.News
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {
    @GET("kurio-test/mobile-engineer-android/magazine/articles")
    fun getNews(): Observable<List<News>>
}
