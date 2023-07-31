package com.example.liga.data.network.models.competitions

import com.google.gson.annotations.SerializedName

data class Competitons(

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("competitions")
	val competitions: List<CompetitionsItem?>? = null,

	@field:SerializedName("filters")
	val filters: Filters? = null
)