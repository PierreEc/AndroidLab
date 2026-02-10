package com.example.androidlab.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.androidlab.ui.components.FeedbackSnackbar
import com.example.androidlab.ui.components.QuizTopBar
import com.example.androidlab.ui.viewModel.QuizViewModel


@ExperimentalMaterial3Api
@Suppress("UNUSED_PARAMETER")
@Composable
fun Quiz(navController: NavHostController,
         param: String,
         viewModel: QuizViewModel = viewModel()) {

    val pokemon = viewModel.pokemon
    val answers = viewModel.answers

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(viewModel.feedback) {
        viewModel.feedback?.let { fb ->
            snackbarHostState.showSnackbar(fb.message)
        }
    }

    Scaffold(
        topBar = { QuizTopBar(navController) },
        snackbarHost = { FeedbackSnackbar(snackbarHostState, viewModel) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            if (pokemon == null) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            else {
                AsyncImage(
                    model = pokemon.sprites.regular,
                    contentDescription = pokemon.name.fr,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .wrapContentHeight()
                        .padding(32.dp),
                    contentScale = ContentScale.None,
                    colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0f) })
                )
                if (answers.size < 4) {
                    return@Column
                }
                else {
                    AnswersQuiz(viewModel, answers)
                }
            }
        }
    }
}