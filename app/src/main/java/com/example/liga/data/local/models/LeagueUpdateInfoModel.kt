package com.example.liga.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "league_update_info")
data class LeagueUpdateInfoModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var updateComp: String? = null,
    var updateTodayMatch:String? = null,
    var updateImmediateMatch:String? = null,
)