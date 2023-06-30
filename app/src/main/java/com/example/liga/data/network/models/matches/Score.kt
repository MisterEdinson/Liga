package com.example.liga.data.network.models.matches

import com.google.gson.annotations.SerializedName

data class Score(

	@field:SerializedName("duration")
	val duration: String? = null,

	@field:SerializedName("winner")
	val winner: String? = null,

	@field:SerializedName("halfTime")
	val halfTime: HalfTime? = null,

	@field:SerializedName("fullTime")
	val fullTime: FullTime? = null
)