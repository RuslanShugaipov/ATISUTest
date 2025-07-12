package com.example.atisutest.core.data.di

import android.content.Context
import androidx.room.Room
import com.example.atisutest.core.data.database.AppDatabase
import com.example.atisutest.core.data.database.RaceResultDao
import com.example.atisutest.core.data.repository.RaceHistoryRepository
import com.example.atisutest.core.data.repository.RaceHistoryRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

private const val DATABASE_NAME = "race_database"

@Module
@InstallIn(SingletonComponent::class)
internal object DataModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext appContext: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideRaceResultDao(database: AppDatabase): RaceResultDao {
        return database.raceResultDao()
    }

    @Provides
    internal fun provideRaceHistoryRepository(
        dao: RaceResultDao,
    ): RaceHistoryRepository {
        return RaceHistoryRepositoryImpl(
            dao = dao,
            ioDispatcher = Dispatchers.IO,
        )
    }
}
