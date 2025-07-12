package com.example.atisutest.feature.history.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.atisutest.core.ui.component.ContentError
import com.example.atisutest.core.ui.component.ContentLoading
import com.example.atisutest.core.ui.theme.ATISUTESTTheme
import com.example.atisutest.feature.history.ui.HistoryEntry
import com.example.atisutest.feature.history.ui.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun Content(
    modifier: Modifier = Modifier,
    state: UiState,
    onRetryClick: () -> Unit,
) {
    PullToRefreshBox(
        isRefreshing = state is UiState.Loading,
        onRefresh = onRetryClick,
        modifier = modifier
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
                        history = state.history,
                    )
                }

                is UiState.Error -> {
                    ContentError(
                        message = state.message,
                        onRetryClicked = onRetryClick
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun HistoryScreenPreview() = ATISUTESTTheme {
    Content(
        state = UiState.Success(
            history = listOf(
                HistoryEntry(
                    id = 1L,
                    horseName = "Лошадь #1",
                    date = "2025-07-11T00:00:00"
                ),
                HistoryEntry(
                    id = 2L,
                    horseName = "Лошадь #2",
                    date = "2025-07-11T00:00:00"
                ),
                HistoryEntry(
                    id = 3L,
                    horseName = "Лошадь #3",
                    date = "2025-07-11T00:00:00"
                ),
            ),
        ),
        onRetryClick = {}
    )
}
