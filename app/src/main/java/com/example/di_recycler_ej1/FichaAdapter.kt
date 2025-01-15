package com.example.di_recycler_ej1

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.di_recycler_ej1.databinding.ActivityEjercicio2Binding
import com.example.di_recycler_ej1.databinding.ItemAjedrezBinding

class FichaAdapter (private val listaFichas: List<Ficha>, private val listener : OnClickListener): RecyclerView.Adapter<FichaAdapter.ViewHolder>() {

    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemAjedrezBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FichaAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_ejercicio2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Le damos un valor a los elementos de la lista
        val ficha = listaFichas.get(position)
        holder.binding.ficha.text = ficha.ficha
    }


    override fun getItemCount(): Int = listaFichas.size
}