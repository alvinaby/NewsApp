## NewsApp
This is an app that view list of news using:
* MVP Architecture
* Repository Pattern
* Retrofit
* RxJava
* Glide
* Room Persistence
* Dagger2

#### NewsApp functions:
* View list of news
* When user click a news, it will open the source (URL) of the news using Android built-in browser
* Dark Mode

#### API used:
* https://storage.googleapis.com/kurio-test/mobile-engineer-android/magazine/articles

#### Library version:
Material Design
* `implementation 'com.android.support:design:29.0.0'`

Retrofit
* `implementation 'com.squareup.retrofit2:retrofit:2.6.1'`
* `implementation 'com.squareup.retrofit2:converter-gson:2.6.1'`
* `implementation 'com.squareup.retrofit2:adapter-rxjava2:2.4.0'`

RxJava
* `implementation "io.reactivex.rxjava2:rxjava:2.2.10"`
* `implementation 'io.reactivex.rxjava2:rxandroid:2.1.1'`

Glide
* `implementation 'com.github.bumptech.glide:glide:4.11.0'`

Room Persistence
* `implementation "androidx.room:room-runtime:2.2.5"`
* `implementation "androidx.room:room-rxjava2:2.2.5"`
* `kapt "androidx.room:room-compiler:2.2.5"`

Dagger2
* `implementation  "com.google.dagger:dagger-android-support:2.17"`
* `kapt "com.google.dagger:dagger-compiler:2.17"`
* `kapt "com.google.dagger:dagger-android-processor:2.17"`