package com.example.consumoapis.model

import com.google.gson.annotations.SerializedName

data class DogResponse(
    @SerializedName("message")
    val imagenes : List<String>,
    val status : String)
