package com.example.liga.data.network.models.matches

import com.google.gson.annotations.SerializedName

data class FullTime(

	@field:SerializedName("away")
	val away: Int? = null,

	@field:SerializedName("home")
	val home: Int? = null
)