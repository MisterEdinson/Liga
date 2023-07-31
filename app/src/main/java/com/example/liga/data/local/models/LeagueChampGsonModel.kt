package com.example.liga.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "league_champions_gson")
data class LeagueChampGsonModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var season:String? = null,
    var competitionId:Int? = null,
    var competitionCode:String? = null,
    var standingType:String? = null,
    var standingsGroup:String? = null,
    var table:String? = null,
)