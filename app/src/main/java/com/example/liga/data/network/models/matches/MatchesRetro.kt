package com.example.liga.data.network.models.matches

import com.google.gson.annotations.SerializedName

data class MatchesRetro(

	@field:SerializedName("filters")
	val filters: Filters? = null,

	@field:SerializedName("matches")
	val matches: List<MatchesItem?>? = null,

	@field:SerializedName("resultSet")
	val resultSet: ResultSet? = null
)