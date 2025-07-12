package com.example.atisutest.feature.history.router

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.atisutest.core.navigation.TabItem
import com.example.atisutest.feature.history.ui.HistoryScreen

private const val HISTORY_ROUTE = "История скачек"

data object HistoryRoute : TabItem {
    override val title: String = HISTORY_ROUTE

    @Composable
    override fun Content(modifier: Modifier) {
        HistoryScreen(
            modifier = modifier,
        )
    }
}
