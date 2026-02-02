package com.example.androidlab.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidlab.model.Pokemon
import com.example.androidlab.repository.PokemonRepository
import kotlinx.coroutines.launch

class PokemonsViewModel : ViewModel() {
    private val repository = PokemonRepository()

    var pokemons by mutableStateOf<List<Pokemon>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            try {
                pokemons = repository.getPokemons().drop(1)
            }
            catch (e: Exception) {
                pokemons = emptyList()
            }
        }
    }
}