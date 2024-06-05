package com.example.sunflower

import com.google.gson.annotations.SerializedName

//data클래스를 공부하면서 toString,equals,hashcode는 data를 사용하지 않으면 안되다
//toString 문자열로 보여주기 위함
//equals는 메모리가 같은지 확인
//hashcode는 같은 객체로 만들어주기 위함
data class PlantList(
    @SerializedName("fruitImage") var fruitImage: Int,
    @SerializedName("fruitName") var fruitName: String,
    @SerializedName("fruitContent") var fruitContent: String
)
