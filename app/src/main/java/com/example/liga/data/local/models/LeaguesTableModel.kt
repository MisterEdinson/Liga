package com.example.liga.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "leagues_table")
data class LeaguesTableModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var season: Int? = null,
    var competitionId: Int? = null,
    var competitionCode: String? = null,
    var position: Int? = null,
    var teamId: Int? = null,
    var teamName: Int? = null,
    var teamShortName: Int? = null,
    var teamTla: Int? = null,
    var teamCrest: Int? = null,
    var teamPlayedGames: Int? = null,
    var teamForm: Int? = null,
    var teamWon: Int? = null,
    var teamDraw: Int? = null,
    var teamLost: Int? = null,
    var teamPoints: Int? = null,
    var teamGoalsFor: Int? = null,
    var teamGoalsAgainst: Int? = null,
    var teamGoalDifference: Int? = null,
)