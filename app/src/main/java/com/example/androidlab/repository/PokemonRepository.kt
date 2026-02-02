package com.example.androidlab.repository

import com.example.androidlab.model.Name
import com.example.androidlab.model.Pokemon;
import com.example.androidlab.model.Sprites

class PokemonRepository {
    suspend fun getPokemons(): List<Pokemon> {
        return listOf(
            Pokemon(
                "Bulbizarre",
                name = Name("Pokémon Graine"),
                sprites = Sprites("https://raw.githubusercontent.com/Yarkis01/TyraDex/images/sprites/1/regular.png")
            ),
            Pokemon(
                "Herbizarre",
                name = Name("Pokémon Graine"),
                sprites = Sprites("https://raw.githubusercontent.com/Yarkis01/TyraDex/images/sprites/2/regular.png")
            )
        )
    }
}
