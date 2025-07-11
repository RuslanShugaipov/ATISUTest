package com.example.atisutest.core.data.repository

import com.example.atisutest.core.common.entity.Entity
import com.example.atisutest.core.data.model.RaceResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class RaceHistoryRepositoryImpl @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher,
) : RaceHistoryRepository {

    override suspend fun saveRaceResult(
        result: RaceResult
    ): Entity<Unit> = withContext(ioDispatcher) {
        try {
            // TODO

            Entity.Success(Unit)
        } catch (exception: Exception) {
            Entity.Error(exception)
        }
    }
}
