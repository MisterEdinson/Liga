package com.example.liga.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teams_table")
data class TeamDaoModel (
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var areaId:Int? = null,
    var areaName:String? = null,
    var areaCode:String? = null,
    var areaFlag:String? = null,
    var teamId:Int? = null,
    var teamName:String? = null,
    var teamShort:String? = null,
    var teamTla:String? = null,
    var teamCrest:String? = null,
    var teamAdress:String? = null,
    var teamWebsite:String? = null,
    var teamFounded:String? = null,
    var teamColors:String? = null,
    var teamVenue:String? = null,
    var teamCompetition:String? = null,
    var teamCoach:String? = null,
    var teamSquad:String? = null
)