package com.example.newsapp.data.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://storage.googleapis.com/")
            .build()
    }

    fun getApi(): ApiInterface = retrofit().create(ApiInterface::class.java)
}
