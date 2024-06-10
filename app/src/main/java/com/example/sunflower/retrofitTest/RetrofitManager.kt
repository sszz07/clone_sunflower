package com.example.sunflower.retrofitTest

import android.util.Log
import com.example.sunflower.retrofitTest.Constants.TAG
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response


class RetrofitManager {

    //싱글턴으로 RetrofitManager를 변수로 만들어줌
    companion object {
        val instance = RetrofitManager()
    }

    // 레트로핏 인터페이스 가져오기
    private val iRetrofit: IRetrofit? =
        RetrofitClient.getClient(API.BASE_URL)?.create(IRetrofit::class.java)

    // 사진 검색 api 호출
    fun searchPhotos(searchTerm: String?, completion: (RESPONSE_STATE, ArrayList<Photo>?) -> Unit) {
        val term = searchTerm.let {
            //it은 확장함수를 의미 한다
            //it은 데이터 클래스에 데이터를 인풋하고 리턴을 하게 되면 값이 넣어진 상태에서 보여진다
            //it만 있을때 클래스의 반환값이 나온다
            it
        } ?: ""

        val call = iRetrofit?.searchPhotos(searchTerm = term).let {
            it
        } ?: return


        call.enqueue(object : retrofit2.Callback<JsonElement> {
            // 응답 실패시
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.e(TAG, "RetrofitManager - onFailure() called / t: $t")
                completion(RESPONSE_STATE.FAIL, null)
            }

            // 응답 성공시
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "RetrofitManager - onResponse() called / response : ${response.body()}")

                Log.e("200인지아닌지 확인", response.code().toString() + "        200인지아닌지 확인")

                when (response.code()) {
                    200 -> {
                        response.body()?.let {

                            var parsedPhotoDataArray = ArrayList<Photo>()

                            val body = it.asJsonObject

                            val results = body.getAsJsonArray("results")

                            val total = body.get("total").asInt

                            Log.d(TAG, "RetrofitManager - onResponse() called / total: $total")

                            // 데이터가 없으면 no_content 로 보낸다.
                            if (total == 0) {


                            } else { // 데이터가 있다면
                                results.forEach { resultItem ->
                                    val resultItemObject = resultItem.asJsonObject
                                    val thumbnailLink =
                                        resultItemObject.get("urls").asJsonObject.get("thumb").asString

                                    val photoItem = Photo(
                                        thumbnail = thumbnailLink
                                    )
                                    Log.e("값이 무엇이 나올까111", photoItem.toString())

                                    parsedPhotoDataArray.add(photoItem)

                                }

                                completion(RESPONSE_STATE.OKAY, parsedPhotoDataArray)
                            }
                        }
                    }
                }
            }
        })
    }
}