package com.alvinaby.newsapp

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.alvinaby.newsapp.di.AppModule
import com.alvinaby.newsapp.di.DaggerAppComponent
import com.alvinaby.newsapp.model.News
import com.alvinaby.newsapp.presenter.Presenter
import com.alvinaby.newsapp.utils.NetworkUtils
import com.alvinaby.newsapp.utils.ThemeUtils
import com.alvinaby.newsapp.view.Adapter
import com.alvinaby.newsapp.view.ViewInterface
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ViewInterface {
    @Inject lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Theme
        val themeUtils = ThemeUtils(this)
        themeUtils.checkTheme()
        themeBtn.setOnClickListener { themeUtils.changeTheme() }

        //Load news list
        loadNews()

        //Refresh news list
        refreshNews.setOnRefreshListener {
            loadNews()
            refreshNews.isRefreshing = false
        }

        //Detect network
        @Suppress("DEPRECATION")
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
        val appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this, this))
            .build()

        appComponent.inject(this)
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
    }

    override fun onError() {
        Toast.makeText(this, "No news found", Toast.LENGTH_LONG).show()
    }

    override fun onNetworkChanged(isConnected: Boolean) {
        if (!isConnected) {
            Toast.makeText(this, "No network connection", Toast.LENGTH_SHORT).show()
        }
    }

    override fun openNews(url: String) {
        val loadNews = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(loadNews)
    }
}
