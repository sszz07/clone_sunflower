package com.example.sunflower.Practice

import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {
    private const val BASE_URL = "https://api.unsplash.com/"

    private val unsplashApiService: UnsplashApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(FlowCallAdapterFactory())    // Retrofit 은 Flow 를 지원하지 않으므로 라이브러리 추가
            .client(okHttpClient)
            .build()
            .create()
    }

    fun getPhotos(query: String?): Flow<List<PhotoResponseItem>> {
        return unsplashApiService.getSearchedPhotos(query)
    }

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }
}