package com.example.newsapp.di

import com.example.newsapp.MainActivity
import dagger.Component

@Component
interface AppComponent {
    fun inject(app: MainActivity)
}