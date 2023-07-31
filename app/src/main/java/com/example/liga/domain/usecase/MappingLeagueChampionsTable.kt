package com.example.liga.domain.usecase

import com.example.liga.data.local.models.LeagueChampGsonModel
import com.example.liga.data.local.models.LeaguesChampionsTableModel
import com.example.liga.data.network.models.cupsLeagueChampionsTable.LeagueChampionsTable
import com.example.liga.data.network.models.cupsLeagueChampionsTable.StandingsItem
import com.example.liga.data.network.models.cupsLeagueChampionsTable.TableItem


class MappingLeagueChampionsTable {
    fun convertLeagueChampionsTable(response: LeagueChampionsTable?): List<LeagueChampGsonModel> {
        val model: List<StandingsItem?>? = response?.standings
        val mapper = MappingModelLeagueChampionsTable()

        val season = response?.filters?.season
        val compId = response?.competition?.id
        val compCode = response?.competition?.code

        val mapping: List<LeagueChampGsonModel> =
            model?.mapNotNull { item ->
                item.let {
                    mapper.mappingLeagueChampionsTable(it,season, compId, compCode)
                }
            } ?: emptyList()

        return mapping
    }
}