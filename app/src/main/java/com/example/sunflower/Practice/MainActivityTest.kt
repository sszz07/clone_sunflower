package com.example.sunflower.Practice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.sunflower.BookService
import com.example.sunflower.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_test)


        //retrofit 구현체가 생성이 되서 retrofit이라는 변수에 할당이 된다.
        val retrofit2 = RetrofitClientPractice
        val bookService = retrofit2.getInstance().create(BookService::class.java)

        bookService.getBookByName("GBs1ecx1hmePfrG29pdo", "9JQH1LYFYQ", "안드로이드")
            .enqueue(object : Callback<SearchBooksDto> {
                override fun onResponse(
                    call: Call<SearchBooksDto>,
                    response: Response<SearchBooksDto> //import retrofit2.Response okhttp,retrofit 설정 잘해주기
                ) {
                    if (response.isSuccessful.not()) {
                        return
                    }

                    response.body()?.books?.forEach {
                        Log.e(TAG, it.toString())
                    }
                }

                override fun onFailure(call: Call<SearchBooksDto>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}