package com.example.unidirectionalstateflow.di

import android.app.Application
import androidx.room.Room
import com.example.unidirectionalstateflow.data.local.SharedPrefsSource
import com.example.unidirectionalstateflow.data.local.SharedPrefsSourceImpl
import com.example.unidirectionalstateflow.data.local.db.AppDataBase
import com.example.unidirectionalstateflow.data.local.db.ClanDao
import com.example.unidirectionalstateflow.data.remote.RemoteDataSource
import com.example.unidirectionalstateflow.data.remote.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideDb(app: Application): AppDataBase {
        return Room
            .databaseBuilder(app, AppDataBase::class.java, "clash_connect.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db: AppDataBase): ClanDao {
        return db.clanDao()
    }

    @Provides
    @Singleton
    fun providesRemoteDataSource() : RemoteDataSource =
        RemoteDataSourceImpl()

    @Provides
    @Singleton
    fun providesSharedPrefsDataSource() : SharedPrefsSource =
        SharedPrefsSourceImpl()
}