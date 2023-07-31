package com.example.liga.domain.usecase

import com.example.liga.data.local.models.LeagueInfoModel
import com.example.liga.data.network.models.leagueTable.LeagueNetWork
import com.example.liga.domain.utils.MapperLeagueNetWorkToLeagueInfoModel
import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.util.*

class MappingModelLeagueInfo :
    MapperLeagueNetWorkToLeagueInfoModel<LeagueNetWork, LeagueInfoModel> {

    override fun mappingLeagueToLeagueInfoDao(responce: LeagueNetWork?): LeagueInfoModel {
        val tableLeague = responce?.standings?.get(0)?.table
        val tableInf = Gson()
        val tableSave = tableInf.toJson(tableLeague)
        val time = Date()
        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val date = dateFormat.format(time)
        return LeagueInfoModel(
            id = 0,
            season = responce?.filters?.season,
            areaId = responce?.area?.id,
            areaName = responce?.area?.name,
            areaCode = responce?.area?.code,
            areaFlag = responce?.area?.flag,
            competitionId = responce?.competition?.id,
            competitionName = responce?.competition?.name,
            competitionCode = responce?.competition?.code,
            competitionType = responce?.competition?.type,
            competitionEmblem = responce?.competition?.emblem,
            seasonId = responce?.season?.id,
            seasonStart = responce?.season?.startDate,
            seasonEnd = responce?.season?.endDate,
            seasonCurrentMatchday = responce?.season?.currentMatchday,
            table = tableSave,
            update = date
        )
    }

}