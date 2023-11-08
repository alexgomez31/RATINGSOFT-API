package com.example.ratingsof.api

import com.example.ratingsof.model.LoginResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    interface CursosApiService {
        @GET("cursos")
        fun obtenerCursos(): Call<List<LoginResponse>> // Reemplaza "CursosResponse" con el tipo de respuesta correcto
    }

    interface UsersApiService {
        @FormUrlEncoded
        @POST("login")
        fun iniciarSesion(
            @Field("username") username: String,
            @Field("password") password: String
        ): Call<LoginResponse>
    }

    object ApiClient {
        private const val BASE_URL = "http://127.0.0.1:8000/" // Reemplaza con la URL de tu API

        val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val cursosApiService: CursosApiService by lazy {
            retrofit.create(CursosApiService::class.java)
        }

        val usersApiService: UsersApiService by lazy {
            retrofit.create(UsersApiService::class.java)
        }
    }
}
