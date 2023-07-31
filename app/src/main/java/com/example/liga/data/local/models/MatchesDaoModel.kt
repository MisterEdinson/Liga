package com.example.liga.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "league_matches_day")
data class MatchesDaoModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var filterPerm:String? = null,
    var resCount:Int? = null,
    var resCompetitions:String? = null,
    var resFirst:String? = null,
    var resLast:String? = null,
    var match:String? = null,
)