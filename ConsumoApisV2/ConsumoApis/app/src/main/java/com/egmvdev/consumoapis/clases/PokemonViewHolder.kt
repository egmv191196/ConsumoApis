package com.egmvdev.consumoapis.clases

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.egmvdev.consumoapis.databinding.ItempokemonBinding
import com.egmvdev.consumoapis.model.ResultPokemon

class PokemonViewHolder(vista: View): RecyclerView.ViewHolder(vista) {
    private val bind = ItempokemonBinding.bind(vista)
    fun bind(pokemon: ResultPokemon){
        bind.tvName.text = pokemon.name
        bind.tvURL.text = pokemon.url
    }
}