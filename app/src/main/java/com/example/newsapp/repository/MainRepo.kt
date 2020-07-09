package com.example.newsapp.repository

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import com.example.newsapp.model.News
import com.example.newsapp.repository.local.LocalRepo
import com.example.newsapp.repository.remote.RemoteRepo
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainRepo(private val context: Context) : MainRepoInterface {
    private val localRepo = LocalRepo(context)
    private val remoteRepo = RemoteRepo()

    override fun getNews(): Observable<List<News>> {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo

        return if (networkInfo != null && networkInfo.isConnected) {
            Toast.makeText(context, "Loading news", Toast.LENGTH_SHORT).show()
            remoteRepo.getNews()
                .doOnNext { localRepo.insertNews(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        } else {
            Toast.makeText(context, "No network connection", Toast.LENGTH_SHORT).show()
            localRepo.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }
}
