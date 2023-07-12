package com.example.liga.data.local.models

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "matches_table" , indices = [Index(value = ["idMatch"], unique = true)])
data class MatchesModel (
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var idMatch:Int? = null,
    var utcDateMatch:String? = null,
    var statusMatch:String? = null,
    var matchdayMatch:Int? = null,
    var stageMatch:String? = null,
    var groupMatch:String? = null,
    var lastUpdatedMatch:String? = null,
    var idArea:Int? = null,
    var nameArea:String? = null,
    var codeArea:String? = null,
    var flagArea:String? = null,
    var idCompetition:Int? = null,
    var nameCompetition:String? = null,
    var codeCompetition:String? = null,
    var typeCompetition:String? = null,
    var emblemCompetition:String? = null,
    var idSeason:Int? = null,
    var startDateSeason:String? = null,
    var endDateSeason:String? = null,
    var currentMatchdaySeason:Int? = null,
    var winnerSeason:String? = null,
    var idHomeTeam:Int? = null,
    var nameHomeTeam:String? = null,
    var shortHomeTeam:String? = null,
    var tlaHomeTeam:String? = null,
    var crestHomeTeam:String? = null,
    var idAwayTeam:Int? = null,
    var nameAwayTeam:String? = null,
    var shortAwayTeam:String? = null,
    var tlaAwayTeam:String? = null,
    var crestAwayTeam:String? = null,
    var winScore:String? = null,
    var durationScore:String? = null,
    var fullTimeHomeScore:Int? = null,
    var fullTimeAwayScore:Int? = null,
    var halfTimeHomeScore:Int? = null,
    var halfTimeAwayScore:Int? = null,
    var dateMatch:String? = null,
    var timeMatch:String? = null,
    var dateUpdate:String? = null,
    )