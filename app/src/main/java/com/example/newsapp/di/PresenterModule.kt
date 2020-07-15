package com.example.newsapp.di

import com.example.newsapp.view.ViewInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule(val view: ViewInterface) {
    @Provides
    @Singleton
    fun provideView(): ViewInterface {
        return view
    }
}