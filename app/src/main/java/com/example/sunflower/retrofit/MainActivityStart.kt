package com.example.sunflower.retrofit

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.sunflower.R
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivityStart : AppCompatActivity() {
    var photoList = ArrayList<Photo>()
    val BASE_URL = "https://jsonplaceholder.typicode.com/"

    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_start)
        val bt = findViewById<Button>(R.id.bt_search)
        val et = findViewById<EditText>(R.id.edittext_search)
        val image = findViewById<ImageView>(R.id.search_term_imageview)
        // 검색 버튼 클릭시
//        bt.setOnClickListener {
//
//            // 검색 api 호출
//            RetrofitManager.instance.searchPhotos(
//                searchTerm = et.text.toString(),
//                completion = { responseState, responseDataArrayList ->
//
//                    when (responseState) {
//                        RESPONSE_STATE.OKAY -> {
//                            Toast.makeText(this, "api 호출 성공했습니다", Toast.LENGTH_SHORT).show()
//                            Log.d(TAG, "api 호출 성공 : ${responseDataArrayList?.size}")
//
//                            if (responseDataArrayList != null) {
//                                photoList = responseDataArrayList
//                            }
//
////                            Glide.with(this)
////                                .load(photoList.get(0).thumbnail)
////                                .into(image)
//
//
//                        }
//
//                        RESPONSE_STATE.FAIL -> {
//                            Toast.makeText(this, "api 호출 에러입니다.", Toast.LENGTH_SHORT).show()
//                            Log.d(TAG, "api 호출 실패 : $responseDataArrayList")
//                        }
//                    }
//
//                })
//        }

//        searchByName("labrador")
//
//
//
//
//        //비동기 실행을 보여주는 간단한 예제
//        print("Start Main Thread")
//        GlobalScope.launch {
//            delay(3000)
//            print("in Coroutine ...")
//        }
//        print("End Main Thread")
//
//
//        //비동기적으로 실행된 코루틴이 완료되어 그 결과를 반환받는 예제
//        GlobalScope.launch {
//            launch {
//                println("At Here!")
//            }
//            val value: Int = async {
//                var total = 0
//                for (i in 1..10) total += i
//                total
//            }.await()
//            println("${value}")
//        }


        // 역시 비동기적으로 실행된 코루틴의 완료를 기다리고 그 결과를 반환받아 출력하는 예제


        GlobalScope.launch(Dispatchers.Default) {

            val job1 = async(Dispatchers.IO) {
                RetrofitManager.instance.searchPhotos(
                    "apple",
                    completion = { responseState, responseDataArrayList ->
                        when (responseState) {
                            RESPONSE_STATE.OKAY -> {
                                Log.d(Constants.TAG, "api 호출 성공 : ${responseDataArrayList?.size}")
//                        Glide.with(this)
//                            .load(photoList.get(0).thumbnail)
//                            .into(image)
                            }

                            RESPONSE_STATE.FAIL -> {
                                Log.d(Constants.TAG, "api 호출 실패 : $responseDataArrayList")
                            }
                        }

                        if (responseDataArrayList != null) {
                            photoList = responseDataArrayList
                        }
                    })
            }

            val result1 = job1.await()
            val result2 = "lsarjg;lwrj;oij"
        }
    }

}