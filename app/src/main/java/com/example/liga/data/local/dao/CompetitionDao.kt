package com.example.liga.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.liga.data.local.models.CompetitonModel

@Dao
interface CompetitionDao {
    @Query("SELECT * FROM competitions ORDER BY id ASC")
    suspend fun getCompetition(): CompetitonModel
}