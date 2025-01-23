package com.example.di_recycler_ej1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.di_recycler_ej1.databinding.ActivityMenuEjerciciosBinding
import com.example.di_recycler_ej1.Ejercicio3

class MenuEjercicios : AppCompatActivity() {
    //binding
    private lateinit var binding: ActivityMenuEjerciciosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding
        binding = ActivityMenuEjerciciosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Edge to edge
        enableEdgeToEdge()

        //que los botones me lleven a los ejercicios
        binding.button.setOnClickListener {
            startActivity(Intent(this, Ejercicio1::class.java))
        }

        binding.button2.setOnClickListener {
            startActivity(Intent(this, Ejercicio2::class.java))
        }

        binding.button3.setOnClickListener{
            startActivity(Intent(this, Ejercicio3::class.java))
        }

        binding.button4.setOnClickListener{
            startActivity(Intent(this, Ejercicios4::class.java))
        }


    }
}