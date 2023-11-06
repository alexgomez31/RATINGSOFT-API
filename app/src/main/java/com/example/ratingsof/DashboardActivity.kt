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
        setContentView(R.layout.activity_main)

        val misionButton: Button = findViewById(R.id.misionButton)
        val visionButton: Button = findViewById(R.id.visionButton)
        val cursosButton: Button = findViewById(R.id.cursosButton)
        val gestionUsuarioButton: Button = findViewById(R.id.gestionUsuarioButton)
        val acercaDeButton: Button = findViewById(R.id.acercaDeButton)
        val saberMasButton: Button = findViewById(R.id.saberMasButton)

        misionButton.setOnClickListener {
            val intent = Intent(this::class.java)
            startActivity(intent)
        }

        visionButton.setOnClickListener {
            val intent = Intent(this, VisionActivity::class.java)
            startActivity(intent)
        }

        cursosButton.setOnClickListener {
            val intent = Intent(this, CursosActivity::class.java)
            startActivity(intent)
        }

        gestionUsuarioButton.setOnClickListener {
            val intent = Intent(this, GestionUsuarioActivity::class.java)
            startActivity(intent)
        }

        acercaDeButton.setOnClickListener {
            val intent = Intent(this, AcercaDeActivity::class.java)
            startActivity(intent)
        }

        saberMasButton.setOnClickListener {
            val intent = Intent(this, SaberMasActivity::class.java)
            startActivity(intent)
        }
    }
}
