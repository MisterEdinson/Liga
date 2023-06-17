package com.example.liga.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "league_info")
data class LagueInfoModel (
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var season:Int? = null,
    var areaId:Int? = null,
    var areaName:String? = null,
    var areaCode:String? = null,
    var areaFlag:String? = null,
    var competitionId:Int? = null,
    var competitionName:String? = null,
    var competitionCode:String? = null,
    var competitionType:String? = null,
    var competitionEmblem:String? = null,
    var seasonId:Int? = null,
    var seasonStart:String? = null,
    var seasonEnd:String? = null,
    var seasonCurrentMatchday:Int? = null,
)