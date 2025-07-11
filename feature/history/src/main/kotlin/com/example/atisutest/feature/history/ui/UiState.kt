package com.example.atisutest.feature.history.ui

sealed class UiState {
    data object Loading : UiState()

    data class Success(
        val history: List<HistoryEntry>,
    ) : UiState()

    data class Error(
        val message: String = "",
    ) : UiState()
}

data class HistoryEntry(
    val id: Long,
    val horseName: String,
    val date: String,
)
