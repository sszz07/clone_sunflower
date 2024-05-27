package com.example.sunflower.Practice

import android.health.connect.datatypes.ExerciseRoute
import com.google.gson.annotations.SerializedName

data class PhotoResponseItem(
    @SerializedName("blur_hash")
    val blurHash: String?,
    val color: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("current_user_collections")
    val currentUserCollections: List<CurrentUserCollection>?,
    val description: String?,
    val downloads: Int?,
    val exif: Exif?,
    val height: Int?,
    val id: String?,
    @SerializedName("liked_by_user")
    val likedByUser: Boolean?,
    val likes: Int?,
    val links: Linzks?,
    val location: ExerciseRoute.Location?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    val urls: Urls?,
    val user: User?,
    val width: Int?
)