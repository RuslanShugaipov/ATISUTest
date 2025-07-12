package com.example.atisutest.feature.race.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.atisutest.core.common.entity.Entity
import com.example.atisutest.core.data.model.RaceResultEntity
import com.example.atisutest.core.data.repository.RaceHistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class RaceViewModel @Inject constructor(
    private val raceHistoryRepository: RaceHistoryRepository,
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    private var raceJob: Job? = null

    init {
        viewModelScope.launch {
            _uiState.value = UiState.Success(
                horses = TEST_HORSES
            )
        }
    }

    fun startRace() {
        raceJob?.cancel()

        raceJob = viewModelScope.launch {
            var winnerHorse: Horse? = null
            val progresses = TEST_HORSES
                .associate { it.id to RACE_MIN_PROGRESS }
                .toMutableMap()

            while (winnerHorse == null && isActive) {
                delay(RACE_PROGRESS_DELAY)

                for ((id, progress) in progresses) {
                    val progressStep =
                        (RACE_MIN_PROGRESS_STEP..RACE_MAX_PROGRESS_STEP).random() / RACE_PROGRESS_SCALE
                    progresses[id] = (progress + progressStep).coerceAtMost(RACE_MAX_PROGRESS)
                }

                val updatedHorses = TEST_HORSES.map {
                    it.copy(progress = progresses[it.id] ?: RACE_MIN_PROGRESS)
                }

                _uiState.value = UiState.Success(
                    horses = updatedHorses
                )

                winnerHorse = updatedHorses
                    .firstOrNull { it.progress >= RACE_MAX_PROGRESS }
                    .also { horse ->
                        if (horse != null) {
                            delay(RACE_RESTART_DELAY)
                            saveWinner(horse)
                        }
                    }
            }
        }
    }

    private fun saveWinner(winner: Horse) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            val date = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
            val raceResult = RaceResultEntity(
                horseName = winner.name,
                date = date
            )

            when (val result = raceHistoryRepository.saveRaceResult(raceResult)) {
                is Entity.Success -> {
                    _uiState.value = UiState.Success(
                        horses = TEST_HORSES
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

    fun restartRace() {
        raceJob?.cancel()

        viewModelScope.launch {
            _uiState.value = UiState.Loading

            delay(RACE_RESTART_DELAY)

            _uiState.value = UiState.Success(
                horses = TEST_HORSES
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        raceJob?.cancel()
    }

    companion object {
        private const val RACE_PROGRESS_DELAY = 100L
        private const val RACE_RESTART_DELAY = 500L
        private const val RACE_MIN_PROGRESS = 0f
        private const val RACE_MAX_PROGRESS = 1f
        private const val RACE_MIN_PROGRESS_STEP = 5
        private const val RACE_MAX_PROGRESS_STEP = 10
        private const val RACE_PROGRESS_SCALE = 100f

        private val TEST_HORSES = listOf(
            Horse(
                id = 1L,
                name = "Лошадь #1",
                progress = 0f,
            ),
            Horse(
                id = 2L,
                name = "Лошадь #2",
                progress = 0f,
            ),
            Horse(
                id = 3L,
                name = "Лошадь #3",
                progress = 0f,
            ),
        )
    }
}
