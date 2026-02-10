package com.example.androidlab.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.ui.graphics.vector.ImageVector

enum class FeedbackType(val message: String, val color: Long, val icon: ImageVector) {
    SUCCESS("Bonne réponse", 0xFF2E7D32L, Icons.Filled.CheckCircle),
    ERROR("Mauvaise réponse", 0xFFC62828L, Icons.Filled.Close)
}
