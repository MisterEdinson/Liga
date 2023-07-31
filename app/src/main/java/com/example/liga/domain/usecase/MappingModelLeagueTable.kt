package com.example.liga.domain.usecase

import com.example.liga.data.local.models.LeaguesTableModel
import com.example.liga.data.network.models.leagueTable.TableItem
import com.example.liga.domain.utils.MapperLeagueNetWorkToLeagueTable

class MappingModelLeagueTable:MapperLeagueNetWorkToLeagueTable<TableItem,LeaguesTableModel> {
    override fun mappingLeagueTable(
        response: TableItem?,
        season:String?,
        id:Int?,
        code:String?
    ): LeaguesTableModel {
        //val team = response?.standings?.get(0)?.table?.get(0)
        return LeaguesTableModel(
            id = 0,
            season = season,
            competitionId = id,
            competitionCode = code,
            position = response?.position,
            teamId = response?.team?.id,
            teamName = response?.team?.name,
            teamShortName = response?.team?.shortName,
            teamTla = response?.team?.tla,
            teamCrest = response?.team?.crest,
            teamPlayedGames = response?.playedGames,
            teamForm = response?.form,
            teamWon = response?.won,
            teamDraw = response?.draw,
            teamLost = response?.lost,
            teamPoints = response?.points,
            teamGoalsFor = response?.goalsFor,
            teamGoalsAgainst = response?.goalsAgainst,
            teamGoalDifference = response?.goalDifference,
        )
    }
}