package com.example.liga.domain.usecase

import com.example.liga.data.local.models.TeamDaoModel
import com.example.liga.data.network.models.teams.TeamModel

class MappingTeamInfo {
    fun mapperTeam(response : TeamModel?) : TeamDaoModel{
        val team = response
        val mapper = MappingModelTeamInfo()
        val mapping : TeamDaoModel =
            mapper.mapperTeam(team)
        return mapping
    }
}