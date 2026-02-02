package com.example.androidlab.repository

import com.example.androidlab.model.Pokemon;

class PokemonRepository {
    suspend fun getPokemons(): List<Pokemon> {
        return listOf(
            Pokemon(
                "Bulbizarre",
                "Pokémon Graine",
                "https://raw.githubusercontent.com/Yarkis01/TyraDex/images/sprites/1/regular.png",
                "Herbizarre"
            ),
            Pokemon(
                "Herbizarre",
                "Pokémon Graine",
                "https://raw.githubusercontent.com/Yarkis01/TyraDex/images/sprites/2/regular.png",
                " Florizarre"
            )
        )
    }
}
