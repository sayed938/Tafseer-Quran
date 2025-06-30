package com.exampletafsyr.data.repositoriesimpl.di

import com.exampletafsyr.data.datasources.remote.service.AyaServices
import com.exampletafsyr.data.repositoriesimpl.repo.AyaRepoImpl
import com.exampletafsyr.domain.repositories.AyaRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AyaRepoModule {

    @Provides
    @Singleton
    fun provideAyaRepoImpl(ayaServices: AyaServices): AyaRepo = AyaRepoImpl(ayaServices)
}