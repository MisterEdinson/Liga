package com.example.liga.domain.utils

interface MapperCompetitionToCompetitionModel<CompetitionsItem, CompetitionModel> {
    fun mappingCompetitionHostToDao(responce: CompetitionsItem?): CompetitionModel
}