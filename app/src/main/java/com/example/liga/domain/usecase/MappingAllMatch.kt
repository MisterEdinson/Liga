package com.example.liga.domain.usecase

import com.example.liga.data.local.models.MatchesAllSave
import com.example.liga.data.network.models.matches.MatchesRetro

class MappingAllMatch {
    fun mappingMatchFromRoom(model:MatchesRetro) : MatchesAllSave{
        return MatchesAllSave(
            id = 0,
            idMatch = model.matches?.get(0)?.id,
            utcDateMatch = model.matches?.get(0)?.utcDate,
            statusMatch = model.matches?.get(0)?.status,
            matchdayMatch = model.matches?.get(0)?.matchday,
            stageMatch = model.matches?.get(0)?.stage,
            groupMatch = model.matches?.get(0)?.group,
            lastUpdatedMatch = model.matches?.get(0)?.lastUpdated,
            idArea = model.matches?.get(0)?.area?.id,
            nameArea = model.matches?.get(0)?.area?.name,
            codeArea = model.matches?.get(0)?.area?.code,
            flagArea = model.matches?.get(0)?.area?.flag,
            idCompetition = model.matches?.get(0)?.competition?.id,
            nameCompetition = model.matches?.get(0)?.competition?.name,
            codeCompetition = model.matches?.get(0)?.competition?.code,
            typeCompetition = model.matches?.get(0)?.competition?.type,
            emblemCompetition = model.matches?.get(0)?.competition?.emblem,
            idSeason = model.matches?.get(0)?.season?.id,
            startDateSeason = model.matches?.get(0)?.season?.startDate,
            endDateSeason = model.matches?.get(0)?.season?.endDate,
            currentMatchdaySeason = model.matches?.get(0)?.season?.currentMatchday,
            winnerSeason = model.matches?.get(0)?.season?.winner,
            idHomeTeam = model.matches?.get(0)?.homeTeam?.id,
            nameHomeTeam = model.matches?.get(0)?.homeTeam?.name,
            shortHomeTeam = model.matches?.get(0)?.homeTeam?.shortName,
            tlaHomeTeam = model.matches?.get(0)?.homeTeam?.tla,
            crestHomeTeam = model.matches?.get(0)?.homeTeam?.crest,
            idAwayTeam = model.matches?.get(0)?.awayTeam?.id,
            nameAwayTeam = model.matches?.get(0)?.awayTeam?.name,
            shortAwayTeam = model.matches?.get(0)?.awayTeam?.shortName,
            tlaAwayTeam = model.matches?.get(0)?.awayTeam?.tla,
            crestAwayTeam = model.matches?.get(0)?.awayTeam?.crest,
            winScore = model.matches?.get(0)?.score?.winner,
            durationScore = model.matches?.get(0)?.score?.duration,
            fullTimeHomeScore = model.matches?.get(0)?.score?.fullTime?.home,
            fullTimeAwayScore = model.matches?.get(0)?.score?.fullTime?.away,
            halfTimeHomeScore = model.matches?.get(0)?.score?.halfTime?.home,
            halfTimeAwayScore = model.matches?.get(0)?.score?.halfTime?.away,
        )
    }
}