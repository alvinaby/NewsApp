package com.example.newsapp.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import com.example.newsapp.view.ViewInterface

class NetworkUtils(private val view: ViewInterface): BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        view.onNetworkChanged(isConnected(context!!))
    }

    private fun isConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}
