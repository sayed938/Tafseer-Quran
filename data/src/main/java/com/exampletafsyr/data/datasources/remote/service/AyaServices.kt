package com.exampletafsyr.data.datasources.remote.service

import com.exampletafsyr.domain.entities.AyaDataModel
import retrofit2.http.GET
import retrofit2.http.Path

interface AyaServices {
    @GET("aya/{slug}/{sura_number}/1/286")
    suspend fun getAyaDataRemote(
        @Path("slug") slug: String,
        @Path("sura_number") sura_number: Int
    ): List<AyaDataModel>
}