package com.example.atisutest.feature.history.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.atisutest.core.common.entity.Entity
import com.example.atisutest.core.data.repository.RaceHistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val raceHistoryRepository: RaceHistoryRepository,
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    init {
        loadHistory()
    }

    fun loadHistory() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            delay(HISTORY_LOAD_DELAY)

            when (val result = raceHistoryRepository.getRaceHistory()) {
                is Entity.Success -> {
                    val history = result.data.map {
                        HistoryEntry(
                            id = it.id,
                            horseName = it.horseName,
                            date = it.date
                        )
                    }

                    _uiState.value = UiState.Success(
                        history = history
                    )
                }

                is Entity.Error -> {
                    _uiState.value = UiState.Error(
                        message = result.exception.message.toString()
                    )
                }
            }
        }
    }

    companion object {
        private const val HISTORY_LOAD_DELAY = 500L
    }
}
