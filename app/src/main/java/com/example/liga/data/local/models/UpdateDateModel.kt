package com.example.liga.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "update_date_table")
data class UpdateDateModel(
    @PrimaryKey(autoGenerate = false)
    val id:Int? = 0,
    val updateComp:String? = null,
    val updateMatchesDay:String? = null,
    val updateMatchIm:String? = null
)