package com.example.liga.domain.usecase

import com.example.liga.data.local.models.LeaguesChampionsTableModel
import com.example.liga.data.network.models.cupsLeagueChampionsTable.LeagueChampionsTable
import com.example.liga.data.network.models.cupsLeagueChampionsTable.TableItem


class MappingLeagueChampionsTable {
    fun convertLeagueChampionsTable(response: LeagueChampionsTable?): List<LeaguesChampionsTableModel> {
        val model: List<TableItem?>? = response?.standings?.get(0)?.table
        val mapper = MappingModelLeagueChampionsTable()
        val mapping: List<LeaguesChampionsTableModel> =
            model?.mapNotNull { item ->
                item.let {
                    mapper.mappingLeagueChampionsTable(it)
                }
            } ?: emptyList()

        return mapping
    }
}