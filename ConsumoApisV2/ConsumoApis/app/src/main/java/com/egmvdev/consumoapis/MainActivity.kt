package com.egmvdev.consumoapis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.egmvdev.consumoapis.clases.APIInterceptor
import com.egmvdev.consumoapis.clases.APIService
import com.egmvdev.consumoapis.clases.PerroAdapter
import com.egmvdev.consumoapis.clases.PostAdapter
import com.egmvdev.consumoapis.databinding.ActivityMainBinding
import com.egmvdev.consumoapis.model.Post
import com.egmvdev.consumoapis.model.PostResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(),
    SearchView.OnQueryTextListener {
    private lateinit var bind: ActivityMainBinding

    //private lateinit var adaptador:PerroAdapter
    private  lateinit var postAdaptador: PostAdapter
    private val listaImagenes = mutableListOf<String>()
    private val listaPost = mutableListOf<PostResponse>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        //bind.svPerros.setOnQueryTextListener(this)
        iniciarRecyclerView()
        buscarPost()
    }
    //Perros
   /* fun iniciarRecyclerView(){
        adaptador= PerroAdapter(listaImagenes)
        bind.rvPerros.layoutManager = LinearLayoutManager(this)
        bind.rvPerros.adapter = adaptador
    }*/
    //Post
    fun iniciarRecyclerView(){
        postAdaptador= PostAdapter(listaPost)
        bind.rvPerros.layoutManager = LinearLayoutManager(this)
        bind.rvPerros.adapter = postAdaptador
    }

    fun obtenerRetrofit():Retrofit{
        //return  Retrofit.Builder().baseUrl("https://dog.ceo/api/breed/")
        return  Retrofit
            .Builder()
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(obtenerCliente())
            .build()
    }
    fun obtenerCliente():OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(APIInterceptor())
        .build()
        //Funcion para buscar perros por raza
    /*fun buscarPorNombre(buscar:String){
        CoroutineScope(Dispatchers.IO).launch {
            val llamada = obtenerRetrofit().create(APIService::class.java).obtenerPerrosPorRaza("$buscar/images")
            val imagenesPerros = llamada.body()
            runOnUiThread {
                if(llamada.isSuccessful){
                    listaImagenes.clear()
                    listaImagenes.addAll(imagenesPerros?.imagenes ?: emptyList())
                    adaptador.notifyDataSetChanged()
                }else{
                    Toast.makeText(this@MainActivity,"Error al ejecutar solicitud", Toast.LENGTH_LONG).show()
                }
            }

        }
    }*/
    //funcion para buscar Post
    fun buscarPost(){
        CoroutineScope(Dispatchers.IO).launch {
            val llamada = obtenerRetrofit().create(APIService::class.java).obtenerNotas("posts")
            val listPosts = llamada.body()
            runOnUiThread {
                if(llamada.isSuccessful){
                    listaPost.clear()
                    for (i in listPosts!!){
                        listaPost.add(i)
                    }
                    postAdaptador.notifyDataSetChanged()
                }else{
                    Toast.makeText(this@MainActivity,"Error al ejecutar solicitud", Toast.LENGTH_LONG).show()
                }
            }

        }
    }



    override fun onQueryTextSubmit(p0: String?): Boolean {
        if(!p0.isNullOrEmpty()){
            //buscarPorNombre(p0.lowercase())
            //buscarPost(p0.lowercase())
        }
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        return true
    }
}

