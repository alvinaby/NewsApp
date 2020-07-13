package com.example.newsapp.di

import android.content.Context
import com.example.newsapp.data.api.ApiService
import com.example.newsapp.data.room.NewsDatabase
import com.example.newsapp.repository.MainRepo
import com.example.newsapp.repository.local.LocalRepo
import com.example.newsapp.repository.remote.RemoteRepo

class AppModule {
    fun provideLocalRepo(newsDatabase: NewsDatabase): LocalRepo {
        return LocalRepo(newsDatabase.newsDao())
    }

    fun provideRemoteRepo(apiService: ApiService): RemoteRepo {
        return RemoteRepo(apiService.retrofit())
    }

    fun provideRepo(context: Context, localRepo: LocalRepo, remoteRepo: RemoteRepo): MainRepo {
        return MainRepo(context, localRepo, remoteRepo)
    }
}