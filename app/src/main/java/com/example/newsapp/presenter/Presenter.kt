package com.example.newsapp.presenter

import com.example.newsapp.api.ApiClient
import com.example.newsapp.view.ViewInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Presenter(private val view: ViewInterface): PresenterInterface {
    private var disposable: Disposable? = null
    private val apiClient = ApiClient.create().getNews()

    override fun getNews() {
        disposable = apiClient
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe{ result -> view.showNews(result) }
    }
}