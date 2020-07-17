package com.example.newsapp.di

import com.example.newsapp.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [PresenterModule::class, RepoModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}
