package com.example.liga.data.network

import com.example.liga.data.network.models.competitions.Competitons
import com.example.liga.data.network.models.leagueTable.LeagueNetWork
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleRetro {
    // get all competitions
    @GET("competitions")
    suspend fun getCompetitions(): Competitons
    //get item league table
    @GET("competitions/{league_code}/standings")
    suspend fun getLeagueTable(
        @Path("league_code") code: String
    ): LeagueNetWork
}