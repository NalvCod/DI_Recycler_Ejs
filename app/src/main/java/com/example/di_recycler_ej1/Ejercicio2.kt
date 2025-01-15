package com.example.di_recycler_ej1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.di_recycler_ej1.databinding.ActivityEjercicio2Binding

class Ejercicio2 : AppCompatActivity() {

    private lateinit var binding : ActivityEjercicio2Binding
    private lateinit var pokemonAdapter: FichaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityEjercicio2Binding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val listaFicha: MutableList<Ficha> = mutableListOf(
            Ficha (R.drawable.fichauno, "uno"),
            Ficha (R.drawable.fichados, "dos"),
            Ficha (R.drawable.fichatres, "tres"),
            Ficha (R.drawable.fichacuatro, "cuatro"),
            Ficha (R.drawable.fichacinco, "cinco"),
            Ficha (R.drawable.fichaseis, "seis")
        )

        pokemonAdapter

    }
}