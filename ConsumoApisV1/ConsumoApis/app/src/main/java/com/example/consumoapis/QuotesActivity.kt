package com.example.consumoapis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.consumoapis.classes.ApiService
import com.example.consumoapis.classes.QuoteAdapter
import com.example.consumoapis.databinding.ActivityQuotesBinding
import com.example.consumoapis.model.QuoteElement
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuotesActivity : AppCompatActivity() {

    private val BASE_URL = "https://programming-quotes-api.herokuapp.com/"
    private lateinit var binding : ActivityQuotesBinding
    private lateinit var adaptador : QuoteAdapter
    private val listQuote = mutableListOf<QuoteElement>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()
        getQuotes()
    }

    fun getQuotes(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit()
                .create(ApiService::class.java)
                .getQuotes("quotes")
            val infoQuote = call.body()

            runOnUiThread {
                if (call.isSuccessful){
                    listQuote.clear()
                    Log.i("Quotes", infoQuote.toString())
                    for (i in infoQuote!!){
                        listQuote.add(i)
                    }

                    adaptador.notifyDataSetChanged()
                } else {
                    Toast.makeText(this@QuotesActivity, "Ocurrio un error en la solicitud", Toast.LENGTH_LONG).show()
                }
            }
        }

    }

    private fun initRecycler(){
        adaptador = QuoteAdapter(listQuote)
        binding.rvQuotes.layoutManager = LinearLayoutManager(this)
        binding.rvQuotes.adapter = adaptador

    }

    fun getRetrofit () : Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}