package com.example.liga.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "league_champions_table")
data class LeaguesChampionsTableModel (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var season: Int? = null,
    var competitionId: String? = null,
    var competitionCode: String? = null,
    var standingsGroup:String? = null,
    var tablePosition: Int? = null,
    var tableTeamId: Int? = null,
    var tableTeamName: Int? = null,
    var tableTeamTla: Int? = null,
    var tableTeamCrest: Int? = null,
    var tablePlayedGame: Int? = null,
    var tablePlayedWon: Int? = null,
    var tablePlayedDraw: Int? = null,
    var tablePlayedPoints: Int? = null,
    var tableGoalsFor: Int? = null,
    var tableGoalsAgainst: Int? = null,
    var tableGoalDifference: Int? = null,
)