package com.example.di_recycler_ej1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.di_recycler_ej1.OnClickListener
import com.example.di_recycler_ej1.Pokemon
import com.example.di_recycler_ej1.PokemonAdapter
import com.example.di_recycler_ej1.databinding.ActivityEjercicios4Binding

class Ejercicios4 : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityEjercicios4Binding
    private lateinit var pokemonAdapter: PokemonAdapter
    private lateinit var pokemonCapturadosAdapter : PokemonCapturadosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEjercicios4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        val listaPokemon: MutableList<Pokemon> = mutableListOf(
            Pokemon("Pikachu", 55, "Eléctrico", 10),
            Pokemon("Charmander", 52, "Fuego", 8),
            Pokemon("Bulbasaur", 49, "Planta/Veneno", 9),
            Pokemon("Squirtle", 48, "Agua", 7),
            Pokemon("Jigglypuff", 40, "Hada", 6),
            Pokemon("Meowth", 45, "Normal", 7),
            Pokemon("Eevee", 50, "Normal", 12),
            Pokemon("Snorlax", 110, "Normal", 15),
            Pokemon("Squirtle", 48, "Agua", 7),
            Pokemon("Machop", 70, "Lucha", 14),
            Pokemon("Gengar", 120, "Fantasma/Veneno", 20),
            Pokemon("Lucario", 130, "Lucha/Acero", 18),
            Pokemon("Zubat", 40, "Veneno/Volador", 8),
            Pokemon("Pidgey", 45, "Normal/Volador", 5)
        )

        val listaPokemonAtrapados : MutableList<Pokemon> = mutableListOf()
        pokemonAdapter = PokemonAdapter(listaPokemon, this)
        pokemonCapturadosAdapter = PokemonCapturadosAdapter(listaPokemonAtrapados, listaPokemonAtrapados, this)

        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@Ejercicios4)
            adapter = pokemonAdapter
        }

        binding.recyclerAtrapados.apply {
            layoutManager = LinearLayoutManager(this@Ejercicios4)
            adapter = pokemonCapturadosAdapter
        }

        binding.add.setOnClickListener{
            if (binding.buscadorPokemon.text.toString().isNotEmpty()){
                val pokemon = Pokemon (binding.buscadorPokemon.text.toString())
                addPokemonAutomatically(pokemon)
            }
        }
    }

    private fun addPokemonAutomatically(pokemon : Pokemon){
        pokemonAdapter.addPokemon(pokemon)
    }

    private fun removePokemonAutomatically(pokemon:Pokemon){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Eliminar Pokémon")
        builder.setMessage("¿Quieres eliminar el Pokémon?")
        builder.setPositiveButton("Si"){ _,_ ->
            pokemonAdapter.removePokemon(pokemon)
            pokemonCapturadosAdapter.addPokemonAtrapados(pokemon)
            pokemonCapturadosAdapter.notifyDataSetChanged()

        }
        builder.setNegativeButton("No"){_,_ ->
        }
        builder.show()
    }

    override fun onLongClick(pokemon: Pokemon) {
        removePokemonAutomatically(pokemon)
    }

    override fun pokemonCambiado(pokemon: Pokemon) {
        pokemonAdapter.removePokemon(pokemon)
        pokemonCapturadosAdapter.addPokemonAtrapados(pokemon)
        pokemonCapturadosAdapter.notifyDataSetChanged()
        pokemonAdapter.notifyDataSetChanged()

    }

    override fun pokemonVuelta(pokemon: Pokemon) {

    }
}