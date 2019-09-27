/*
 * Copyright (c) Ashish , 2019
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.unidirectionalstateflow.di

import android.app.Application
import androidx.room.Room
import com.example.unidirectionalstateflow.BuildConfig
import com.example.unidirectionalstateflow.data.local.SharedPrefsSource
import com.example.unidirectionalstateflow.data.local.SharedPrefsSourceImpl
import com.example.unidirectionalstateflow.data.local.db.AppDataBase
import com.example.unidirectionalstateflow.data.local.db.ClanDao
import com.example.unidirectionalstateflow.data.remote.RemoteDataSource
import com.example.unidirectionalstateflow.data.remote.retrofit.ClanService
import com.example.unidirectionalstateflow.data.remote.retrofit.MockInterceptor
import com.example.unidirectionalstateflow.data.remote.retrofit.RetrofitDataSource
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
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
    fun providesRemoteDataSource(clanService: ClanService): RemoteDataSource =
        RetrofitDataSource(clanService)

    @Provides
    @Singleton
    fun providesSharedPrefsDataSource(): SharedPrefsSource =
        SharedPrefsSourceImpl()

    @Provides
    @Singleton
    fun provideConverterFactory(): Converter.Factory {
        val contentType = "application/json".toMediaType()
        return Json.asConverterFactory(contentType)
    }

    @Provides
    @Singleton
    fun providesRetrofit(
        converterFactory: Converter.Factory, client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(converterFactory)
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideGithubService(retrofit: Retrofit): ClanService {
        return retrofit.create(ClanService::class.java)
    }

    @Singleton
    @Provides
    fun provideOkhttpClient(app: Application): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor(MockInterceptor(BuildConfig.DEBUG, app.applicationContext.assets))
            .build()
    }

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }
}