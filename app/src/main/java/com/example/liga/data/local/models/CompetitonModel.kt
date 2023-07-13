package com.example.liga.data.local.models

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "competitions" , indices = [Index(value = ["idCompetition"], unique = true)])
data class CompetitonModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var idCompetition: Int? = null,
    var idArea: Int? = null,
    var nameArea: String? = null,
    var codeArea: String? = null,
    var flagArea: String? = null,
    var nameCompetition: String? = null,
    var codeCompetition: String? = null,
    var emblemCompetition: String? = null,
    var typeCompetition: String? = null,
    var planCompetition: String? = null,
    var idSeason: Int? = null,
    var startData: String? = null,
    var endData: String? = null,
    var winner: String? = null,
    var numberOfAvailableSeasons: String? = null,
    var lastUpdated: String? = null,
    var dateAdd:String? = null
) : Serializable