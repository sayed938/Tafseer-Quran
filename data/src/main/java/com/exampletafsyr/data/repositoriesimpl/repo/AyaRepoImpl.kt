package com.exampletafsyr.data.repositoriesimpl.repo

import com.exampletafsyr.data.datasources.remote.service.AyaServices
import com.exampletafsyr.domain.entities.AyaDataModel
import com.exampletafsyr.domain.repositories.AyaRepo
import javax.inject.Inject

class AyaRepoImpl @Inject constructor(private var ayaSrevice: AyaServices) : AyaRepo {
    override suspend fun getAyaData(
        tafsyrType: String,
        suraNum: Int
    ): List<AyaDataModel> = ayaSrevice.getAyaDataRemote(tafsyrType, suraNum)
}