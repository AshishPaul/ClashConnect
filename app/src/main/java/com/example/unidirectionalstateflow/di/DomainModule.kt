package com.example.unidirectionalstateflow.di

import com.example.unidirectionalstateflow.data.repository.ClanRepository
import com.example.unidirectionalstateflow.domain.FetchClansUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    @Singleton
    fun providesFetchClanUseCase(clanRepository: ClanRepository): FetchClansUseCase = FetchClansUseCase(clanRepository)
}