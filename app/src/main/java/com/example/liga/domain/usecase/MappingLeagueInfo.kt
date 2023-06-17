package com.example.liga.domain.usecase

import com.example.liga.data.local.models.LeagueInfoModel
import com.example.liga.data.network.models.leagueTable.LeagueNetWork

class MappingLeagueInfo {
    fun convertedToLeagueInfo(response: LeagueNetWork?) : LeagueInfoModel{
        val league: LeagueNetWork? = response
        val mapper = MappingModelLeagueInfo()
        val mapping : LeagueInfoModel =
            mapper.mappingLeagueToLeagueInfoDao(league)
        return mapping
    }
}