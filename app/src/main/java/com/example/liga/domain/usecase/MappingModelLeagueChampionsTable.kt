package com.example.liga.domain.usecase

import com.example.liga.data.local.models.LeagueChampGsonModel
import com.example.liga.data.local.models.LeaguesChampionsTableModel
import com.example.liga.data.network.models.cupsLeagueChampionsTable.StandingsItem
import com.example.liga.data.network.models.cupsLeagueChampionsTable.TableItem
import com.example.liga.domain.utils.MapperLeagueChampToLeagueChampTable
import com.google.gson.Gson

class MappingModelLeagueChampionsTable :
    MapperLeagueChampToLeagueChampTable<StandingsItem, LeagueChampGsonModel> {
    override fun mappingLeagueChampionsTable(
        responce: StandingsItem?,
        season:String?,
        compId:Int?,
        compCode:String?
    ): LeagueChampGsonModel {
        val gson = Gson()
        val tableGson = gson.toJson(responce?.table)
        //val tableGson = responce?.table.toString()
        return LeagueChampGsonModel(
            id = 0,
            season = season,
            competitionId = compId,
            competitionCode = compCode,
            standingsGroup = responce?.group,
            table = tableGson
//            tablePosition = responce?.position,
//            tableTeamId = responce?.team?.id,
//            tableTeamName = responce?.team?.name,
//            tableTeamTla = responce?.team?.tla,
//            tableTeamCrest = responce?.team?.crest,
//            tablePlayedGame = responce?.playedGames,
//            tablePlayedWon = responce?.won,
//            tablePlayedDraw = responce?.draw,
//            tablePlayedPoints = responce?.points,
//            tableGoalsFor = responce?.goalsFor,
//            tableGoalsAgainst = responce?.goalsAgainst,
//            tableGoalDifference = responce?.goalDifference,
        )
    }
}