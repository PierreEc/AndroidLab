package com.example.androidlab.repository

import com.example.androidlab.model.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonInterface {
    @GET("/api/v1/pokemon")
    suspend fun getPokemons(): List<Pokemon>

    @GET("/api/v1/pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id: Int): Pokemon
}