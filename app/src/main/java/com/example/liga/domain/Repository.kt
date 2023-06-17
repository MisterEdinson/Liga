package com.example.liga.domain

import com.example.liga.data.local.models.CompetitonModel
import com.example.liga.data.network.SimpleRetro
import com.example.liga.domain.usecase.MappingCompetitionHost
import javax.inject.Inject

class Repository @Inject constructor(
    private val retrofit: SimpleRetro
) {
    suspend fun getLeagues(): List<CompetitonModel> {
        val leagues = retrofit.getCompetitions()
        val correctLeagues = MappingCompetitionHost().convertingCompetition(leagues)
        return correctLeagues
    }
    suspend fun getTableLeague(){

    }
}