package com.example.di_recycler_ej1

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.di_recycler_ej1.databinding.ActivityItemPokemonBinding
import kotlin.collections.indexOf
import kotlin.collections.remove

class PokemonCapturadosAdapter (private var listaPokemon: MutableList<Pokemon>, private var listaPokemonCapturados: MutableList<Pokemon>, private val listener: OnClickListener): RecyclerView.Adapter<PokemonCapturadosAdapter.ViewHolder>() {
    //inner class
    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val binding =
            ActivityItemPokemonBinding.bind(view) //Para acceder a los elementos del layout del item

        fun setListener(pokemon: Pokemon) {
            binding.root.setOnLongClickListener {
                listener.onLongClick(pokemon)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_pokemon, parent, false)
        return ViewHolder(view)
    }

    //Es la función que se ejecuta cada vez que un elemento es visible. El recycler le inyecta los datos
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = listaPokemonCapturados.get(position)
        holder.setListener(pokemon)
        holder.binding.tituloPokemon.text = pokemon.nombre
        holder.binding.check.isChecked = pokemon.atrapado
        holder.binding.check.setOnClickListener {
            if (!holder.binding.check.isChecked) {
                pokemon.atrapado = false
                liberarPokemon(pokemon)
            }
        }
    }

    override fun getItemCount(): Int {
        return listaPokemonCapturados.size
    }

    fun liberarPokemon(pokemon: Pokemon) {
        listaPokemonCapturados.remove(pokemon)
        listener.pokemonCambiado(pokemon)
        notifyItemRemoved(listaPokemonCapturados.indexOf(pokemon))
    }

    fun addPokemonAtrapados(pokemon:Pokemon){
        listaPokemonCapturados.add(pokemon)
        Log.v("PokemonCapturadosAdapter", "Pokemon atrapado: ${pokemon.nombre}")
    }

    fun removePokemon(pokemon:Pokemon){
            listaPokemonCapturados.remove(pokemon)


    }
}