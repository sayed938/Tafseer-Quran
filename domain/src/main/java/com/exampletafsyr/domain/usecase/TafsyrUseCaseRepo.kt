package com.exampletafsyr.domain.usecase

import com.exampletafsyr.domain.entities.AyaDataModel

interface TafsyrUseCaseRepo {
    suspend fun getTafsyrUseCase(
        tafsyrType: String,
        suraNum: Int
    ): List<AyaDataModel>
}