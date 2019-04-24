package com.zerogravity.myapplication.di

import com.example.unidirectionalstateflow.data.LocalDbDataSource
import com.example.unidirectionalstateflow.data.RemoteDataSource
import com.example.unidirectionalstateflow.data.SharedPrefsDataSource
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