package com.example.newsapp.repository.remote

import com.example.newsapp.data.api.ApiInterface
import com.example.newsapp.model.News
import io.reactivex.Observable
import javax.inject.Inject

class RemoteRepo @Inject constructor (
    private val apiInterface: ApiInterface
) : RemoteRepoInterface {

    override fun getNews(): Observable<List<News>> {
        return apiInterface.getNews()
    }

}
