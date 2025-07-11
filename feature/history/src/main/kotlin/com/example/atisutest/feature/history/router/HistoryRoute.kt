package com.example.atisutest.feature.history.router

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.atisutest.core.navigation.TabItem
import com.example.atisutest.feature.history.ui.HistoryScreen

data object HistoryRoute : TabItem {
    // TODO Вынести в ресурсы
    override val title: String = "История скачек"

    @Composable
    override fun Content(modifier: Modifier) {
        HistoryScreen(
            modifier = modifier,
        )
    }
}
