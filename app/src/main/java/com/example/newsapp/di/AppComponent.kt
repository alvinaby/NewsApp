package com.example.newsapp.di

import com.example.newsapp.MainActivity
import com.example.newsapp.repository.MainRepo
import dagger.Component

@Component(modules = [RepoModule::class])
interface AppComponent {
    fun getMainRepo(): MainRepo
    fun inject(mainActivity: MainActivity)
}