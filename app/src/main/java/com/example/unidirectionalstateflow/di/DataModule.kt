package com.example.unidirectionalstateflow.di

import com.example.unidirectionalstateflow.data.source.local.LocalDbDataSource
import com.example.unidirectionalstateflow.data.source.remote.RemoteDataSource
import com.example.unidirectionalstateflow.data.source.local.SharedPrefsDataSource
import com.example.unidirectionalstateflow.data.source.local.SharedPrefsDataSourceImpl
import com.example.unidirectionalstateflow.data.source.remote.RemoteDataSourceImpl
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
    fun providesLocalDbDataSource() : LocalDbDataSource =
        LocalDbDataSourceImpl()

    @Provides
    @Singleton
    fun providesSharedPrefsDataSource() : SharedPrefsDataSource =
        SharedPrefsDataSourceImpl()
}