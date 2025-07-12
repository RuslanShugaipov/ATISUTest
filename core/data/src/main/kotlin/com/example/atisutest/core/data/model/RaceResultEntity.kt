package com.example.atisutest.core.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "race_results")
data class RaceResultEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val horseName: String,
    val date: String,
)
