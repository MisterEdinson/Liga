package com.example.liga.domain.utils

import com.example.liga.data.network.models.leagueTable.TableItem

interface MapperLeagueChampToLeagueChampTable<TableItem, LeaguesChampionsTableModel> {
    fun mappingLeagueChampionsTable(responce: TableItem?): LeaguesChampionsTableModel
}