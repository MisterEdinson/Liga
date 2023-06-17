package com.example.liga.domain

import com.example.liga.data.local.models.CompetitonModel
import com.example.liga.data.local.models.LeagueInfoModel
import com.example.liga.data.local.models.LeaguesTableModel
import com.example.liga.data.network.SimpleRetro
import com.example.liga.domain.usecase.MappingCompetitionHost
import com.example.liga.domain.usecase.MappingLeagueInfo
import com.example.liga.domain.usecase.MappingLeagueTable
import com.example.liga.domain.usecase.MappingModelLeagueTable
import javax.inject.Inject

class Repository @Inject constructor(
    private val retrofit: SimpleRetro
) {
    suspend fun getLeagues(): List<CompetitonModel> {
        val leagues = retrofit.getCompetitions()
        val correctLeagues = MappingCompetitionHost().convertingCompetition(leagues)
        return correctLeagues
    }

    suspend fun getLeagueInfo(code:String): LeagueInfoModel {
        val league = retrofit.getLeagueTable(code)
        val leagueInfo = MappingLeagueInfo().convertedToLeagueInfo(league)
        return leagueInfo
    }

    suspend fun getLeagueTable(code:String): List<LeaguesTableModel>{
        val league = retrofit.getLeagueTable(code)
        val leagueTable = MappingLeagueTable().mapperLeagueTable(league)
        return leagueTable
    }
}