package com.exampletafsyr.domain.usecase

import com.exampletafsyr.domain.entities.AyaDataModel
import com.exampletafsyr.domain.repositories.AyaRepo
import javax.inject.Inject

class TafsyrUseCase @Inject constructor(private var ayaRepo: AyaRepo): TafsyrUseCaseRepo {
    override suspend fun getTafsyrUseCase(
        tafsyrType: String,
        suraNum: Int
    ): List<AyaDataModel> =ayaRepo.getAyaData(tafsyrType,suraNum)
}