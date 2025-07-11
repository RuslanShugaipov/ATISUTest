package com.example.atisutest.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface TabItem {
    val title: String

    @Composable
    fun Content(modifier: Modifier)
}
