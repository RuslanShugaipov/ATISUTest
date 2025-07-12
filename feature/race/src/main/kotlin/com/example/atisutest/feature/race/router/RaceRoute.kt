package com.example.atisutest.feature.race.router

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.atisutest.core.navigation.TabItem
import com.example.atisutest.feature.race.ui.RaceScreen

private const val RACE_ROUTE = "Скачки"

data object RaceRoute : TabItem {
    override val title: String = RACE_ROUTE

    @Composable
    override fun Content(modifier: Modifier) {
        RaceScreen(
            modifier = modifier,
        )
    }
}

