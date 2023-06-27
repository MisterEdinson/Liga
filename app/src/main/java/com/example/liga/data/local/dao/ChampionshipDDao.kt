package com.example.liga.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.liga.data.local.models.LeagueInfoModel

@Dao
interface ChampionshipDDao {
    @Query("SELECT * FROM championship_info WHERE competitionCode LIKE :code")
    suspend fun getChampionship(code: String): LeagueInfoModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChampionship(insert: LeagueInfoModel)
}