package com.zerogravity.myapplication.di

import com.example.unidirectionalstateflow.data.source.local.LocalDbDataSource
import com.example.unidirectionalstateflow.data.source.remote.RemoteDataSource
import com.example.unidirectionalstateflow.data.source.local.SharedPrefsDataSource
import com.example.unidirectionalstateflow.domain.FetchClansUseCase
import com.example.unidirectionalstateflow.domain.FetchClansUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    @Singleton
    fun providesFetchClanUseCase(
        localDbDataSource: LocalDbDataSource,
        sharedPrefsDataSource: SharedPrefsDataSource,
        remoteDataSource: RemoteDataSource
    ): FetchClansUseCase = FetchClansUseCaseImpl(localDbDataSource, sharedPrefsDataSource, remoteDataSource)
}