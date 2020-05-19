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

    private fun create(): ApiClient {
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://storage.googleapis.com/")
            .build()
        return retrofit.create(ApiClient::class.java)
    }

    override fun getNews() {
        disposable = create().getNews()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe{ result -> view.showNews(result) }
    }
}