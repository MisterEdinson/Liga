package com.example.liga.domain

import com.example.liga.data.local.dao.*
import com.example.liga.data.local.models.*
import com.example.liga.data.network.SimpleRetro
import com.example.liga.domain.usecase.*
import com.example.liga.domain.utils.Constants.Companion.DIVISION_HOUR
import com.example.liga.domain.utils.Constants.Companion.DIVISION_MOUNT
import com.example.liga.domain.utils.Constants.Companion.DIVISION_SEC
import com.example.liga.domain.utils.Constants.Companion.IMMEDIATE_DAY
import com.example.liga.domain.utils.Constants.Companion.UPDATE_MATCH_DAY_SEC
import com.example.liga.domain.utils.Constants.Companion.UPDATE_TIME_HOUR
import com.example.liga.domain.utils.Constants.Companion.UPDATE_TIME_MOUNT
import com.example.liga.domain.utils.TimeConverter
import java.util.*
import javax.inject.Inject

class Repository @Inject constructor(
    private val retrofit: SimpleRetro,
    private val daoCompetition: CompetitionDao,
    private val daoChampionship: ChampionshipDao?,
    private val daoTeam: TeamDao,
    private val daoMatches: MatchesDao,
    private val daoUpdate: UpdateDao?
) {
    //get competitions
    suspend fun getLeagues(): List<CompetitonModel> {
        val update = daoUpdate?.getUpdateTable()
        val mount = Date().time / DIVISION_MOUNT
        return if (update?.updateComp != null && update.updateComp - mount < UPDATE_TIME_MOUNT) {
            daoCompetition.getCompetition()
        } else {
            val leagues = retrofit.getCompetitions()
            val correctLeagues = MappingCompetitionHost().convertingCompetition(leagues)
            daoCompetition.insertCompetition(correctLeagues)
            val table = UpdateDateModel(
                id = 0,
                updateComp = mount,
                updateMatchesDay = update?.updateMatchesDay,
                updateMatchIm = update?.updateMatchIm
            )
            daoUpdate?.insertUpdateTable(table)
            correctLeagues
        }
    }

    //get championship
    suspend fun getLeagueChampionship(code: String): LeagueInfoModel {
        val localChampionship = daoChampionship?.getChampionship(code)
        return if (localChampionship != null) {
            localChampionship
        } else {
            val league = retrofit.getLeagueTable(code)
            val leagueInfo = MappingLeagueInfo().convertedToLeagueInfo(league)
            daoChampionship?.insertChampionship(leagueInfo)
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

    //get matchday
    suspend fun getMatchDay(): List<MatchesModel> {
        val update = daoUpdate?.getUpdateTable()
        val sec = Date().time / DIVISION_SEC
        //logic update
        return if (update?.updateMatchesDay != null && (sec - update.updateMatchesDay < UPDATE_MATCH_DAY_SEC)) {
            daoMatches.getMatchesDay(TimeConverter().getYYYYMMDDfromDate())
        } else {
            val matchDayNet = retrofit.getMatchDay()
            val map = MappingAllMatch().convertedMatch(matchDayNet)
            daoMatches.insertMatches(map)
            val table = UpdateDateModel(
                id = 0,
                updateComp = update?.updateComp,
                updateMatchesDay = sec,
                updateMatchIm = update?.updateMatchIm
            )
            daoUpdate?.insertUpdateTable(table)
            daoMatches.getMatchesDay(TimeConverter().getYYYYMMDDfromDate())
        }
    }

    //get immediate matches
    suspend fun getMatchImmediate(): List<MatchesModel> {
        val update = daoUpdate?.getUpdateTable()
        val hour = Date().time / DIVISION_HOUR
        return if (update?.updateMatchIm != null && update.updateMatchIm - hour < UPDATE_TIME_HOUR) {
            daoMatches.getMatchesImmediate(TimeConverter().getYYYYMMDDfromDate())
        } else {
            val matchImmediateNet = retrofit.getMatchImmediate(
                TimeConverter().getYYYYMMDDfromDate(),
                TimeConverter().getDayImmediate(IMMEDIATE_DAY)
            )
            val map = MappingAllMatch().convertedMatch(matchImmediateNet)
            daoMatches.insertMatches(map)
            val table = UpdateDateModel(
                id = 0,
                updateComp = update?.updateComp,
                updateMatchesDay = update?.updateMatchesDay,
                updateMatchIm = hour
            )
            daoUpdate?.insertUpdateTable(table)
            daoMatches.getMatchesImmediate(TimeConverter().getYYYYMMDDfromDate())
        }
    }
}