package com.alvinaby.newsapp.repository

import android.content.Context
import android.widget.Toast
import com.alvinaby.newsapp.model.News
import com.alvinaby.newsapp.repository.local.LocalRepo
import com.alvinaby.newsapp.repository.remote.RemoteRepo
import com.alvinaby.newsapp.utils.NetworkUtils
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainRepo @Inject constructor (
    private val context: Context,
    private val localRepo: LocalRepo,
    private val remoteRepo: RemoteRepo
) : MainRepoInterface {

    override fun getNews(): Observable<List<News>> {
        return if (NetworkUtils.isConnected(context)) {
            Toast.makeText(context, "Loading news", Toast.LENGTH_SHORT).show()
            remoteRepo.getNews()
                .doOnNext { localRepo.insertNews(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        } else {
            Toast.makeText(context, "Offline mode", Toast.LENGTH_SHORT).show()
            localRepo.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }

}
