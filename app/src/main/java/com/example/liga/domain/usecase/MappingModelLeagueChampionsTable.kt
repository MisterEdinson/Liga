package com.example.liga.domain.usecase

import com.example.liga.data.local.models.LeaguesChampionsTableModel
import com.example.liga.data.network.models.cupsLeagueChampionsTable.TableItem
import com.example.liga.domain.utils.MapperLeagueChampToLeagueChampTable

class MappingModelLeagueChampionsTable :
    MapperLeagueChampToLeagueChampTable<TableItem, LeaguesChampionsTableModel> {
    override fun mappingLeagueChampionsTable(responce: TableItem?): LeaguesChampionsTableModel {
        return LeaguesChampionsTableModel(
            id = 0,
            season = 0,
            competitionId = 0,
            competitionCode = "",
            standingsGroup = "",
            tablePosition = responce?.position,
            tableTeamId = responce?.team?.id,
            tableTeamName = responce?.team?.name,
            tableTeamTla = responce?.team?.tla,
            tableTeamCrest = responce?.team?.crest,
            tablePlayedGame = responce?.playedGames,
            tablePlayedWon = responce?.won,
            tablePlayedDraw = responce?.draw,
            tablePlayedPoints = responce?.points,
            tableGoalsFor = responce?.goalsFor,
            tableGoalsAgainst = responce?.goalsAgainst,
            tableGoalDifference = responce?.goalDifference,
        )
    }
}