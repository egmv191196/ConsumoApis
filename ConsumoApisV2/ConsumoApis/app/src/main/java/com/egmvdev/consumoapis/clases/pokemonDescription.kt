package com.egmvdev.consumoapis.clases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.egmvdev.consumoapis.R
import com.egmvdev.consumoapis.databinding.ActivityPokemonDescriptionBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class pokemonDescription : AppCompatActivity() {
    private lateinit var bind: ActivityPokemonDescriptionBinding
    private  lateinit var url: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityPokemonDescriptionBinding.inflate(layoutInflater)
        setContentView(bind.root)
        mostrarDetalles()
        url = intent.getStringExtra("url")?.removePrefix("https://pokeapi.co/api/v2/") ?: ""
    }
    fun obtenerRetrofit(): Retrofit {
        return  Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun mostrarDetalles(){
        CoroutineScope(Dispatchers.IO).launch {
            val llamada = obtenerRetrofit().create(APIService::class.java).obtenerDetallesPokemon("$url")
            val detailPokemon = llamada.body()
            runOnUiThread {
                if(llamada.isSuccessful){
                    var img=detailPokemon?.sprites?.front_default
                    bind.namePokemon.text = detailPokemon?.name?:""
                    Picasso.get().load(img).into(bind.ivPokemon)
                }else{
                    Toast.makeText(this@pokemonDescription,"Error al ejecutar solicitud", Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}