package com.example.androidlab.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.androidlab.ui.viewModel.QuizViewModel

@Composable
fun FeedbackSnackbar(snackbarState: SnackbarHostState,
                     viewModel: QuizViewModel) {
    SnackbarHost(hostState = snackbarState) { data: SnackbarData ->
        val background = viewModel.feedback?.let { Color(it.color) } ?: MaterialTheme.colorScheme.surface
        val icon = viewModel.feedback?.icon ?: Icons.Filled.CheckCircle
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = background,
            tonalElevation = 6.dp,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = icon, contentDescription = null, tint = Color.White, modifier = Modifier.padding(end = 12.dp).size(20.dp))
                Text(text = data.visuals.message, color = Color.White, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

