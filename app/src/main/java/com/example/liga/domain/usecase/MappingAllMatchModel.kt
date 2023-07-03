package com.example.liga.domain.usecase

import com.example.liga.data.local.models.MatchesAllSave
import com.example.liga.data.network.models.matches.MatchesItem

class MappingAllMatchModel {
    fun mappingMatchFromRoom(model: MatchesItem?): MatchesAllSave {
        return MatchesAllSave(
            id = 0,
            idMatch = model?.id,
            utcDateMatch = model?.utcDate,
            statusMatch = model?.status,
            matchdayMatch = model?.matchday,
            stageMatch = model?.stage,
            groupMatch = model?.group,
            lastUpdatedMatch = model?.lastUpdated,
            idArea = model?.area?.id,
            nameArea = model?.area?.name,
            codeArea = model?.area?.code,
            flagArea = model?.area?.flag,
            idCompetition = model?.competition?.id,
            nameCompetition = model?.competition?.name,
            codeCompetition = model?.competition?.code,
            typeCompetition = model?.competition?.type,
            emblemCompetition = model?.competition?.emblem,
            idSeason = model?.season?.id,
            startDateSeason = model?.season?.startDate,
            endDateSeason = model?.season?.endDate,
            currentMatchdaySeason = model?.season?.currentMatchday,
            winnerSeason = model?.season?.winner,
            idHomeTeam = model?.homeTeam?.id,
            nameHomeTeam = model?.homeTeam?.name,
            shortHomeTeam = model?.homeTeam?.shortName,
            tlaHomeTeam = model?.homeTeam?.tla,
            crestHomeTeam = model?.homeTeam?.crest,
            idAwayTeam = model?.awayTeam?.id,
            nameAwayTeam = model?.awayTeam?.name,
            shortAwayTeam = model?.awayTeam?.shortName,
            tlaAwayTeam = model?.awayTeam?.tla,
            crestAwayTeam = model?.awayTeam?.crest,
            winScore = model?.score?.winner,
            durationScore = model?.score?.duration,
            fullTimeHomeScore = model?.score?.fullTime?.home,
            fullTimeAwayScore = model?.score?.fullTime?.away,
            halfTimeHomeScore = model?.score?.halfTime?.home,
            halfTimeAwayScore = model?.score?.halfTime?.away,
        )
    }
}