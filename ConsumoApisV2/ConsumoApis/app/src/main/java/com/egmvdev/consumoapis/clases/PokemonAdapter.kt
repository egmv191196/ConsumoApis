package com.egmvdev.consumoapis.clases

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.egmvdev.consumoapis.R
import com.egmvdev.consumoapis.model.ResultPokemon

class PokemonAdapter(val pokemon: List<ResultPokemon>, val context: Context):RecyclerView.Adapter<PokemonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflador = LayoutInflater.from(parent.context)
        return  PokemonViewHolder(inflador.inflate(R.layout.itempokemon,parent,false))
    }
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(pokemon[position])
        holder.itemView.setOnClickListener{
            var intent: Intent = Intent(this.context, pokemonDescription::class.java)
            intent.putExtra("url", pokemon[position].url)
            context.startActivity(intent)
            //Toast.makeText(this.context,pokemon[position].url,Toast.LENGTH_LONG).show()
        }

    }
    override fun getItemCount(): Int = pokemon.size
}