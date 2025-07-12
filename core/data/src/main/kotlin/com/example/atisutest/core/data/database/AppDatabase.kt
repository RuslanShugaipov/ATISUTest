package com.example.atisutest.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.atisutest.core.data.model.RaceResultEntity

@Database(
    entities = [RaceResultEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun raceResultDao(): RaceResultDao
}
