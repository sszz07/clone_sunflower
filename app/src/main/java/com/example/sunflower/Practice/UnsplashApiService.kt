package com.example.sunflower.Practice

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApiService {
    @GET(
        "photos/random/?" +
                "client_id=" +
                "Access Key" +
                "&count=5"
    )
    fun getSearchedPhotos(
        @Query("query") query: String?
    ): Flow<List<PhotoResponseItem>>
}