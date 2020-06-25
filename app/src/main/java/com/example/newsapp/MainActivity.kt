package com.example.newsapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
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
        setThemeState()

        // News List
        presenter = Presenter(this)
        presenter.getNews()

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

    private fun setThemeState() {
        val themeSwitch = findViewById<Switch>(R.id.themeSwitch)
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            themeSwitch.isChecked = true

        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onSuccess(newsList: List<News>){
        newsView.setHasFixedSize(true)
        newsView.layoutManager = LinearLayoutManager(this)
        newsView.adapter = Adapter(newsList)
    }

    override fun onError() {
        val toast = Toast.makeText(this, "No news found, please check your connection", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }

    override fun openNews(url: String) {
        val loadNews = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(loadNews)
    }
}
