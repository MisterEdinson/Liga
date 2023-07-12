package com.example.liga.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.liga.data.local.models.UpdateDateModel

@Dao
interface UpdateDao {
    @Query("SELECT * FROM update_date_table")
    suspend fun getUpdateTable(): UpdateDateModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpdateTable(insert: UpdateDateModel)
}