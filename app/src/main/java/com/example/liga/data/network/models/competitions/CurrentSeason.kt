package com.example.liga.data.network.models.competitions

import com.google.gson.annotations.SerializedName

data class CurrentSeason(

	@field:SerializedName("winner")
	val winner: Any? = null,

	@field:SerializedName("currentMatchday")
	val currentMatchday: Int? = null,

	@field:SerializedName("endDate")
	val endDate: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("startDate")
	val startDate: String? = null
)