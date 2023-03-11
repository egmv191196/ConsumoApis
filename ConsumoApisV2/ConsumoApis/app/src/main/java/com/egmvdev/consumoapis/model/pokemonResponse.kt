package com.egmvdev.consumoapis.model

data class pokemonResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<ResultPokemon>
)
data class ResultPokemon(
    val name: String,
    val url: String
)
data class detailPokemon(
    val name: String,
    val sprites: Sprites,
)

data class Sprites(
    val back_default: String,
    val back_female: Any,
    val back_shiny: String,
    val back_shiny_female: Any,
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shiny_female: Any
)
