package com.example.liga.data.network.models.teams

import com.google.gson.annotations.SerializedName

data class Contract(

	@field:SerializedName("start")
	val start: String? = null,

	@field:SerializedName("until")
	val until: String? = null
)