package com.example.newsapp

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.model.News
import com.example.newsapp.presenter.Presenter
import com.example.newsapp.presenter.PresenterInterface
import com.example.newsapp.repository.NewsRepo
import com.example.newsapp.data.room.NewsDatabase
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

        val themeUtils = ThemeUtils(this)
        themeUtils.checkTheme()
        themeBtn.setOnClickListener { themeUtils.changeTheme() }

        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(NetworkUtils(this), intentFilter)

        // News Database
        val newsDb = NewsDatabase.createDb(this)
        val newsRepo = NewsRepo(newsDb.newsDao())

        // News List
        presenter = Presenter(this, newsRepo)
        presenter.loadNews()

        // Navigation Bar
        navbar.setOnNavigationItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.home -> newsView.smoothScrollToPosition(0)
                R.id.podcast -> Toast.makeText(this, "Podcast", Toast.LENGTH_SHORT).show()
                R.id.account -> Toast.makeText(this, "Account", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.disposeNews()
    }

    override fun onSuccess(newsList: List<News>){
        newsView.setHasFixedSize(true)
        newsView.layoutManager = LinearLayoutManager(this)
        newsView.adapter = Adapter(newsList)
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
