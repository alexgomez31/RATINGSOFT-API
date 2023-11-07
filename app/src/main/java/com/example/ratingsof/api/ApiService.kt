package com.example.ratingsof.api

import com.example.ratingsof.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST

interface ApiService {
    @POST("/login")
    fun login(): Call<LoginResponse>
}