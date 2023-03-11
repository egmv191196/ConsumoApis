package com.example.consumoapis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.consumoapis.classes.ApiService
import com.example.consumoapis.classes.PerroAdapter
import com.example.consumoapis.databinding.ActivityMainBinding
import com.example.consumoapis.model.DogResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private val BASE_URL = "https://dog.ceo/api/breed/"
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptador : PerroAdapter
    private val listaImagenes = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svPerros.setOnQueryTextListener(this)
        iniciarRecyclerView()
    }

    fun iniciarRecyclerView() {
        adaptador = PerroAdapter(listaImagenes)
        binding.rvPerros.layoutManager = LinearLayoutManager(this)
        binding.rvPerros.adapter = adaptador
    }

    fun buscarPorNombre(buscar : String){
        CoroutineScope(Dispatchers.IO).launch {
            val llamada = obtenerRetrofit()
                .create(ApiService::class.java)
                .obtenerPerrosPorRaza("$buscar/images")
            val imagenesPerros = llamada.body()
            runOnUiThread {
                if (llamada.isSuccessful){
                    listaImagenes.clear()
                    listaImagenes.addAll(imagenesPerros?.imagenes ?: emptyList())
                    adaptador.notifyDataSetChanged()

                } else {
                    Toast.makeText(this@MainActivity, "Ocurrio un error en la solicitud", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    // CONSTRUYE UNA INSTANCIA DE RETROFIT
    fun obtenerRetrofit() : Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()) buscarPorNombre(query.lowercase())

        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        return true
    }
}