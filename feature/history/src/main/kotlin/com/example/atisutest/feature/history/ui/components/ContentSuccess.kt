package com.example.atisutest.feature.history.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.atisutest.feature.history.ui.HistoryEntry
import com.example.atisutest.core.ui.R as UiKitR

@Composable
internal fun ContentSuccess(
    modifier: Modifier = Modifier,
    history: List<HistoryEntry>,
) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(
            top = 16.dp,
            bottom = 16.dp,
        )
    ) {
        items(history) { historyEntry ->
            HistoryEntryItem(
                historyEntry = historyEntry,
            )
        }
    }
}

@Composable
private fun HistoryEntryItem(
    modifier: Modifier = Modifier,
    historyEntry: HistoryEntry,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CompositionLocalProvider(
            LocalContentColor provides MaterialTheme.colorScheme.onPrimaryContainer,
        ) {
            Column {
                Text(
                    text = stringResource(UiKitR.string.item_history_title, historyEntry.id),
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = stringResource(UiKitR.string.item_history_horse, historyEntry.horseName),
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = stringResource(UiKitR.string.item_history_date, historyEntry.date),
                )
            }
        }
    }
}
