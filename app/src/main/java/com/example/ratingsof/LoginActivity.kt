package com.example.ratingsof

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ratingsof.api.ApiService
import com.example.ratingsof.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            // Obtén los valores de los campos de nombre de usuario y contraseña
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Realiza la validación de los datos aquí, por ejemplo, verifica si los campos están vacíos

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa nombre de usuario y contraseña", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Luego, realiza la solicitud de inicio de sesión a la API
            val loginCall = ApiService.ApiClient.usersApiService.iniciarSesion(username, password)
            loginCall.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.isSuccessful) {
                        // La validación fue exitosa
                        val loginResponse = response.body()
                        if (loginResponse != null && loginResponse.isValid) {
                            val message = loginResponse.message
                            if (message != null) {
                                Toast.makeText(this@LoginActivity, "¡Bienvenido!", Toast.LENGTH_SHORT).show()
                                // Puedes realizar otras acciones posteriores aquí, como navegar a la pantalla principal
                            }
                        } else {
                            Toast.makeText(this@LoginActivity, "Error al iniciar sesión", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        // La validación falló
                        Toast.makeText(this@LoginActivity, "Error al iniciar sesión", Toast.LENGTH_SHORT).show()
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
