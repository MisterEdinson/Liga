package com.example.liga.domain.utils

interface MapperLeagueTeamNetworkToTeamDao<TeamModel,TeamDaoModel> {
    fun mapperTeam(response: TeamModel?):TeamDaoModel
}