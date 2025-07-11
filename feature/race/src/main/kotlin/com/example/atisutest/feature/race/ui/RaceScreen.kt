package com.example.atisutest.feature.race.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.atisutest.feature.race.ui.components.Content

@Composable
internal fun RaceScreen(
    modifier: Modifier = Modifier,
    viewModel: RaceViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Content(
        modifier = modifier,
        state = state,
        onStartClick = viewModel::startRace,
        onRestartClick = viewModel::restartRace,
    )
}
