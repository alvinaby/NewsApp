package com.alvinaby.newsapp.repository.remote

import com.alvinaby.newsapp.data.api.ApiInterface
import com.alvinaby.newsapp.model.News
import io.reactivex.Observable
import javax.inject.Inject

class RemoteRepo @Inject constructor (
    private val apiInterface: ApiInterface
) : RemoteRepoInterface {

    override fun getNews(): Observable<List<News>> {
        return apiInterface.getNews()
    }

}
