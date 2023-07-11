package com.example.liga.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.liga.data.local.models.MatchesModel

@Dao
interface MatchesDao {
    @Query("SELECT * FROM matches_table")
    suspend fun getMatchesDay(): MatchesModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatches(insert: List<MatchesModel>)
}