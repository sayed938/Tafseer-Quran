package com.exampletafsyr.domain.repositories

import com.exampletafsyr.domain.entities.AyaDataModel

interface AyaRepo {
    suspend fun getAyaData(tafsyrType: String, suraNum: Int): List<AyaDataModel>
}