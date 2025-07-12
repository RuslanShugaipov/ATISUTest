package com.example.atisutest.core.data.repository

import com.example.atisutest.core.common.entity.Entity
import com.example.atisutest.core.data.model.RaceResultEntity

interface RaceHistoryRepository {
    suspend fun saveRaceResult(result: RaceResultEntity): Entity<Unit>
    suspend fun getRaceHistory(): Entity<List<RaceResultEntity>>
}
