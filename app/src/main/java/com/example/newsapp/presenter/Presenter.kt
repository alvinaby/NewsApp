package com.example.newsapp.presenter

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.newsapp.repository.NewsRepo
import com.example.newsapp.repository.room.NewsDatabase
import com.example.newsapp.view.ViewInterface
import io.reactivex.disposables.Disposable

class Presenter(private val view: ViewInterface): PresenterInterface {
    private val newsRepo =  NewsRepo().getNews()
    private var disposable: Disposable? = null

    fun onBackground(context: Context) {
        val db = Room.databaseBuilder(context, NewsDatabase::class.java, "NewsDb").build()
        val thread = Thread {
            //db.newsDao().insertNews()
            db.newsDao().getNews().forEach {
                Log.i("Fetch data", "News: ${it.title} ${it.publisherName}")
            }
        }
        thread.start()
    }

    override fun loadNews() {
         disposable = newsRepo.subscribe(
                { view.onSuccess(it) },
                { view.onError() }
         )
    }

    override fun disposeNews() {
        disposable?.dispose()
    }
}
