package com.example.liga.domain.utils

interface MapperLeagueChampToLeagueChampInfo<LeagueChampionsTable, LeaguesChampionsInfoModel> {
    fun mapperLeagueChampionsInfo(response: LeagueChampionsTable?): LeaguesChampionsInfoModel
}