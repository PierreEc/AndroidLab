package com.example.androidlab.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidlab.model.Pokemon
import com.example.androidlab.repository.PokemonRepository
import kotlinx.coroutines.launch

class QuizViewModel : ViewModel() {
    private val repository = PokemonRepository()

    var answers by mutableStateOf<List<String>>(emptyList())
        private set
    var pokemon by mutableStateOf<Pokemon?>(null)
        private set

    fun getPokemonToQuiz() {
        viewModelScope.launch {
            val random = (1..1025).random()
            pokemon = repository.getPokemonById(random)
            val allPokemons = repository.getPokemons()
                .map { it.name.fr }
            val randomPokemon = allPokemons[random]
            val pokemons = allPokemons
                .drop(random)
                .drop(0)
                .shuffled()
                .take(3)
            answers = (pokemons + randomPokemon).shuffled()
        }
    }
}
