package com.example.liga.domain.usecase

import com.example.liga.data.local.models.MatchesModel
import com.example.liga.data.network.models.matches.MatchesItem
import com.example.liga.data.network.models.matches.MatchesRetro

class MappingAllMatch {
    fun convertedMatch(response: MatchesRetro): List<MatchesModel> {
        val leagues: List<MatchesItem?>? = response.matches
        val mapper = MappingAllMatchModel()
        val mapping: List<MatchesModel> =
            leagues?.mapNotNull { item ->
                item.let {
                    mapper.mappingMatchFromRoom(it)
                }
            } ?: emptyList()
        return mapping
    }
}