package com.example.atisutest.core.data.di

import com.example.atisutest.core.data.repository.RaceHistoryRepository
import com.example.atisutest.core.data.repository.RaceHistoryRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
internal object DataModule {

    @Provides
    internal fun provideRaceHistoryRepository(): RaceHistoryRepository {
        return RaceHistoryRepositoryImpl(
            ioDispatcher = Dispatchers.IO,
        )
    }
}
