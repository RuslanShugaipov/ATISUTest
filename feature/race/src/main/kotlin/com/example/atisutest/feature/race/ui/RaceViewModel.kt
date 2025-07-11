package com.example.atisutest.feature.race.ui

import androidx.lifecycle.ViewModel
import com.example.atisutest.core.data.repository.RaceHistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class RaceViewModel @Inject constructor(
    private val raceHistoryRepository: RaceHistoryRepository,
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    fun startRace() {
        // TODO
    }

    fun restartRace() {
        // TODO
    }
}
