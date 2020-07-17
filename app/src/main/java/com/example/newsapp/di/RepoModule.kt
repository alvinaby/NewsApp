package com.example.newsapp.di

import android.content.Context
import com.example.newsapp.data.api.ApiInterface
import com.example.newsapp.data.api.ApiService
import com.example.newsapp.data.room.NewsDao
import com.example.newsapp.data.room.NewsDatabase
import com.example.newsapp.repository.local.LocalRepo
import com.example.newsapp.repository.remote.RemoteRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule(val context: Context) {
    @Provides
    @Singleton
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideNewsDao(context: Context) = NewsDatabase.createDb(context).newsDao()

    @Provides
    @Singleton
    fun provideLocalRepo(newsDao: NewsDao) = LocalRepo(newsDao)

    @Provides
    @Singleton
    fun provideApiInterface() = ApiService().getApi()

    @Provides
    @Singleton
    fun provideRemoteRepo(apiInterface: ApiInterface) = RemoteRepo(apiInterface)
}
