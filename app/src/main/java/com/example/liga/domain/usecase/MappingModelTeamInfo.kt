package com.example.liga.domain.usecase

import com.example.liga.data.local.models.TeamDaoModel
import com.example.liga.data.network.models.teams.TeamModel
import com.example.liga.domain.utils.MapperLeagueTeamNetworkToTeamDao
import com.google.gson.Gson

class MappingModelTeamInfo:MapperLeagueTeamNetworkToTeamDao<TeamModel,TeamDaoModel> {
    override fun mapperTeam(response: TeamModel?): TeamDaoModel {
        val comp = Gson()
        val competition = comp.toJson(response?.runningCompetitions)
        val ch = Gson()
        val couch = ch.toJson(response?.coach)
        val squad = Gson()
        val team = squad.toJson(response?.squad)
        return TeamDaoModel(
            id = 0,
            areaId = response?.area?.id,
            areaName = response?.area?.name,
            areaCode = response?.area?.code,
            areaFlag = response?.area?.flag,
            teamId = response?.id,
            teamName = response?.name,
            teamShort = response?.shortName,
            teamTla = response?.tla,
            teamCrest = response?.crest,
            teamAdress = response?.address,
            teamWebsite = response?.website,
            teamFounded = response?.founded.toString(),
            teamColors = response?.clubColors,
            teamVenue = response?.venue,
            teamCompetition = competition,
            teamCoach = couch,
            teamSquad = team
        )
    }
}