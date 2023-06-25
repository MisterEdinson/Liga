package com.example.liga.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.liga.data.local.models.CompetitonModel

@Dao
interface CompetitionDao {
    @Query("SELECT * FROM competitions ORDER BY id ASC")
    suspend fun getCompetition(): List<CompetitonModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompetition(insert : List<CompetitonModel>)
}