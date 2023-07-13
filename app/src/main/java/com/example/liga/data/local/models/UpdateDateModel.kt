package com.example.liga.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "update_date_table")
data class UpdateDateModel(
    @PrimaryKey(autoGenerate = false)
    val id:Int? = 0,
    val updateComp:Long? = null,
    val updateMatchesDay:Long? = null,
    val updateMatchIm:Long? = null
)