package com.example.liga.domain

import com.example.liga.data.local.dao.ChampionshipDDao
import com.example.liga.data.local.dao.CompetitionDao
import com.example.liga.data.local.models.*
import com.example.liga.data.network.SimpleRetro
import com.example.liga.domain.usecase.*
import javax.inject.Inject

class Repository @Inject constructor(
    private val retrofit: SimpleRetro,
    private val daoCompetition: CompetitionDao,
    private val daoChampionship: ChampionshipDDao
) {
    //get competitions
    suspend fun getLeagues(): List<CompetitonModel> {
        val infoUpdate = daoCompetition.getCompetition()
        return infoUpdate.ifEmpty {
            val leagues = retrofit.getCompetitions()
            val correctLeagues = MappingCompetitionHost().convertingCompetition(leagues)
            daoCompetition.insertCompetition(correctLeagues)
            correctLeagues
        }
    }

    //get championship
    suspend fun getLeagueChampionship(code: String): LeagueInfoModel {
        val league = retrofit.getLeagueTable(code)
        val leagueInfo = MappingLeagueInfo().convertedToLeagueInfo(league)
        daoChampionship.insertChampionship(leagueInfo)
        return leagueInfo
    }

    suspend fun getLeagueChampionsInfo(code: String): LeaguesChampionsInfoModel {
        val ligChamp = retrofit.getLeagueChamp(code)
        val ligChampInfo = MappingLeagueChampionsInfo().convertLeagueChampionsInfo(ligChamp)
        return ligChampInfo
    }

    suspend fun getLeagueChampionsTable(code: String): List<LeagueChampGsonModel> {
        val ligChamp = retrofit.getLeagueChamp(code)
        val ligChampTable = MappingLeagueChampionsTable().convertLeagueChampionsTable(ligChamp)
        return ligChampTable
    }

    suspend fun getTeam(team_id: Int): TeamDaoModel {
        val teamNetwork = retrofit.getTeam(team_id)
        val teamCorrect = MappingModelTeamInfo().mapperTeam(teamNetwork)
        return teamCorrect
    }
}