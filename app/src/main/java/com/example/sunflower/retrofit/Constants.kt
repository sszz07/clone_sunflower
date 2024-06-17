package com.example.sunflower.retrofit


object Constants {
    const val TAG : String = "로그"
}

enum class SEARCH_TYPE {
    PHOTO
}

enum class RESPONSE_STATE {
    OKAY,
    FAIL
}


object API {
    const val BASE_URL : String = "https://api.unsplash.com/"
    const val CLIENT_ID : String = "hIuRBna-xlzaBfLmdFCuFBfebstPaAuk9WW0QP2DnSw"
    const val SEARCH_PHOTOS : String = "search/photos"

}