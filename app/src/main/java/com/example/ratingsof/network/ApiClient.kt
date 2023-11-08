package com.example.ratingsof.network

import com.example.ratingsof.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    interface UsersApiService {
        companion object

    }

    private const val BASE_URL = "http://127.0.0.1:8000/" // Reemplaza con la URL de tu API

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}