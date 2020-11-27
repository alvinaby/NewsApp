package com.alvinaby.newsapp.di

import android.content.Context
import com.alvinaby.newsapp.data.api.ApiInterface
import com.alvinaby.newsapp.data.api.ApiService
import com.alvinaby.newsapp.data.room.NewsDao
import com.alvinaby.newsapp.data.room.NewsDatabase
import com.alvinaby.newsapp.view.ViewInterface
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
