package com.example.unidirectionalstateflow.di

import com.example.unidirectionalstateflow.data.LocalDbDataSource
import com.example.unidirectionalstateflow.data.RemoteDataSource
import com.example.unidirectionalstateflow.data.SharedPrefsDataSource
import com.example.unidirectionalstateflow.data.local.LocalDbDataSourceImpl
import com.example.unidirectionalstateflow.data.local.SharedPrefsDataSourceImpl
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
    fun providesLocalDbDataSource() : LocalDbDataSource =
        LocalDbDataSourceImpl()

    @Provides
    @Singleton
    fun providesSharedPrefsDataSource() : SharedPrefsDataSource =
        SharedPrefsDataSourceImpl()
}