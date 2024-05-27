package com.example.sunflower

import com.example.sunflower.Practice.SearchBooksDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.Call
interface BookService {
    @GET("/v1/search/book_json")
    fun getBookByName(
        @Header("X-Naver-Client-Id") id: String,
        @Header("X-Naver-Client-Secret") secretKey: String,
        @Query("query") keyword: String
    ): Call<SearchBooksDto>
    //No type arguments expected for class Call
}