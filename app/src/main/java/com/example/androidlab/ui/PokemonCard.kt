package com.example.androidlab.ui

import com.example.androidlab.model.Pokemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage

@Composable
fun PokemonCard(pokemon: Pokemon) {
    Card {
        Column(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = pokemon.image,
                contentDescription = pokemon.name,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .wrapContentHeight(),
                contentScale = ContentScale.None
            )
            Text(
                text = pokemon.name,
                style = typography.titleMedium,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}