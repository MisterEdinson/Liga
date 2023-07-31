package com.example.liga.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.liga.data.local.models.LeagueUpdateInfoModel

@Dao
interface InfoUpdatedDao {
    @Query("SELECT * FROM league_update_info")
    suspend fun getInfoUpdate(): LeagueUpdateInfoModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInfoUpdate(insert: LeagueUpdateInfoModel)
}