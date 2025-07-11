package com.example.atisutest.core.data.repository

import com.example.atisutest.core.common.entity.Entity
import com.example.atisutest.core.data.model.RaceResult

interface RaceHistoryRepository {
    suspend fun saveRaceResult(result: RaceResult): Entity<Unit>
}
