package com.egmvdev.consumoapis.model

import com.google.gson.annotations.SerializedName

//data class PostResponse(    @SerializedName("") var notas:List<Post>)
//No es una lista? de tipo Post
data class PostResponse(var userId: String, var id: String, var title: String, var body: String)
