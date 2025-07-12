package com.example.atisutest.core.data.repository

import com.example.atisutest.core.common.entity.Entity
import com.example.atisutest.core.data.database.RaceResultDao
import com.example.atisutest.core.data.model.RaceResultEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class RaceHistoryRepositoryImpl @Inject constructor(
    private val dao: RaceResultDao,
    private val ioDispatcher: CoroutineDispatcher,
) : RaceHistoryRepository {

    override suspend fun saveRaceResult(
        result: RaceResultEntity
    ): Entity<Unit> = withContext(ioDispatcher) {
        try {
            dao.insert(
                RaceResultEntity(
                    horseName = result.horseName,
                    date = result.date
                )
            )

            Entity.Success(Unit)
        } catch (exception: Exception) {
            Entity.Error(exception)
        }
    }

    override suspend fun getRaceHistory(): Entity<List<RaceResultEntity>> =
        withContext(ioDispatcher) {
            try {
                val entities = dao.getAll()
                val result = entities.map {
                    RaceResultEntity(
                        id = it.id,
                        horseName = it.horseName,
                        date = it.date
                    )
                }

                Entity.Success(result)
            } catch (exception: Exception) {
                Entity.Error(exception)
            }
        }
}
