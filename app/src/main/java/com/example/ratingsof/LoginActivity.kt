package com.example.ratingsof

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton = findViewById<View>(R.id.loginButton)

        loginButton.setOnClickListener {
            // Verificar las credenciales de inicio de sesión aquí (por ejemplo, username y password)

            // Si las credenciales son válidas, redirige al dashboard
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
    }
}
