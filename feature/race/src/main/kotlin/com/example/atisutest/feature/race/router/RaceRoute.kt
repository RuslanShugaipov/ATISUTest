package com.example.atisutest.feature.race.router

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.atisutest.core.navigation.TabItem
import com.example.atisutest.feature.race.ui.RaceScreen


data object RaceRoute : TabItem {
    // TODO Вынести в ресурсы
    override val title: String = "Скачки"

    @Composable
    override fun Content(modifier: Modifier) {
        RaceScreen(
            modifier = modifier,
        )
    }
}

