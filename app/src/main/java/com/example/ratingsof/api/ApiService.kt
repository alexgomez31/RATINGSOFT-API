package com.example.ratingsof.api

import com.example.ratingsof.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    interface CursosApiService {
        @GET("cursos") // Reemplaza "cursos" con la URL del punto final de la API
        fun obtenerCursos(): Call<List<ApiService>>
    }

    interface UsersApiService {
        @GET("users") // Reemplaza "users" con la URL del punto final de la API
        fun obtenerUsuarios(): Call<List<ApiService>>

        @POST("login") // Reemplaza "login" con la URL del punto final de inicio de sesión
        fun iniciarSesion(): Call<LoginResponse> // Reemplaza "TokenResponse" con la clase que representa la respuesta de inicio de sesión
    }

    object ApiClient {
        private const val BASE_URL = "https://tu-api-laravel.com/" // Reemplaza con la URL de tu API

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