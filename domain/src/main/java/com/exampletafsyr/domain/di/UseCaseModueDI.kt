package com.exampletafsyr.domain.di

import com.exampletafsyr.domain.repositories.AyaRepo
import com.exampletafsyr.domain.usecase.TafsyrUseCase
import com.exampletafsyr.domain.usecase.TafsyrUseCaseRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModuleDI {
    @Provides
    @Singleton
    fun provideTafsyrUSeCase(tafsyr: AyaRepo): TafsyrUseCaseRepo = TafsyrUseCase(tafsyr)
}