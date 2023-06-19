package com.example.liga.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "league_champions_info")
data class LeaguesChampionsInfoModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var season: String? = null,
    var areaId: Int? = null,
    var areaName: String? = null,
    var areaCode: String? = null,
    var areaFlag: String? = null,
    var competitionId: Int? = null,
    var competitionName: String? = null,
    var competitionCode: String? = null,
    var competitionType: String? = null,
    var competitionEmblem: String? = null,
    var seasonId: Int? = null,
    var seasonStart: String? = null,
    var seasonEnd: String? = null,
    var seasonMatchDay: String? = null,
    var winnerId: Int? = null,
    var winnerName: String? = null,
    var winnerShort: String? = null,
    var winnerTla: String? = null,
    var winnerCrest: String? = null,
    var winnerAddress: String? = null,
    var winnerWebsite: String? = null,
)