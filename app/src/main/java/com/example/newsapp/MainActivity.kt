package com.example.newsapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.model.News
import com.example.newsapp.presenter.Presenter
import com.example.newsapp.presenter.PresenterInterface
import com.example.newsapp.view.Adapter
import com.example.newsapp.view.ViewInterface
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewInterface {
    private lateinit var presenter: PresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // News List
        presenter = Presenter(this)
        presenter.getNews()

        // Navigation Bar
        navbar.setOnNavigationItemSelectedListener { menu ->
            when(menu.itemId){
                R.id.home -> {
                    newsView.smoothScrollToPosition(0)
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

    override fun showNews(newsList: List<News>){
        newsView.setHasFixedSize(true)
        newsView.layoutManager = LinearLayoutManager(this)
        newsView.adapter = Adapter(newsList)
    }

    override fun openNews(url: String) {
        val loadNews = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(loadNews)
    }
}