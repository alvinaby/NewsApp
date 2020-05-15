package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_open_news.*

class OpenNewsActivity : AppCompatActivity() {

    companion object{ val url = "url" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_news)

        val openNews = intent.getStringExtra(url)
        news_webview.loadUrl(openNews)

        back_button.setOnClickListener{ onBackPressed() }
    }
}
