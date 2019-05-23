package com.example.unidirectionalstateflow.di

import com.example.unidirectionalstateflow.data.local.db.ClanDbSource
import com.example.unidirectionalstateflow.data.remote.RemoteDataSource
import com.example.unidirectionalstateflow.data.local.SharedPrefsSource
import com.example.unidirectionalstateflow.domain.FetchClansUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    @Singleton
    fun providesFetchClanUseCase(
        remoteDataSource: RemoteDataSource,
        clanDbSource: ClanDbSource,
        sharedPrefsSource: SharedPrefsSource
    ): FetchClansUseCase = FetchClansUseCase(remoteDataSource, clanDbSource, sharedPrefsSource)
}