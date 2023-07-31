package com.example.liga.data.network.models.matches

import com.google.gson.annotations.SerializedName

data class Filters(

	@field:SerializedName("dateTo")
	val dateTo: String? = null,

	@field:SerializedName("permission")
	val permission: String? = null,

	@field:SerializedName("dateFrom")
	val dateFrom: String? = null
)