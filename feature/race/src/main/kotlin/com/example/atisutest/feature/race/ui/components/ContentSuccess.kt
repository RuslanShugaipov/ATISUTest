package com.example.atisutest.feature.race.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.atisutest.feature.race.ui.Horse
import com.example.atisutest.core.ui.R as UiKitR

@Composable
internal fun ContentSuccess(
    modifier: Modifier = Modifier,
    horses: List<Horse>,
    onStartClick: () -> Unit,
    onRestartClick: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            RaceControls(
                onStartClick = onStartClick,
                onRestartClick = onRestartClick,
            )
        }
    ) { paddings ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    top = paddings.calculateTopPadding(),
                    bottom = paddings.calculateBottomPadding(),
                    start = 16.dp,
                    end = 16.dp
                ),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(horses) { horse ->
                HorseIndicator(
                    horse = horse,
                )
            }
        }
    }
}

@Composable
private fun RaceControls(
    modifier: Modifier = Modifier,
    onStartClick: () -> Unit,
    onRestartClick: () -> Unit
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onStartClick,
            content = {
                Text(
                    text = stringResource(UiKitR.string.button_title_start)
                )
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onRestartClick,
            content = {
                Text(
                    text = stringResource(UiKitR.string.button_title_restart)
                )
            }
        )
    }
}

@Composable
private fun HorseIndicator(
    modifier: Modifier = Modifier,
    horse: Horse,
) {
    Column(
        modifier = modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.align(Alignment.Start),
            text = horse.name,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        LinearProgressIndicator(
            progress = { horse.progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )
    }
}
