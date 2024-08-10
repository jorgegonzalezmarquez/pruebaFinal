package com.example.pruebafinal.retrofit

import com.example.pruebafinal.services.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private const val BASE_URL = "https://curso-android-56-1.verce1.app/"
    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val originalResponse = chain.proceed(chain.request())
            if (originalResponse.headers("Set-Cookie").isNotEmpty()) {
                val cookies = originalResponse.headers("Set-Cookie")
                println("Cookies: $cookies")
            }
            originalResponse
        }
        .build()
    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        retrofit.create(ApiService::class.java)
    }
}