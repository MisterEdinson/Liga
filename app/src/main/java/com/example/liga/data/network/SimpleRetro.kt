package com.example.liga.data.network

import com.example.liga.data.network.models.competitions.Competitons
import retrofit2.http.GET

interface SimpleRetro {
    @GET("competitions")
    suspend fun getCompetitions() : Competitons
}