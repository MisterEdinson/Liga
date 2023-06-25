package com.example.liga.domain

import com.example.liga.data.local.dao.CompetitionDao
import com.example.liga.data.local.models.*
import com.example.liga.data.network.SimpleRetro
import com.example.liga.domain.usecase.*
import javax.inject.Inject

class Repository @Inject constructor(
    private val retrofit: SimpleRetro, private val dao: CompetitionDao
) {
    suspend fun getLeagues(): List<CompetitonModel> {
        val leagues = retrofit.getCompetitions()
        val correctLeagues = MappingCompetitionHost().convertingCompetition(leagues)
        dao.insertCompetition(correctLeagues)
        return dao.getCompetition()
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

    suspend fun getLeagueChampionsInfo(code:String): LeaguesChampionsInfoModel{
        val ligChamp = retrofit.getLeagueChamp(code)
        val ligChampInfo = MappingLeagueChampionsInfo().convertLeagueChampionsInfo(ligChamp)
        return ligChampInfo
    }

    suspend fun getLeagueChampionsTable(code:String): List<LeagueChampGsonModel>{
        val ligChamp = retrofit.getLeagueChamp(code)
        val ligChampTable = MappingLeagueChampionsTable().convertLeagueChampionsTable(ligChamp)
        return ligChampTable
    }

    suspend fun getTeam(team_id: Int) : TeamDaoModel{
        val teamNetwork = retrofit.getTeam(team_id)
        val teamCorrect = MappingModelTeamInfo().mapperTeam(teamNetwork)
        return teamCorrect
    }
}