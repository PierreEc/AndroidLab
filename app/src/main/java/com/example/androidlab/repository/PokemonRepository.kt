package com.example.androidlab.repository

import com.example.androidlab.model.Pokemon

class PokemonRepository {
    suspend fun getPokemons(): List<Pokemon> {
        return RetrofitClient.api.getPokemons()
    }
}