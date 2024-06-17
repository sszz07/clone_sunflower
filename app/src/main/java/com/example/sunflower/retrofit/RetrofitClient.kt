package com.example.sunflower.retrofitTest

import android.util.Log
import com.example.sunflower.retrofitTest.Constants.TAG
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


//레트로핏 클라이언트 객체를 만드는 클래스
// 싱글턴
object RetrofitClient {
    // 레트로핏 클라이언트 선언

    private var retrofitClient: Retrofit? = null

    // 레트로핏 클라이언트 가져오기
    fun getClient(baseUrl: String): Retrofit? {
        Log.d(TAG, "RetrofitClient - getClient() called")

        // okhttp 인스턴스 생성
        val client = OkHttpClient.Builder()


        // 기본 파라매터 인터셉터 설정
        val baseParameterInterceptor: Interceptor = (object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                Log.d(TAG, "RetrofitClient - intercept() called")
                // 오리지날 리퀘스트
                val originalRequest = chain.request()

                // 쿼리 파라매터 추가하기
                val addedUrl =
                    originalRequest.url.newBuilder().addQueryParameter("client_id", API.CLIENT_ID)
                        .build()

                val finalRequest = originalRequest.newBuilder()
                    .url(addedUrl)
                    .method(originalRequest.method, originalRequest.body)
                    .build()

                val response = chain.proceed(finalRequest)
                return response
            }
        })


        // 위에서 설정한 기본파라매터 인터셉터를 okhttp 클라이언트에 추가한다.
        client.addInterceptor(baseParameterInterceptor)

        // 커넥션 타임아웃
        client.connectTimeout(10, TimeUnit.SECONDS)
        client.readTimeout(10, TimeUnit.SECONDS)
        client.writeTimeout(10, TimeUnit.SECONDS)
        client.retryOnConnectionFailure(true)


        if (retrofitClient == null) {
            // 레트로핏 빌더를 통해 인스턴스 생성
            retrofitClient = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                // 위에서 설정한 클라이언트로 레트로핏 클라이언트를 설정한다.
                .client(client.build())
                .build()
        }

        return retrofitClient
    }


}
