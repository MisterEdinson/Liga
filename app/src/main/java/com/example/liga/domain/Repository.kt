package com.example.liga.domain

import com.example.liga.data.local.dao.ChampionshipDao
import com.example.liga.data.local.dao.CompetitionDao
import com.example.liga.data.local.dao.TeamDao
import com.example.liga.data.local.models.*
import com.example.liga.data.network.SimpleRetro
import com.example.liga.domain.usecase.*
import javax.inject.Inject

class Repository @Inject constructor(
    private val retrofit: SimpleRetro,
    private val daoCompetition: CompetitionDao,
    private val daoChampionship: ChampionshipDao,
    private val daoTeam: TeamDao
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
        val localChampionship = daoChampionship.getChampionship(code)
        return if (localChampionship != null) {
            localChampionship
        } else {
            val league = retrofit.getLeagueTable(code)
            val leagueInfo = MappingLeagueInfo().convertedToLeagueInfo(league)
            daoChampionship.insertChampionship(leagueInfo)
            leagueInfo
        }
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

    //get team
    suspend fun getTeam(team_id: Int): TeamDaoModel {
        val teamNetwork = retrofit.getTeam(team_id)
        val teamCorrect = MappingModelTeamInfo().mapperTeam(teamNetwork)
        daoTeam.insertTeamDB(teamCorrect)
        return teamCorrect
    }
}