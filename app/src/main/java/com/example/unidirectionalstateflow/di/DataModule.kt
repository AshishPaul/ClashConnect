package com.example.unidirectionalstateflow.di

import com.example.unidirectionalstateflow.data.local.ClanDbSource
import com.example.unidirectionalstateflow.data.local.ClanClanDbSourceImpl
import com.example.unidirectionalstateflow.data.remote.RemoteDataSource
import com.example.unidirectionalstateflow.data.local.SharedPrefsSource
import com.example.unidirectionalstateflow.data.local.SharedPrefsSourceImpl
import com.example.unidirectionalstateflow.data.remote.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun providesRemoteDataSource() : RemoteDataSource =
        RemoteDataSourceImpl()

    @Provides
    @Singleton
    fun providesLocalDbDataSource() : ClanDbSource =
        ClanClanDbSourceImpl()

    @Provides
    @Singleton
    fun providesSharedPrefsDataSource() : SharedPrefsSource =
        SharedPrefsSourceImpl()
}