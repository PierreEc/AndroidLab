package com.example.androidlab.repository

import com.example.androidlab.model.Pokemon
import retrofit2.http.GET

interface PokemonInterface {
    @GET("/api/v1/pokemon")
    suspend fun getPokemons(): List<Pokemon>
}