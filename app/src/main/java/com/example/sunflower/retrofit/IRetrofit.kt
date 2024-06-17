package com.example.sunflower.retrofit

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//메서드를 정의한 인터페이스
interface IRetrofit {


    //@GET()-http 통신 메소드 중 하나이다 소괄호에는 상대 url 값을 넣어서 컨택하게 해준다
    //@Query-query라는 키값에 벨류를 넣어줌 'apple'이면 apple 사진을 보여주세요 라는 의미
    //Call<>-불러오는 데이터를 이름을 지어줌
    //JsonElement 형태로 받아옴
    //?있냐 없냐가 왜 에러문제 일까?

    @GET(API.SEARCH_PHOTOS)
    fun searchPhotos(@Query("query") searchTerm: String) : Call<JsonElement>
}