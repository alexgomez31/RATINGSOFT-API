package com.example.ratingsof.model

class LoginResponse {


    var isValid: Boolean = false
    lateinit var message: Any
    val token: Any
        get() {
            TODO()
        }

    data class LoginResponse(
        val isValid: Boolean, // Indica si la validación de correo y contraseña es exitosa
        val message: String? // Un mensaje opcional para describir el resultado de la validación
    )

}