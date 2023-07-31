package com.example.liga.domain.usecase

import com.example.liga.data.local.models.MatchesDaoModel
import com.example.liga.data.network.models.matches.MatchesRetro
import com.google.gson.Gson

class MapperMatchDay {
    fun mappingMatchToDaoModel(matchNetwork: MatchesRetro?) : MatchesDaoModel{
        val gson = Gson()
        val table = gson.toJson(matchNetwork?.matches)
        return MatchesDaoModel(
            id = 0,
            filterPerm = matchNetwork?.filters?.permission,
            resCount = matchNetwork?.resultSet?.count,
            resCompetitions = matchNetwork?.resultSet?.competitions,
            resFirst = matchNetwork?.resultSet?.first,
            resLast = matchNetwork?.resultSet?.last,
            match = table,
        )
    }
}