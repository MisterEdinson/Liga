package com.example.liga.domain.usecase

import com.example.liga.data.local.models.CompetitonModel
import com.example.liga.data.network.models.competitions.CompetitionsItem
import com.example.liga.domain.utils.MapperCompetitionToCompetitionModel
import java.text.SimpleDateFormat
import java.util.*

class MappingModelCompetitions :
    MapperCompetitionToCompetitionModel<CompetitionsItem, CompetitonModel> {
    override fun mappingCompetitionHostToDao(responce: CompetitionsItem?): CompetitonModel {
        val time = Date()
        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val date = dateFormat.format(time)
        return CompetitonModel(
            id = 0,
            idCompetition = responce?.id,
            idArea = responce?.area?.id,
            nameArea = responce?.area?.name,
            codeArea = responce?.area?.code,
            flagArea = responce?.area?.flag,
            nameCompetition = responce?.name,
            codeCompetition = responce?.code,
            emblemCompetition = responce?.emblem,
            typeCompetition = responce?.type,
            planCompetition = responce?.plan,
            idSeason = responce?.currentSeason?.id,
            startData = responce?.currentSeason?.startDate,
            endData = responce?.currentSeason?.endDate,
            winner = "",
            numberOfAvailableSeasons = "",
            lastUpdated = "",
            dateAdd = date.toString()
        )
    }
}