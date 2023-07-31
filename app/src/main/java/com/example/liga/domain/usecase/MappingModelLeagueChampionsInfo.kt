package com.example.liga.domain.usecase

import com.example.liga.data.local.models.LeaguesChampionsInfoModel
import com.example.liga.data.network.models.cupsLeagueChampionsTable.LeagueChampionsTable
import com.example.liga.domain.utils.MapperLeagueChampToLeagueChampInfo

class MappingModelLeagueChampionsInfo :
    MapperLeagueChampToLeagueChampInfo<LeagueChampionsTable, LeaguesChampionsInfoModel> {
    override fun mapperLeagueChampionsInfo(response: LeagueChampionsTable?): LeaguesChampionsInfoModel {
        return LeaguesChampionsInfoModel(
            id = 0,
            season = response?.filters?.season,
            areaId = response?.area?.id,
            areaName = response?.area?.name,
            areaCode = response?.area?.code,
            areaFlag = response?.area?.flag,
            competitionId = response?.competition?.id,
            competitionName = response?.competition?.name,
            competitionCode = response?.competition?.code,
            competitionType = response?.competition?.type,
            competitionEmblem = response?.competition?.emblem,
            seasonId = response?.season?.id,
            seasonStart = response?.season?.startDate,
            seasonEnd = response?.season?.endDate,
            seasonMatchDay = response?.season?.currentMatchday,
            winnerId = response?.season?.winner?.id,
            winnerName = response?.season?.winner?.name,
            winnerShort = response?.season?.winner?.shortName,
            winnerTla = response?.season?.winner?.tla,
            winnerCrest = response?.season?.winner?.crest,
            winnerAddress = response?.season?.winner?.address,
            winnerWebsite = response?.season?.winner?.website,
        )
    }
}