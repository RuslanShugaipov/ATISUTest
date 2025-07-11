package com.example.atisutest.feature.race.ui

sealed class UiState {
    data object Loading : UiState()

    data class Success(
        val horses: List<Horse>,
    ) : UiState()

    data class Error(
        val message: String = "",
    ) : UiState()
}

data class Horse(
    val id: Long,
    val name: String,
    val progress: Float = 0f,
)
