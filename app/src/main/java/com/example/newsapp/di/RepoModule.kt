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

@Module
class RepoModule(val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideNewsDao(context: Context): NewsDao {
        return NewsDatabase.createDb(context).newsDao()
    }

    @Provides
    fun provideLocalRepo(newsDao: NewsDao): LocalRepo {
        return LocalRepo(newsDao)
    }

    @Provides
    fun provideApiService(): ApiInterface {
        return ApiService().retrofit()
    }

    @Provides
    fun provideRemoteRepo(apiInterface: ApiInterface): RemoteRepo {
        return RemoteRepo(apiInterface)
    }
}