package com.egmvdev.consumoapis.model

import com.google.gson.annotations.SerializedName

data class PerroResponse(
    @SerializedName("message") var imagenes:List<String>,
    var status: String )
