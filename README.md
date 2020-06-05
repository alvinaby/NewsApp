## NewsApp
This is a simple Android app about news, and also my job interview test :D <br> This app is using MVP Architecture, Retrofit, RxJava, and Glide

#### NewsApp functions:
* View list of news
* When user click a news, it will open the source (URL) of the news using Android built-in browser

#### API used:
* https://storage.googleapis.com/kurio-test/mobile-engineer-android/magazine/articles

#### Library used:
RecyclerView
* `implementation 'com.android.support:design:29.0.0'`

Retrofit
* `implementation 'com.squareup.retrofit2:retrofit:2.6.1'`
* `implementation 'com.squareup.retrofit2:converter-gson:2.6.1'`
* `implementation 'com.squareup.retrofit2:adapter-rxjava2:2.4.0'`

RxJava
* `implementation 'io.reactivex.rxjava2:rxandroid:2.1.1'`

Glide
* `implementation 'com.github.bumptech.glide:glide:4.11.0'`
