package com.example.newsapp

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.model.News
import com.example.newsapp.presenter.Presenter
import com.example.newsapp.presenter.PresenterInterface
import com.example.newsapp.repository.MainRepo
import com.example.newsapp.repository.local.LocalRepo
import com.example.newsapp.repository.remote.RemoteRepo
import com.example.newsapp.utils.NetworkUtils
import com.example.newsapp.utils.NetworkUtilsInterface
import com.example.newsapp.utils.ThemeUtils
import com.example.newsapp.view.Adapter
import com.example.newsapp.view.ViewInterface
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewInterface, NetworkUtilsInterface {
    private lateinit var presenter: PresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Theme
        val themeUtils = ThemeUtils(this)
        themeUtils.checkTheme()
        themeBtn.setOnClickListener { themeUtils.changeTheme() }

        //Load news list
        loadNews()

        //Detect network
        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(NetworkUtils(this), intentFilter)

        //Navigation Bar
        navbar.setOnNavigationItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.home -> newsView.smoothScrollToPosition(0)
                R.id.podcast -> Toast.makeText(this, "Podcast", Toast.LENGTH_SHORT).show()
                R.id.account -> Toast.makeText(this, "Account", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    private fun loadNews() {
        val mainRepo = MainRepo(this).getNews()
        presenter = Presenter(this, mainRepo)
        presenter.loadNews()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.disposeNews()
    }

    override fun onSuccess(newsList: List<News>){
        newsView.setHasFixedSize(true)
        newsView.layoutManager = LinearLayoutManager(this)
        newsView.adapter = Adapter(newsList)

        refreshNews.setOnRefreshListener {
            loadNews()
            newsView.adapter = Adapter(newsList)
            refreshNews.isRefreshing = false
        }
    }

    override fun onError() {
        Toast.makeText(this, "No news found", Toast.LENGTH_LONG).show()
    }

    override fun openNews(url: String) {
        val loadNews = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(loadNews)
    }

    override fun onNetworkChanged(isConnected: Boolean) {
        if (isConnected) {
            Toast.makeText(this, "Loading news", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "No network connection", Toast.LENGTH_SHORT).show()
        }
    }

}
