package com.example.consumoapis.classes

import com.example.consumoapis.model.DogResponse
import com.example.consumoapis.model.QuoteElement
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun obtenerPerrosPorRaza(@Url url: String) : Response<DogResponse>

    @GET
    suspend fun getQuotes(@Url url: String) : Response<List<QuoteElement>>
}