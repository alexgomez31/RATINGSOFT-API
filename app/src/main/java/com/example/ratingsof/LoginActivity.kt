package com.example.ratingsof

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.EditText // Asegúrate de importar la clase EditText
import android.widget.Toast // Asegúrate de importar la clase Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ratingsof.R
import com.example.ratingsof.api.ApiService
import com.example.ratingsof.network.ApiClient
import com.example.ratingsof.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton = findViewById<View>(R.id.loginButton)
        val usernameEditText = findViewById<EditText>(R.id.username)
        val passwordEditText = findViewById<EditText>(R.id.password)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Realiza la solicitud de inicio de sesión utilizando ApiService y ApiClient
            val loginCall = ApiClient.UsersApiService.iniciarSesion(username, password)
            loginCall.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        // Maneja la respuesta exitosa, por ejemplo, almacena el token de autenticación
                        val loginResponse = response.body()
                        val authToken = loginResponse?.token

                        // Puedes guardar el token y realizar acciones posteriores, como navegar a otra actividad
                    } else {
                        // Maneja errores de inicio de sesión
                        Toast.makeText(
                            this@LoginActivity,
                            "Error en inicio de sesión",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    // Maneja errores de red
                    Toast.makeText(this@LoginActivity, "Error de red", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}