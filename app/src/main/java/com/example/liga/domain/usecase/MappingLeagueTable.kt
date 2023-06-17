package com.example.liga.domain.usecase

import com.example.liga.data.local.models.LeaguesTableModel
import com.example.liga.data.network.models.leagueTable.LeagueNetWork
import com.example.liga.data.network.models.leagueTable.TableItem

class MappingLeagueTable {
    fun mapperLeagueTable(response: LeagueNetWork?) : List<LeaguesTableModel>{
        val league : List<TableItem?>? = response?.standings?.get(0)?.table
        val season = response?.season.toString()
        val id = response?.competition?.id
        val code = response?.competition?.code
        val mapper = MappingModelLeagueTable()
        val mapping : List<LeaguesTableModel> =
            league?.mapNotNull { item->
                item.let {
                    mapper.mappingLeagueTable(it,season,id,code)
                }
            } ?: emptyList()
        return mapping
    }
}