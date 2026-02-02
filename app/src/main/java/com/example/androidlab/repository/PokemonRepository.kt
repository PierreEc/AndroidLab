package com.example.androidlab.repository

import com.example.androidlab.model.Pokemon

class PokemonRepository {
    suspend fun getPokemons(): List<Pokemon> {
        return RetrofitClient.api.getPokemons()
    }

    suspend fun getPokemonById(id: Int): Pokemon {
        return RetrofitClient.api.getPokemonById(id)
    }
}