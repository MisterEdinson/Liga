package com.example.liga.data.network.models.matches

import com.google.gson.annotations.SerializedName

data class ResultSet(

	@field:SerializedName("last")
	val last: String? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("competitions")
	val competitions: String? = null,

	@field:SerializedName("played")
	val played: Int? = null,

	@field:SerializedName("first")
	val first: String? = null
)