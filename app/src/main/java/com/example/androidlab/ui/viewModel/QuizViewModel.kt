package com.example.androidlab.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidlab.model.Pokemon
import com.example.androidlab.repository.PokemonRepository
import com.example.androidlab.model.FeedbackType
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuizViewModel : ViewModel() {
    private val repository = PokemonRepository()

    var answers by mutableStateOf<List<String>>(emptyList())
        private set
    var pokemon by mutableStateOf<Pokemon?>(null)
        private set

    var buttonsEnabled by mutableStateOf(true)
        private set
    var feedback by mutableStateOf<FeedbackType?>(null)
        private set

    init {
        getPokemonToQuiz()
    }

    private fun getPokemonToQuiz() {
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

    fun verifyAnswer(answer: String) {
        buttonsEnabled = false
        feedback = if (answer == pokemon?.name?.fr) FeedbackType.SUCCESS else FeedbackType.ERROR
        viewModelScope.launch {
            delay(1500)
            getPokemonToQuiz()
            feedback = null
            buttonsEnabled = true
        }
    }
}
