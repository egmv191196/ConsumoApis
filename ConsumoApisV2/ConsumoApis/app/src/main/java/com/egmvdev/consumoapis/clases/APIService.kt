package com.egmvdev.consumoapis.clases

import com.egmvdev.consumoapis.model.PerroResponse
import com.egmvdev.consumoapis.model.PostResponse
import com.egmvdev.consumoapis.model.detailPokemon
import com.egmvdev.consumoapis.model.pokemonResponse
import retrofit2.Response
import retrofit2.http.*

interface APIService {
    @GET
    suspend fun obtenerPerrosPorRaza(@Url url: String):Response<PerroResponse>
    @GET("raza/imagen")
    suspend fun obtenerPerrosPorRaza2():Response<PerroResponse>
    @GET("{raza}/imagen")
    suspend fun obtenerPerrosPorRaza3(@Path("raza") raza:String):Response<PerroResponse>
    @GET("raza/imagen")
    suspend fun obtenerPerrosPorRaza4(@Query("raza") raza:String):Response<PerroResponse>
    @POST("raza/perro")
    suspend fun agregarPerro(@Body perroRequest: PerroResponse):Response<PerroResponse>//el request es lo que manda, necesito una clase de ese tipo
    @PUT("raza/perro/{id}")
    suspend fun editarPerro(@Path("id") id:String,@Body perroRequest: PerroResponse):Response<PerroResponse>
    @PATCH("raza/perro/{id}")
    suspend fun editarPerroPatch(@Path("id") id: String,@Body perroRequest: PerroResponse):Response<PerroResponse>
    @DELETE("raza/perro/{id}")
    suspend fun borrarPerro(@Path("id") id: String):Response<PerroResponse>
    @GET
    suspend fun obtenerNotas(@Url url: String):Response<List<PostResponse>>//List es porque recibe un arreglo de postRersponse
    @GET
    suspend fun  obtenerPokemon(@Url url: String): Response<pokemonResponse>
    @GET
    suspend fun obtenerDetallesPokemon(@Url url: String): Response<detailPokemon>
}

