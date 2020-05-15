package com.example.newsapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.model.NewsModel
import com.example.newsapp.presenter.NewsPresenter
import com.example.newsapp.presenter.PresenterInterface
import com.example.newsapp.view.NewsAdapter
import com.example.newsapp.view.ViewInterface
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewInterface {
    private lateinit var presenter: PresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // News List
        presenter = NewsPresenter(this)
        presenter.getNews()

        // Navigation Bar
        navbar.setOnNavigationItemSelectedListener { menu ->
            when(menu.itemId){
                R.id.home -> {
                    news_list.smoothScrollToPosition(0)
                }
                R.id.podcast -> {
                    Toast.makeText(this, "Podcast", Toast.LENGTH_SHORT).show()
                }
                R.id.account -> {
                    Toast.makeText(this, "Account", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

    override fun showNews(newsList: List<NewsModel>){
        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(this)
        news_list.adapter = NewsAdapter(newsList)
    }

    override fun openNews(url: String) {
        val loadNews = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(loadNews)

        /* val openNews = Intent(this@MainActivity, OpenNewsActivity::class.java)
        openNews.putExtra(OpenNewsActivity.url, url)
        startActivity(openNews) */
    }
}