package com.example.sunflower.Practice

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class GetRandomPhotos {

    var photoItemList: List<PhotoResponseItem> = listOf()

    private val scope = CoroutineScope(Dispatchers.IO)

    suspend fun getRandomPhotosAsync(query: String? = null) = scope.async {
        RetrofitApi.getPhotos(query)
            .collect {
                Log.d("JB", "query: $query")
                photoItemList = it as MutableList<PhotoResponseItem>
            }
    }
}