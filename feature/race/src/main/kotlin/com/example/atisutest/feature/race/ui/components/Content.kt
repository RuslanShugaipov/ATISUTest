package com.example.atisutest.feature.race.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.atisutest.core.ui.component.ContentError
import com.example.atisutest.core.ui.component.ContentLoading
import com.example.atisutest.core.ui.theme.ATISUTESTTheme
import com.example.atisutest.feature.race.ui.Horse
import com.example.atisutest.feature.race.ui.UiState

@Composable
internal fun Content(
    modifier: Modifier = Modifier,
    state: UiState,
    onStartClick: () -> Unit,
    onRestartClick: () -> Unit,
) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        when (state) {
            is UiState.Loading -> {
                ContentLoading()
            }

            is UiState.Success -> {
                ContentSuccess(
                    horses = state.horses,
                    onStartClick = onStartClick,
                    onRestartClick = onRestartClick
                )
            }

            is UiState.Error -> {
                ContentError(
                    message = state.message,
                    onRetryClicked = {
                        // TODO
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun RaceScreenPreview() = ATISUTESTTheme {
    Content(
        state = UiState.Success(
            horses = listOf(
                Horse(
                    id = 1L,
                    name = "Лошадь #1",
                    progress = 0f,
                ),
                Horse(
                    id = 2L,
                    name = "Лошадь #2",
                    progress = 0.5f,
                ),
                Horse(
                    id = 3L,
                    name = "Лошадь #3",
                    progress = 1f,
                ),
            ),
        ),
        onStartClick = {},
        onRestartClick = {}
    )
}
