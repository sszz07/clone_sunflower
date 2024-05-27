package com.example.sunflower.Practice

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("isbn") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String
)