package com.example.liga.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.liga.data.local.models.TeamDaoModel

@Dao
interface TeamDao {
    @Query("SELECT * FROM teams_table WHERE teamId LIKE :id_team")
    suspend fun getTeamDB(id_team: Int): TeamDaoModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeamDB(insert: TeamDaoModel)
}