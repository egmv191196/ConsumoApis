package com.egmvdev.consumoapis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.egmvdev.consumoapis.clases.APIService
import com.egmvdev.consumoapis.clases.PokemonAdapter
import com.egmvdev.consumoapis.databinding.ActivityPokemonBinding
import com.egmvdev.consumoapis.model.ResultPokemon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonActivity : AppCompatActivity() {
    private lateinit var bind: ActivityPokemonBinding
    private  lateinit var pokemonAdaptador: PokemonAdapter
    private val listaPokemon = mutableListOf<ResultPokemon>()
    private lateinit var ant: String
    private lateinit var post: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityPokemonBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.btnAnt.setOnClickListener {
            if (ant.isNotEmpty())
            mostrarPokemon(ant)
        }
        bind.btnPost.setOnClickListener {
            if (post.isNotEmpty()){
                mostrarPokemon(post)
            }
        }
        iniciarRecyclerView()
        mostrarPokemon("pokemon?limit=20&offset=0")
    }

    fun iniciarRecyclerView(){
        pokemonAdaptador= PokemonAdapter(listaPokemon, this)
        bind.rvPokemon.layoutManager = LinearLayoutManager(this)
        bind.rvPokemon.adapter = pokemonAdaptador
    }

    fun obtenerRetrofit(): Retrofit {
        return  Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun mostrarPokemon(url:String){
        CoroutineScope(Dispatchers.IO).launch {
            val llamada = obtenerRetrofit().create(APIService::class.java).obtenerPokemon(url)
            val listPokemon = llamada.body()
            runOnUiThread {
                if(llamada.isSuccessful){
                    ant = listPokemon?.previous?:""
                    post = listPokemon?.next?:""
                    listaPokemon.clear()
                    listaPokemon.addAll(listPokemon?.results ?: emptyList())
                    pokemonAdaptador.notifyDataSetChanged()
                }else{
                    Toast.makeText(this@PokemonActivity,"Error al ejecutar solicitud", Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}