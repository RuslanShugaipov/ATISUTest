package com.example.atisutest.core.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.atisutest.core.data.model.RaceResultEntity

@Dao
interface RaceResultDao {
    @Insert
    suspend fun insert(result: RaceResultEntity)

    @Query("SELECT * FROM race_results ORDER BY id")
    suspend fun getAll(): List<RaceResultEntity>
}
