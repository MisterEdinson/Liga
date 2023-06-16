package com.example.liga.domain.usecase

import com.example.liga.data.local.models.CompetitonModel
import com.example.liga.data.network.models.competitions.CompetitionsItem
import com.example.liga.data.network.models.competitions.Competitons

class MappingCompetitionHost {
    fun convertingCompetition(responce : Competitons) : List<CompetitonModel>{
        val leagues : List<CompetitionsItem?>? = responce.competitions
        val mapper = MappingModelCompetitions()
        val mapping: List<CompetitonModel> =
            leagues?.mapNotNull { item->
                item.let {
                    mapper.mappingCompetitionHostToDao(it)
                }
            } ?: emptyList()
        return mapping
    }
}