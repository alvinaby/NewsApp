package com.example.newsapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.model.News
import com.example.newsapp.presenter.Presenter
import com.example.newsapp.presenter.PresenterInterface
import com.example.newsapp.repository.MainRepo
import com.example.newsapp.repository.local.LocalNewsRepo
import com.example.newsapp.room.NewsDatabase
import com.example.newsapp.repository.remote.RemoteNewsRepo
import com.example.newsapp.view.Adapter
import com.example.newsapp.view.ViewInterface
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewInterface {
    private lateinit var presenter: PresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ThemePref(this).checkTheme()
        themeBtn.setOnClickListener { ThemePref(this).changeTheme() }

        // News Database
        val db = NewsDatabase.createDb(this)
        val localNewsRepo = LocalNewsRepo(db.newsDao())
        val remoteNewsRepo = RemoteNewsRepo()
        val mainRepo = MainRepo(localNewsRepo, remoteNewsRepo)

        Log.i("create $db", "database created")

        // News List
        presenter = Presenter(this, mainRepo)
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
        val toast = Toast.makeText(this, "No news found", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }

    override fun openNews(url: String) {
        val loadNews = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(loadNews)
    }
}
