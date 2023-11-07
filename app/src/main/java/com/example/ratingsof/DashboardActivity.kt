package com.example.ratingsof

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ratingsof.R

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        val misionButton: Button = findViewById(R.id.misionButton)
        val visionButton: Button = findViewById(R.id.visionButton)
        val cursosButton: Button = findViewById(R.id.cursosButton)
        val gestionUsuarioButton: Button = findViewById(R.id.gestionUsuarioButton)


        misionButton.setOnClickListener {
            val intent = Intent(this, misionButton::class.java)
            startActivity(intent)
        }

        visionButton.setOnClickListener {
            val intent = Intent(this, Mision::class.java)
            startActivity(intent)
        }

        cursosButton.setOnClickListener {
            val intent = Intent(this, Cursos::class.java)
            startActivity(intent)
        }

        gestionUsuarioButton.setOnClickListener {
            val intent = Intent(this, GestionUsuario::class.java)
            startActivity(intent)
        }

    }
}
