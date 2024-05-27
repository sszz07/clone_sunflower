package com.example.sunflower.Practice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        private const val BASE_URL = "https://myvirtualshop.com/"
        var INSTANCE:Retrofit? = null

        fun getInstance():Retrofit{
            if (INSTANCE == null){
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)//baseUrl이란 요청을 보낼 기본 주소값 http://52.79.180.89(베이스 URL)/dang_guen(상대 URL)/
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE!!
        }
    }
}