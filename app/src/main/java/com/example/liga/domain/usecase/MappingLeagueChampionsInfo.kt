package com.example.liga.domain.usecase

import com.example.liga.data.local.models.LeaguesChampionsInfoModel
import com.example.liga.data.network.models.cupsLeagueChampionsTable.LeagueChampionsTable

class MappingLeagueChampionsInfo {
    fun convertLeagueChampionsInfo(response: LeagueChampionsTable): LeaguesChampionsInfoModel {
        val model: LeagueChampionsTable = response
        val mapper = MappingModelLeagueChampionsInfo()
        val mapping: LeaguesChampionsInfoModel =
            mapper.mapperLeagueChampionsInfo(model)
        return mapping
    }
}