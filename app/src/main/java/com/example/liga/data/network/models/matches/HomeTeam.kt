package com.example.liga.data.network.models.matches

import com.google.gson.annotations.SerializedName

data class HomeTeam(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("tla")
	val tla: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("shortName")
	val shortName: String? = null,

	@field:SerializedName("crest")
	val crest: String? = null
)