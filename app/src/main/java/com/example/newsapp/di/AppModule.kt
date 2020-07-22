package com.example.newsapp.di

import android.content.Context
import com.example.newsapp.data.api.ApiInterface
import com.example.newsapp.data.api.ApiService
import com.example.newsapp.data.room.NewsDao
import com.example.newsapp.data.room.NewsDatabase
import com.example.newsapp.repository.local.LocalRepo
import com.example.newsapp.repository.remote.RemoteRepo
import com.example.newsapp.view.ViewInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val context: Context, val view: ViewInterface) {
    @Provides
    @Singleton
    fun provideContext(): Context = context

    @Provides
    @Singleton
    fun provideNewsDao(): NewsDao = NewsDatabase.createDb(context).newsDao()

    @Provides
    @Singleton
    fun provideApiInterface(): ApiInterface = ApiService().getApi()

    @Provides
    @Singleton
    fun provideView(): ViewInterface = view
}
