package com.example.liga.domain.utils

import com.example.liga.data.network.models.cupsLeagueChampionsTable.StandingsItem
import com.example.liga.data.network.models.leagueTable.TableItem

interface MapperLeagueChampToLeagueChampTable<StandingsItem, LeagueChampGsonModel> {
    fun mappingLeagueChampionsTable(
        responce: StandingsItem?,
        season:String?,
        compId:Int?,
        compCode:String?
    ): LeagueChampGsonModel
}