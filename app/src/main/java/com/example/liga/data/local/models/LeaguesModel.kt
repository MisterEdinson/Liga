package com.example.liga.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "leagues")
data class LeaguesModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var idSeason:Int? = null,
)