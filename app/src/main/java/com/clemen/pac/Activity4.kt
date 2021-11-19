package com.clemen.pac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clemen.pac.databinding.Activity4Binding


class Activity4 : AppCompatActivity() {
    private lateinit var binding: Activity4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Usamos view Binding para la vinculacion de las vistas
        binding = Activity4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Gestionamos el click del boton main, termina esta vista, regresa a la vista main
        binding.button4Main.setOnClickListener {
            finish()
        }
    }
}