package com.example.ratingsof


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ratingsof.api.ApiService
import com.example.ratingsof.network.ApiClient
import com.example.ratingsof.model.LoginResponse

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece la actividad en pantalla completa
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)

        // Configura animaciones
        val animacionArriba: Animation = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        val animacionAbajo: Animation = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo)

        val deTextView: TextView = findViewById(R.id.deTextView)
        val codeliaTextView: TextView = findViewById(R.id.codeLiaTextView)
        val logoImageView: ImageView = findViewById(R.id.logoImageView)

        // Aplica las animaciones a las vistas
        deTextView.startAnimation(animacionAbajo)
        codeliaTextView.startAnimation(animacionAbajo)
        logoImageView.startAnimation(animacionArriba)

        // Espera 2 segundos y luego navega a la actividad de inicio de sesión
        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000) // 2000 milisegundos (2 segundos)
    }
}
