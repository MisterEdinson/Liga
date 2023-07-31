package com.example.liga.domain.utils

import com.example.liga.data.network.models.leagueTable.LeagueNetWork

interface MapperLeagueNetWorkToLeagueTable<LeagueNetWork, LeaguesTableModel> {
    fun mappingLeagueTable(response: LeagueNetWork?,
                           season:String?,
                           id:Int?,
                           code:String?
    ): LeaguesTableModel
}