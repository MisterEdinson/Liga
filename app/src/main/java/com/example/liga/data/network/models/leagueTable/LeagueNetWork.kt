package com.example.liga.data.network.models.leagueTable

data class LeagueNetWork(
	val area: Area? = null,
	val season: Season? = null,
	val competition: Competition? = null,
	val filters: Filters? = null,
	val standings: List<StandingsItem?>? = null
)
