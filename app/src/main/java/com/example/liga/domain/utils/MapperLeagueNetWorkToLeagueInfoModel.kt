package com.example.liga.domain.utils

interface MapperLeagueNetWorkToLeagueInfoModel<LeagueNetWork,LeagueInfoModel> {
    fun mappingLeagueToLeagueInfoDao(responce: LeagueNetWork?): LeagueInfoModel
}