package com.example.liga.data.network.models.teams

import com.google.gson.annotations.SerializedName

data class Coach(

	@field:SerializedName("firstName")
	val firstName: String? = null,

	@field:SerializedName("lastName")
	val lastName: String? = null,

	@field:SerializedName("nationality")
	val nationality: String? = null,

	@field:SerializedName("contract")
	val contract: Contract? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("dateOfBirth")
	val dateOfBirth: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)