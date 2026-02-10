package com.example.androidlab.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.Layout
import com.example.androidlab.ui.viewModel.QuizViewModel


@Composable
fun AnswersQuiz(
    viewModel: QuizViewModel,
    answers: List<String>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val rows = answers.chunked(2)
        rows.forEachIndexed { index, pair ->
            TwoColumnRow(spacing = 8.dp,
                firstContent = {
                    Button(
                        enabled = viewModel.buttonsEnabled,
                        onClick = { viewModel.verifyAnswer(pair.first()) }
                    ) {
                        Text(pair.first())
                    }
                },
                secondContent = {
                    Button(
                        enabled = viewModel.buttonsEnabled,
                        onClick = { viewModel.verifyAnswer(pair.last()) }
                    ) {
                        Text(pair.last())
                    }
                }
            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
private fun TwoColumnRow(
    spacing: Dp = 8.dp,
    firstContent: @Composable () -> Unit,
    secondContent: @Composable () -> Unit
) {
    val density = LocalDensity.current
    Layout(
        content = {
            firstContent()
            secondContent()
        },
        modifier = Modifier.fillMaxWidth()
    ) { measurables, constraints ->
        val spacingPx = with(density) { spacing.roundToPx() }
        val maxWidth = constraints.maxWidth
        val childWidth = (maxWidth - spacingPx) / 2
        val childConstraints = constraints.copy(minWidth = childWidth, maxWidth = childWidth)

        val placeables = measurables.map { it.measure(childConstraints) }
        val height = (placeables.maxOfOrNull { it.height } ?: 0)

        layout(maxWidth, height) {
            var x = 0
            placeables.forEachIndexed { idx, p ->
                p.placeRelative(x, 0)
                if (idx == 0) x += p.width + spacingPx
            }
        }
    }
}
