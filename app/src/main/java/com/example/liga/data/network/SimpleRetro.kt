package com.example.liga.data.network

import com.example.liga.data.network.models.competitions.Competitons
import com.example.liga.data.network.models.cupsLeagueChampionsTable.LeagueChampionsTable
import com.example.liga.data.network.models.leagueTable.LeagueNetWork
import com.example.liga.data.network.models.matches.MatchesRetro
import com.example.liga.data.network.models.teams.TeamModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleRetro {
    // get all competitions
    @GET("competitions")
    suspend fun getCompetitions(): Competitons

    //get match day
    @GET("matches")
    suspend fun getMatchDay(): MatchesRetro

    //get match immediate
    @GET("matches")
    suspend fun getMatchImmediate(
        @Query("dateFrom") dataFrom: String,
        @Query("dateTo") dataTo: String
    ): MatchesRetro

    //get item league table
    @GET("competitions/{league_code}/standings")
    suspend fun getLeagueTable(@Path("league_code") code: String): LeagueNetWork

    //get cups
    @GET("competitions/{league_champ}/standings")
    suspend fun getLeagueChamp(@Path("league_champ") code: String): LeagueChampionsTable

    // get teams
    @GET("teams/{team_id}")
    suspend fun getTeam(@Path("team_id") id: Int): TeamModel
}